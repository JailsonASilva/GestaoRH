package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.HorarioDAO;
import br.pro.gestao.rh.domain.Horario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class HorarioBean implements Serializable {
	private Horario horario;
	private List<Horario> horarios;

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public void novo() {
		horario = new Horario();
	}

	@PostConstruct
	public void listar() {
		try {
			HorarioDAO horarioDAO = new HorarioDAO();
			horarios = horarioDAO.listar("nome");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Horários");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			HorarioDAO horarioDAO = new HorarioDAO();
			horarioDAO.merge(horario);

			horario = new Horario();
			horarios = horarioDAO.listar("nome");

			Messages.addGlobalInfo("Horario Salvo com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Salvar Horário!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			horario = (Horario) evento.getComponent().getAttributes().get("horarioSelecionado");

			HorarioDAO horarioDAO = new HorarioDAO();
			horarioDAO.excluir(horario);

			horarios = horarioDAO.listar("nome");

			Messages.addGlobalInfo("Exclusão Efetuada com Sucesso!");

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Excluir Horário!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		horario = (Horario) evento.getComponent().getAttributes().get("horarioSelecionado");
	}
}
