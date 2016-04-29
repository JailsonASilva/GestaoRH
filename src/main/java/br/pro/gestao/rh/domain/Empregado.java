package br.pro.gestao.rh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Empregado extends GenericDomain {
	@Column(nullable = false)
	private Long numeroOrdem;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 40, nullable = false)
	private String numeroMatricula;
	
	@Column(length = 100, nullable = true)
	private String pai;
	
	@Column(length = 100, nullable = false)
	private String mae;
	
	@Column(length = 60, nullable = false)
	private String nacionalidade;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)	
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(nullable = false)	
	private EstadoCivil estaoCivil;
	
	@ManyToOne
	@JoinColumn(nullable = false)		
	private Cidade localNascimento;
	
	@Column(length = 60, nullable = false)	
	private String identidade;
	
	@Column(length = 60, nullable = false)	
	private String carteiraProfissional;
	
	@Column(length = 20, nullable = true)	
	private String serie;
	
	@Column(length = 60, nullable = true)		
	private String carteiraReservista;
	
	@Column(length = 30, nullable = true)
	private String categoria;
	
	@Column(length = 15, nullable = false)	
	private String cpf;
	
	@Column(length = 60, nullable = false)	
	private String tituloEleitor;
	
	@Column(length = 60, nullable = true)	
	private String carteiraSaude;
	
	@Column(length = 100, nullable = false)	
	private String endereco;
	
	@Column(length = 20, nullable = false)	
	private String cep;
	
	@ManyToOne
	@JoinColumn(nullable = false)			
	private Bairro bairro;
	
	@Column(length = 10, nullable = false)	
	private String numero;
	
	@Column(length = 60, nullable = true)
	private String complemento;
	
	@Column(length = 80, nullable = true)
	private String email;
	
	@Column(length = 30, nullable = true)
	private String telefone;
	
	@Column(length = 30, nullable = true)
	private String celular1;
	
	@Column(length = 30, nullable = true)
	private String celular2;
	
	@Column(length = 100, nullable = true)
	private String observacao;
	
	@Column(length = 30, nullable = true)
	private String cor;
	
	@Column(nullable = true, precision = 6, scale = 2)
	private Float altura;
	
	@Column(nullable = true, precision = 6, scale = 2)
	private Float peso;
	
	@Column(length = 30, nullable = true)
	private String cabelo;
	
	@Column(length = 30, nullable = true)
	private String olhos;
	
	@Column(length = 30, nullable = true)
	private String sinais;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)	
	private Date dataAdmissao;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)	
	private Date dataDemissao;
	
	@Column(length = 50, nullable = false)
	private Cargo cargo;
	
	@Column(length = 30, nullable = true)
	private String secao;
	
	@Column(nullable = true, precision = 6, scale = 2)
	private Float salario;
	
	@Column(nullable = true, precision = 6, scale = 2)
	private Float comissao;
	
	@Column(length = 50, nullable = true)
	private String tarefa;
	
	@Column(length = 50, nullable = true)
	private String formaPagamento;
	
	@Column(nullable = true)
	private Boolean optante;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)	
	private Date dataOpcao;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)	
	private Date dataRetracao;
	
	@ManyToOne
	@JoinColumn(nullable = true)		
	private Banco bancoFgts;
	
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)		
	private Date cadastroPis;
	
	@Column(nullable = true)
	private String numeroPis;
	
	@ManyToOne
	@JoinColumn(nullable = true)	
	private Banco bancoPis;
	
	@Column(nullable = true)
	private String agencia;
	
	@Column(nullable = true)
	private String enderecoBanco;	
	
	public Long getNumeroOrdem() {
		return numeroOrdem;
	}
	public void setNumeroOrdem(Long numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getMae() {
		return mae;
	}
	public void setMae(String mae) {
		this.mae = mae;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public EstadoCivil getEstaoCivil() {
		return estaoCivil;
	}
	public void setEstaoCivil(EstadoCivil estaoCivil) {
		this.estaoCivil = estaoCivil;
	}
	public Cidade getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(Cidade localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getIdentidade() {
		return identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getCarteiraProfissional() {
		return carteiraProfissional;
	}
	public void setCarteiraProfissional(String carteiraProfissional) {
		this.carteiraProfissional = carteiraProfissional;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getCarteiraReservista() {
		return carteiraReservista;
	}
	public void setCarteiraReservista(String carteiraReservista) {
		this.carteiraReservista = carteiraReservista;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	public String getCarteiraSaude() {
		return carteiraSaude;
	}
	public void setCarteiraSaude(String carteiraSaude) {
		this.carteiraSaude = carteiraSaude;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular1() {
		return celular1;
	}
	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}
	public String getCelular2() {
		return celular2;
	}
	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String getCabelo() {
		return cabelo;
	}
	public void setCabelo(String cabelo) {
		this.cabelo = cabelo;
	}
	public String getOlhos() {
		return olhos;
	}
	public void setOlhos(String olhos) {
		this.olhos = olhos;
	}
	public String getSinais() {
		return sinais;
	}
	public void setSinais(String sinais) {
		this.sinais = sinais;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public Float getSalario() {
		return salario;
	}
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	public Float getComissao() {
		return comissao;
	}
	public void setComissao(Float comissao) {
		this.comissao = comissao;
	}
	public String getTarefa() {
		return tarefa;
	}
	public void setTarefa(String tarefa) {
		this.tarefa = tarefa;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public Boolean getOptante() {
		return optante;
	}
	public void setOptante(Boolean optante) {
		this.optante = optante;
	}
	public Date getDataOpcao() {
		return dataOpcao;
	}
	public void setDataOpcao(Date dataOpcao) {
		this.dataOpcao = dataOpcao;
	}
	public Date getDataRetracao() {
		return dataRetracao;
	}
	public void setDataRetracao(Date dataRetracao) {
		this.dataRetracao = dataRetracao;
	}
	public Banco getBancoFgts() {
		return bancoFgts;
	}
	public void setBancoFgts(Banco bancoFgts) {
		this.bancoFgts = bancoFgts;
	}
	public Date getCadastroPis() {
		return cadastroPis;
	}
	public void setCadastroPis(Date cadastroPis) {
		this.cadastroPis = cadastroPis;
	}
	public String getNumeroPis() {
		return numeroPis;
	}
	public void setNumeroPis(String numeroPis) {
		this.numeroPis = numeroPis;
	}
	public Banco getBancoPis() {
		return bancoPis;
	}
	public void setBancoPis(Banco bancoPis) {
		this.bancoPis = bancoPis;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getEnderecoBanco() {
		return enderecoBanco;
	}
	public void setEnderecoBanco(String enderecoBanco) {
		this.enderecoBanco = enderecoBanco;
	}
}
