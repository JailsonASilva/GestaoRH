package br.pro.gestao.rh.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Ferias extends GenericDomain {
	@OneToOne
	@JoinColumn(nullable = false)
	private Empregado empregado;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataReferente1;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataReferente2;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataGozada1;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataGozada2;

	public Date getDataReferente1() {
		return dataReferente1;
	}

	public void setDataReferente1(Date dataReferente1) {
		this.dataReferente1 = dataReferente1;
	}

	public Date getDataReferente2() {
		return dataReferente2;
	}

	public void setDataReferente2(Date dataReferente2) {
		this.dataReferente2 = dataReferente2;
	}

	public Date getDataGozada1() {
		return dataGozada1;
	}

	public void setDataGozada1(Date dataGozada1) {
		this.dataGozada1 = dataGozada1;
	}

	public Date getDataGozada2() {
		return dataGozada2;
	}

	public void setDataGozada2(Date dataGozada2) {
		this.dataGozada2 = dataGozada2;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

}
