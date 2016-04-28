package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.ParentescoDAO;
import br.pro.gestao.rh.domain.Parentesco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ParentescoBean implements Serializable {
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

	public void novo() {
		parentesco = new Parentesco();
	}

	@PostConstruct
	public void listar() {
		try {
			ParentescoDAO parentescoDAO = new ParentescoDAO();
			parentescos = parentescoDAO.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Parentesco!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			ParentescoDAO parentescoDAO = new ParentescoDAO();
			parentescoDAO.merge(parentesco);

			parentesco = new Parentesco();
			parentescos = parentescoDAO.listar("nome");

			Messages.addGlobalInfo("Gravação Efeutada com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Salvar Parentesco!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			parentesco = (Parentesco) evento.getComponent().getAttributes().get("parentescoSelecionado");

			ParentescoDAO parentescoDAO = new ParentescoDAO();
			parentescoDAO.excluir(parentesco);

			parentescos = parentescoDAO.listar("nome");
		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Excluir o Parentesco!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		parentesco = (Parentesco) evento.getComponent().getAttributes().get("parentescoSelecionado");
	}
}
