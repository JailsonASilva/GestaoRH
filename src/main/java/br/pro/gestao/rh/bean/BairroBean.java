package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.BairroDAO;
import br.pro.gestao.rh.dao.CidadeDAO;
import br.pro.gestao.rh.domain.Bairro;
import br.pro.gestao.rh.domain.Cidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BairroBean implements Serializable {
	private Bairro bairro;
	private List<Bairro> bairros;
	private List<Cidade> cidades;
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public List<Bairro> getBairros() {
		return bairros;
	}
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	@PostConstruct
	public void listar() {
		try {
			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listar("nome");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Bairros");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			bairro = new Bairro();

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao gerar um Novo Bairro");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			BairroDAO bairroDAO = new BairroDAO();
			bairroDAO.merge(bairro);

			bairro = new Bairro();

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar("nome");

			bairros = bairroDAO.listar("nome");

			Messages.addGlobalInfo("Bairro salvo com sucesso");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um novo Bairro");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionada");

			BairroDAO bairroDAO = new BairroDAO();
			bairroDAO.excluir(bairro);

			bairros = bairroDAO.listar("nome");

			Messages.addGlobalInfo("Bairro removida com sucesso");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Bairro");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		try {
			bairro = (Bairro) evento.getComponent().getAttributes().get("bairroSelecionada");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um bairro");
			erro.printStackTrace();
		}	
	}
}