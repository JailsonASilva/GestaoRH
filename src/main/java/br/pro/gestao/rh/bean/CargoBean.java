package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.CargoDAO;
import br.pro.gestao.rh.domain.Cargo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CargoBean implements Serializable {
	private Cargo cargo;
	private List<Cargo> cargos;

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public void novo() {
		cargo = new Cargo();
	}

	@PostConstruct
	public void listar() {
		try {
			CargoDAO cargoDao = new CargoDAO();
			cargos = cargoDao.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Cargos");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.merge(cargo);
			
			cargo = new Cargo();
			cargos = cargoDAO.listar("nome");

			Messages.addGlobalInfo("Cargo Salvo com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Salvar Cargo!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cargo = (Cargo) evento.getComponent().getAttributes().get("cargoSelecionado");

			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.excluir(cargo);

			cargos = cargoDAO.listar("nome");

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Excluir Cargo!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		cargo = (Cargo) evento.getComponent().getAttributes().get("cargoSelecionado");
	}
}
