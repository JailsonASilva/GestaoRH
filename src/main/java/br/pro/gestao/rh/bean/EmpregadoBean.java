package br.pro.gestao.rh.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.omnifaces.util.Messages;

import br.pro.gestao.rh.dao.BairroDAO;
import br.pro.gestao.rh.dao.CidadeDAO;
import br.pro.gestao.rh.dao.EmpregadoDAO;
import br.pro.gestao.rh.domain.Bairro;
import br.pro.gestao.rh.domain.Banco;
import br.pro.gestao.rh.domain.Cargo;
import br.pro.gestao.rh.domain.Cidade;
import br.pro.gestao.rh.domain.Empregado;
import br.pro.gestao.rh.domain.Estado;
import br.pro.gestao.rh.domain.EstadoCivil;
import br.pro.gestao.rh.util.HibernateUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmpregadoBean implements Serializable {
	private Empregado empregado;
	private List<Empregado> empregados;

	private Estado estado;
	private List<Estado> estados;

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Cidade> cidadesNasc;

	private Session sessao;

	private Bairro bairro;
	private List<Bairro> bairros;

	private EstadoCivil civil;
	private List<EstadoCivil> estadoCivis;

	private Banco banco;
	private List<Banco> bancos;

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

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

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

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

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

	public EstadoCivil getCivil() {
		return civil;
	}

	public void setCivil(EstadoCivil civil) {
		this.civil = civil;
	}

	public List<EstadoCivil> getEstadoCivis() {
		return estadoCivis;
	}

	public void setEstadoCivis(List<EstadoCivil> estadoCivis) {
		this.estadoCivis = estadoCivis;
	}

	public List<Cidade> getCidadesNasc() {
		return cidadesNasc;
	}

	public void setCidadesNasc(List<Cidade> cidadesNasc) {
		this.cidadesNasc = cidadesNasc;
	}

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	public Session getSessao() {
		return sessao;
	}

	@PostConstruct
	public void listar() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregados = empregadoDAO.listar("nome");

			sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Listar Empregados!");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			empregado = new Empregado();

			estado = new Estado();
			cidade = new Cidade();
			bairro = new Bairro();
			banco = new Banco();
			cargo = new Cargo();
			civil = new EstadoCivil();

			ListarFE();

		} catch (Exception erro) {
			Messages.addGlobalError("Erro ao Gerar Novo Empregado!");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			empregado = (Empregado) evento.getComponent().getAttributes().get("empregadoSelecionado");

			cidade = empregado.getBairro().getCidade();
			estado = empregado.getBairro().getCidade().getEstado();

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar selecionar um Empregado");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregadoDAO.merge(empregado);

			empregados = empregadoDAO.listar("nome");

			empregado = new Empregado();

			cidades = new ArrayList<>();

			bairros = new ArrayList<>();

			Messages.addGlobalInfo("Pessoa salva com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			empregado = (Empregado) evento.getComponent().getAttributes().get("empregadoSelecionado");

			EmpregadoDAO empregadoDAO = new EmpregadoDAO();
			empregadoDAO.excluir(empregado);

			empregados = empregadoDAO.listar("nome");

			Messages.addGlobalInfo("Empregado removido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Empregado");
			erro.printStackTrace();
		}
	}

	public void popularCidade() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades");
			erro.printStackTrace();
		}
	}

	public void popularBairro() {
		try {
			if (cidade != null) {
				BairroDAO bairroDAO = new BairroDAO();
				bairros = bairroDAO.buscarPorCidade(cidade.getCodigo());
			} else {
				bairros = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as Bairros");
			erro.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@RequestScoped
	public void ListarFE() {
		try {
			if (sessao.isOpen() == false) {
				sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			}

			Criteria consulta = sessao.createCriteria(Estado.class);
			consulta.addOrder(Order.asc("nome"));

			estados = consulta.list();

			consulta = sessao.createCriteria(Cargo.class);
			consulta.addOrder(Order.asc("nome"));

			cargos = consulta.list();

			consulta = sessao.createCriteria(EstadoCivil.class);
			consulta.addOrder(Order.asc("nome"));

			estadoCivis = consulta.list();

			consulta = sessao.createCriteria(Banco.class);
			consulta.addOrder(Order.asc("nome"));

			bancos = consulta.list();

			consulta = sessao.createCriteria(Cidade.class);
			consulta.addOrder(Order.asc("nome"));

			cidadesNasc = consulta.list();

			cidades = new ArrayList<>();

			bairros = new ArrayList<>();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao Abrir Tabelas!");
		}

		finally {
			sessao.close();
		}
	}

	public void fecharConexao() {
		if (sessao.isOpen() == true) {
			sessao.close();
		}
	}
}
