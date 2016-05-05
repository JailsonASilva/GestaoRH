package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.SindicatoDAO;
import br.pro.gestao.rh.domain.Sindicato;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class SindicatoBean implements Serializable {
	private Sindicato sindicato;
	private List<Sindicato> sindicatos;

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public List<Sindicato> getSindicatos() {
		return sindicatos;
	}

	public void setSindicatos(List<Sindicato> sindicatos) {
		this.sindicatos = sindicatos;
	}

	public void novo() {
		sindicato = new Sindicato();
	}

	@PostConstruct
	public void listar() {
		try {
			SindicatoDAO sindicatoDAO = new SindicatoDAO();
			sindicatos = sindicatoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar Sindicatos!");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			SindicatoDAO sindicatoDAO = new SindicatoDAO();
			sindicatoDAO.merge(sindicato);

			sindicatos = sindicatoDAO.listar("nome");

			novo();

			Messages.addGlobalInfo("Sindicato Salvo com Sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Salvar Sindicatos!");
			erro.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			sindicato = (Sindicato) evento.getComponent().getAttributes().get("sindicatoSelecionado");
			
			SindicatoDAO sindicatoDAO = new SindicatoDAO();
			sindicatoDAO.excluir(sindicato);

			sindicatos = sindicatoDAO.listar("nome");	
			
			Messages.addGlobalInfo("Sindicato Excluído com Sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Selecionar Sindicato!");
			erro.printStackTrace();
		}			
	}
	
	public void editar(ActionEvent evento) {
		try {
			sindicato = (Sindicato) evento.getComponent().getAttributes().get("sindicatoSelecionado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Selecionar Sindicato!");
			erro.printStackTrace();
		}		
	}

}
