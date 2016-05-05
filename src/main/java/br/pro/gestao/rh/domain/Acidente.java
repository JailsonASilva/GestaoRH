package br.pro.gestao.rh.domain;

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
public class Acidente extends GenericDomain {
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Local local;

	@OneToOne
	@JoinColumn(nullable = false)
	private Empregado empregado;

	@ManyToOne
	@JoinColumn(nullable = false)
	private CausaAcidente causaAcidente;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date altaEm;

	@Column(nullable = true)
	private String resultado;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public CausaAcidente getCausaAcidente() {
		return causaAcidente;
	}

	public void setCausaAcidente(CausaAcidente causaAcidente) {
		this.causaAcidente = causaAcidente;
	}

	public Date getAltaEm() {
		return altaEm;
	}

	public void setAltaEm(Date altaEm) {
		this.altaEm = altaEm;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Empregado getEmpregado() {
		return empregado;
	}
}
