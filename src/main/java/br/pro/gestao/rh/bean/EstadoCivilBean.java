package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.EstadoCivilDAO;
import br.pro.gestao.rh.domain.EstadoCivil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoCivilBean implements Serializable  {
	private EstadoCivil estadocivil;
	private List<EstadoCivil> estados;
	
	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}
	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}
	public List<EstadoCivil> getEstados() {
		return estados;
	}
	public void setEstados(List<EstadoCivil> estados) {
		this.estados = estados;
	}
	
	@PostConstruct
	public void listar() {
		try {
			EstadoCivilDAO EstadoCivilDAO = new EstadoCivilDAO();
			estados = EstadoCivilDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os Estados Civis");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		estadocivil = new EstadoCivil();
	}

	public void salvar() {
		try {
			EstadoCivilDAO EstadoCivilDAO = new EstadoCivilDAO();
			EstadoCivilDAO.merge(estadocivil);

			estadocivil = new EstadoCivil();
			estados = EstadoCivilDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estadocivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoSelecionado");

			EstadoCivilDAO EstadoCivilDAO = new EstadoCivilDAO();
			EstadoCivilDAO.excluir(estadocivil);
			
			estados = EstadoCivilDAO.listar();

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Estado");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		estadocivil = (EstadoCivil) evento.getComponent().getAttributes().get("estadoSelecionado");
	}
	
	
}