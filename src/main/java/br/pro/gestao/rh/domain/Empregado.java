package br.pro.gestao.rh.domain;

import java.util.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Empregado extends GenericDomain {
	private Long numeroOrdem;
	private String nome;
	private String numeroMatricula;
	private String pai;
	private String mae;
	private String nacionalidade;
	private Date dataNascimento;
	private EstadoCivil estaoCivil;
	private Cidade localNascimento;
	private String identidade;
	private String carteiraProfissional;
	private String serie;
	private String carteiraReservista;
	private String categoria;
	private String cpf;
	private String tituloEleitor;
	private String carteiraSaude;
	private String endereco;
	private String cep;
	private Estado estado;
	private Cidade cidade;
	private Bairro bairro;
	private String numero;
	private String complemento;
	private String email;
	private String telefone;
	private String celular1;
	private String celular2;
	private String observacao;
	
	
}
