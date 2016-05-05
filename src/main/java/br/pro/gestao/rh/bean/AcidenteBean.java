package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.AcidenteDAO;
import br.pro.gestao.rh.dao.CausaAcidenteDAO;
import br.pro.gestao.rh.dao.EmpregadoDAO;
import br.pro.gestao.rh.dao.LocalDAO;
import br.pro.gestao.rh.domain.Acidente;
import br.pro.gestao.rh.domain.CausaAcidente;
import br.pro.gestao.rh.domain.Empregado;
import br.pro.gestao.rh.domain.Local;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AcidenteBean implements Serializable {
	private Acidente acidente;
	private List<Acidente> acidentes;

	private Empregado empregado;
	private List<Empregado> empregados;

	private List<Local> locais;
	private List<CausaAcidente> causaAcidenteList;

	public Acidente getAcidente() {
		return acidente;
	}

	public void setAcidente(Acidente acidente) {
		this.acidente = acidente;
	}

	public List<Acidente> getAcidentes() {
		return acidentes;
	}

	public void setAcidentes(List<Acidente> acidentes) {
		this.acidentes = acidentes;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public List<Local> getLocais() {
		return locais;
	}

	public void setLocais(List<Local> locais) {
		this.locais = locais;
	}

	public List<CausaAcidente> getCausaAcidenteList() {
		return causaAcidenteList;
	}

	public void setCausaAcidenteList(List<CausaAcidente> causaAcidenteList) {
		this.causaAcidenteList = causaAcidenteList;
	}

	public void novo() {
		acidente = new Acidente();
		acidente.setEmpregado(empregado);
	}

	@PostConstruct
	public void listarEmpregados() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregados = empregadoDAO.listar("nome");
			
			CausaAcidenteDAO causaAcidenteDAO = new CausaAcidenteDAO();
			causaAcidenteList = causaAcidenteDAO.listar("nome");
			
			LocalDAO localDAO = new LocalDAO();
			locais = localDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Listar Empregados!");
			erro.printStackTrace();
		}
	}

	public void listarBeneficiarios() {
		try {
			if (empregado != null) {
				AcidenteDAO acidenteDAO = new AcidenteDAO();
				acidentes = acidenteDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				acidentes = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao Listar Acidente");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			AcidenteDAO acidenteDAO = new AcidenteDAO();
			acidenteDAO.merge(acidente);

			if (empregado != null) {
				acidentes = acidenteDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				acidentes = new ArrayList<>();
			}

			acidente = new Acidente();

			Messages.addGlobalInfo("Acidente salvo com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Acidente!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			acidente = (Acidente) evento.getComponent().getAttributes().get("acidenteSelecionado");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Empregado");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			acidente = (Acidente) evento.getComponent().getAttributes().get("acidenteSelecionado");

			AcidenteDAO acidenteDAO = new AcidenteDAO();
			acidenteDAO.excluir(acidente);

			Messages.addGlobalInfo("Acidente Excluído com sucesso");

			if (empregado != null) {
				acidentes = acidenteDAO.buscarPorEmpregado(empregado.getCodigo());
			} else {
				acidentes = new ArrayList<>();
			}

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar Excluir um Acidente");
			erro.printStackTrace();
		}
	}
}
