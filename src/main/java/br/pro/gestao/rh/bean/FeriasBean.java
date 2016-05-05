package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.EmpregadoDAO;
import br.pro.gestao.rh.dao.FeriasDAO;
import br.pro.gestao.rh.domain.Empregado;
import br.pro.gestao.rh.domain.Ferias;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FeriasBean implements Serializable {
	private Ferias ferias;
	private List<Ferias> feriasList;

	private Empregado empregado;
	private List<Empregado> empregados;

	public Ferias getFerias() {
		return ferias;
	}

	public void setFerias(Ferias ferias) {
		this.ferias = ferias;
	}

	public List<Ferias> getFeriasList() {
		return feriasList;
	}

	public void setFeriasList(List<Ferias> feriasList) {
		this.feriasList = feriasList;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public void novo() {
		ferias = new Ferias();
		ferias.setEmpregado(empregado);
	}

	@PostConstruct
	public void listarEmpregados() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregados = empregadoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar Empregados!");
			erro.printStackTrace();
		}
	}

	public void listarBeneficiarios() {
		try {
			if (empregado != null) {
				FeriasDAO feriasDAO = new FeriasDAO();
				feriasList = feriasDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				feriasList = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar Férias");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			FeriasDAO feriasDAO = new FeriasDAO();
			feriasDAO.merge(ferias);

			if (empregado != null) {
				feriasList = feriasDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				feriasList = new ArrayList<>();
			}

			ferias = new Ferias();

			Messages.addGlobalInfo("Férias salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Férias!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			ferias = (Ferias) evento.getComponent().getAttributes().get("feriasSelecionado");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Empregado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			ferias = (Ferias) evento.getComponent().getAttributes().get("feriasSelecionado");

			FeriasDAO feriasDAO = new FeriasDAO();
			feriasDAO.excluir(ferias);

			Messages.addGlobalInfo("Férias Excluído com sucesso");

			if (empregado != null) {
				feriasList = feriasDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				feriasList = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Excluir um Férias");
			erro.printStackTrace();
		}
	}
}
