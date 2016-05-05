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
import br.pro.gestao.rh.dao.SindicalDAO;
import br.pro.gestao.rh.dao.SindicatoDAO;
import br.pro.gestao.rh.domain.Empregado;
import br.pro.gestao.rh.domain.Sindical;
import br.pro.gestao.rh.domain.Sindicato;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class SindicalBean implements Serializable {
	private Sindical sindical;
	private List<Sindical> sindicalList;
	
	private List<Sindicato> sindicatos;

	private Empregado empregado;
	private List<Empregado> empregados;

	public Sindical getSindical() {
		return sindical;
	}

	public void setSindical(Sindical sindical) {
		this.sindical = sindical;
	}

	public List<Sindical> getSindicalList() {
		return sindicalList;
	}

	public void setSindicalList(List<Sindical> sindicalList) {
		this.sindicalList = sindicalList;
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
		sindical = new Sindical();
		sindical.setEmpregado(empregado);
	}

	@PostConstruct
	public void listarEmpregados() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregados = empregadoDAO.listar("nome");
			
			SindicatoDAO sindicatoDAO = new SindicatoDAO();
			sindicatos = sindicatoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar Empregados!");
			erro.printStackTrace();
		}
	}

	public void listarBeneficiarios() {
		try {
			if (empregado != null) {
				SindicalDAO sindicalDAO = new SindicalDAO();
				sindicalList = sindicalDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				sindicalList = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar Sindical");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			SindicalDAO sindicalDAO = new SindicalDAO();
			sindicalDAO.merge(sindical);

			if (empregado != null) {
				sindicalList = sindicalDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				sindicalList = new ArrayList<>();
			}

			sindical = new Sindical();

			Messages.addGlobalInfo("Sindical salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Sindical!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			sindical = (Sindical) evento.getComponent().getAttributes().get("sindicalSelecionado");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Empregado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			sindical = (Sindical) evento.getComponent().getAttributes().get("sindicalSelecionado");

			SindicalDAO sindicalDAO = new SindicalDAO();
			sindicalDAO.excluir(sindical);

			Messages.addGlobalInfo("Sindical Excluído com sucesso");

			if (empregado != null) {
				sindicalList = sindicalDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				sindicalList = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Excluir um Sindical");
			erro.printStackTrace();
		}
	}

	public List<Sindicato> getSindicatos() {
		return sindicatos;
	}

	public void setSindicatos(List<Sindicato> sindicatos) {
		this.sindicatos = sindicatos;
	}
}

