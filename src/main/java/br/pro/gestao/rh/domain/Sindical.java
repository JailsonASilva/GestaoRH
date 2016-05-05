package br.pro.gestao.rh.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Sindical extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Empregado empregado;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Sindicato sindicato;

	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal Valor;

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public BigDecimal getValor() {
		return Valor;
	}

	public void setValor(BigDecimal valor) {
		Valor = valor;
	}

}
