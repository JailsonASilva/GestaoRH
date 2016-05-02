package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.BeneficiarioDAO;
import br.pro.gestao.rh.domain.Beneficiario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class BeneficiarioBean implements Serializable {
	private Beneficiario beneficiario;
	private List<Beneficiario> beneficiarios;

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

	@PostConstruct
	public void listar() {
		try {
			BeneficiarioDAO beneficiarioDAO = new BeneficiarioDAO();
			beneficiarios = beneficiarioDAO.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Beneficiários!");
			erro.printStackTrace();
		}
	}

	public void novo() {

	}

	public void salvar() {

	}
}
