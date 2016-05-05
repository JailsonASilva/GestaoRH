package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.LocalDAO;
import br.pro.gestao.rh.domain.Local;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class LocalBean implements Serializable {
	private Local local;
	private List<Local> locais;

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public void novo() {
		local = new Local();
	}

	@PostConstruct
	public void listar() {
		try {
			LocalDAO cargoDao = new LocalDAO();
			locais = cargoDao.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Cargos");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			LocalDAO localDAO = new LocalDAO();
			localDAO.merge(local);

			local = new Local();
			locais = localDAO.listar("nome");

			Messages.addGlobalInfo("Local Salvo com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Salvar Local!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			local = (Local) evento.getComponent().getAttributes().get("localSelecionado");

			LocalDAO localDAO = new LocalDAO();
			localDAO.excluir(local);

			locais = localDAO.listar("nome");

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Excluir Local!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		local = (Local) evento.getComponent().getAttributes().get("localSelecionado");
	}

}
