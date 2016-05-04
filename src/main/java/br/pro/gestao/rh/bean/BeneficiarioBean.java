package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.BeneficiarioDAO;
import br.pro.gestao.rh.dao.EmpregadoDAO;
import br.pro.gestao.rh.dao.ParentescoDAO;
import br.pro.gestao.rh.domain.Beneficiario;
import br.pro.gestao.rh.domain.Empregado;
import br.pro.gestao.rh.domain.Parentesco;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class BeneficiarioBean implements Serializable {
	private Beneficiario beneficiario;
	private List<Beneficiario> beneficiarios;

	private Empregado empregado;
	private List<Empregado> empregados;

	private Parentesco parentesco;
	private List<Parentesco> parentescos;

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}

	public List<Parentesco> getParentescos() {
		return parentescos;
	}

	public void setParentescos(List<Parentesco> parentescos) {
		this.parentescos = parentescos;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public List<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
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
		beneficiario = new Beneficiario();
		beneficiario.setEmpregado(empregado);
	}

	@PostConstruct
	public void listarEmpregados() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregados = empregadoDAO.listar("nome");

			ParentescoDAO parentescoDAO = new ParentescoDAO();
			parentescos = parentescoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar Empregados!");
			erro.printStackTrace();
		}
	}

	public void listarBeneficiarios() {
		try {
			if (empregado != null) {
				BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
				beneficiarios = beneficiarioDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				beneficiarios = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar Beneficiários");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
			beneficiarioDAO.merge(beneficiario);

			if (empregado != null) {
				beneficiarios = beneficiarioDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				beneficiarios = new ArrayList<>();
			}

			beneficiario = new Beneficiario();

			Messages.addGlobalInfo("Beneficiário salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Beneficiário!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			beneficiario = (Beneficiario) evento.getComponent().getAttributes().get("beneficiarioSelecionado");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Empregado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			beneficiario = (Beneficiario) evento.getComponent().getAttributes().get("beneficiarioSelecionado");

			BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
			beneficiarioDAO.excluir(beneficiario);

			Messages.addGlobalInfo("Beneficiário Excluído com sucesso");

			if (empregado != null) {
				beneficiarios = beneficiarioDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				beneficiarios = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Excluir um Beneficiário");
			erro.printStackTrace();
		}
	}

}
