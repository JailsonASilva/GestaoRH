package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.BancoDAO;
import br.pro.gestao.rh.domain.Banco;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BancoBean implements Serializable {
	private Banco banco;
	private List<Banco> bancos;
	
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public List<Banco> getBancos() {
		return bancos;
	}
	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}
	
	@PostConstruct
	public void listar() {
		try {
			BancoDAO bancoDAO = new BancoDAO();
			bancos = bancoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Bancos");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		banco = new Banco();
	}

	public void salvar() {
		try {
			BancoDAO bancoDAO = new BancoDAO();
			bancoDAO.merge(banco);

			banco = new Banco();
			bancos = bancoDAO.listar("nome");

			Messages.addGlobalInfo("Banco salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Banco");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			banco = (Banco) evento.getComponent().getAttributes().get("bancoSelecionado");

			BancoDAO bancoDAO = new BancoDAO();
			bancoDAO.excluir(banco);
			
			bancos = bancoDAO.listar("nome");

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Banco");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		banco = (Banco) evento.getComponent().getAttributes().get("bancoSelecionado");
	}	

}
