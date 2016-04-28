package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.CausaAcidenteDAO;
import br.pro.gestao.rh.domain.CausaAcidente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CausaAcidenteBean implements Serializable {
	private CausaAcidente causaAcidente;
	private List<CausaAcidente> causaAcidentes;

	public CausaAcidente getCausaAcidente() {
		return causaAcidente;
	}

	public void setCausaAcidente(CausaAcidente causaAcidente) {
		this.causaAcidente = causaAcidente;
	}

	public List<CausaAcidente> getCausaAcidentes() {
		return causaAcidentes;
	}

	public void setCausaAcidentes(List<CausaAcidente> causaAcidentes) {
		this.causaAcidentes = causaAcidentes;
	}

	public void novo() {
		causaAcidente = new CausaAcidente();
	}

	@PostConstruct
	public void listar() {
		try {
			CausaAcidenteDAO causaAcidenteDAO = new CausaAcidenteDAO();
			causaAcidentes = causaAcidenteDAO.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Causas de Acidentes!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CausaAcidenteDAO causaAcidenteDAO = new CausaAcidenteDAO();
			causaAcidenteDAO.merge(causaAcidente);

			causaAcidente = new CausaAcidente();
			causaAcidentes = causaAcidenteDAO.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Salvar Causa de Acidente!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			causaAcidente = (CausaAcidente) evento.getComponent().getAttributes().get("causaAcidenteSelecionado");

			CausaAcidenteDAO causaAcidenteDAO = new CausaAcidenteDAO();
			causaAcidenteDAO.excluir(causaAcidente);

			causaAcidentes = causaAcidenteDAO.listar("nome");

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Excluir Casua de Acidente!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		causaAcidente = (CausaAcidente) evento.getComponent().getAttributes().get("causaAcidenteSelecionado");
	}

}
