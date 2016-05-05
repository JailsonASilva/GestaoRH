package br.pro.gestao.rh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Horario extends GenericDomain {
	@Column(length = 60, nullable = false)
	private String nome;

	@Column(length = 30, nullable = false)
	private String tipoHorario;

	@Column(nullable = false)
	private Boolean domingo;

	@Column(length = 6, nullable = true)
	private Boolean descansoDomingo;

	@Column(length = 6, nullable = true)
	private String entradaDomingo;

	@Column(length = 6, nullable = true)
	private String intervaloEntDomingo;

	@Column(length = 6, nullable = true)
	private String intervaloSaiDomingo;

	@Column(length = 6, nullable = true)
	private String saidaDomingo;

	@Column(nullable = false)
	private Boolean segunda;

	@Column(length = 6, nullable = true)
	private Boolean descansoSegunda;

	@Column(length = 6, nullable = true)
	private String entradaSegunda;

	@Column(length = 6, nullable = true)
	private String intervaloEntSegunda;

	@Column(length = 6, nullable = true)
	private String intervaloSaiSegunda;

	@Column(length = 6, nullable = true)
	private String saidaSegunda;

	@Column(nullable = false)
	private Boolean terca;

	@Column(length = 6, nullable = true)
	private Boolean descansoTerca;

	@Column(length = 6, nullable = true)
	private String entradaTerca;

	@Column(length = 6, nullable = true)
	private String intervaloEntTerca;

	@Column(length = 6, nullable = true)
	private String intervaloSaiTerca;

	@Column(length = 6, nullable = true)
	private String saidaTerca;

	@Column(nullable = false)
	private Boolean quarta;

	@Column(length = 6, nullable = true)
	private Boolean descansoQuarta;

	@Column(length = 6, nullable = true)
	private String entradaQuarta;

	@Column(length = 6, nullable = true)
	private String intervaloEntQuarta;

	@Column(length = 6, nullable = true)
	private String intervaloSaiQuarta;

	@Column(length = 6, nullable = true)
	private String saidaQuarta;

	@Column(nullable = false)
	private Boolean quinta;

	@Column(length = 6, nullable = true)
	private Boolean descansoQuinta;

	@Column(length = 6, nullable = true)
	private String entradaQuinta;

	@Column(length = 6, nullable = true)
	private String intervaloEntQuinta;

	@Column(length = 6, nullable = true)
	private String intervaloSaiQuinta;

	@Column(length = 6, nullable = true)
	private String saidaQuinta;

	@Column(nullable = false)
	private Boolean sexta;

	@Column(length = 6, nullable = true)
	private Boolean descansoSexta;

	@Column(length = 6, nullable = true)
	private String entradaSexta;

	@Column(length = 6, nullable = true)
	private String intervaloEntSexta;

	@Column(length = 6, nullable = true)
	private String intervaloSaiSexta;

	@Column(length = 6, nullable = true)
	private String saidaSexta;

	@Column(nullable = false)
	private Boolean sabado;

	@Column(length = 6, nullable = true)
	private Boolean descansoSabado;

	@Column(length = 6, nullable = true)
	private String entradaSabado;

	@Column(length = 6, nullable = true)
	private String intervaloEntSabado;

	@Column(length = 6, nullable = true)
	private String intervaloSaiSabado;

	@Column(length = 6, nullable = true)
	private String saidaSabado;

	@Column(length = 6, nullable = true)
	private String entradaIntra;

	@Column(length = 6, nullable = true)
	private String saidaIntra;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	public Boolean getDomingo() {
		return domingo;
	}

	public void setDomingo(Boolean domingo) {
		this.domingo = domingo;
	}

	public Boolean getDescansoDomingo() {
		return descansoDomingo;
	}

	public void setDescansoDomingo(Boolean descansoDomingo) {
		this.descansoDomingo = descansoDomingo;
	}

	public String getEntradaDomingo() {
		return entradaDomingo;
	}

	public void setEntradaDomingo(String entradaDomingo) {
		this.entradaDomingo = entradaDomingo;
	}

	public String getIntervaloEntDomingo() {
		return intervaloEntDomingo;
	}

	public void setIntervaloEntDomingo(String intervaloEntDomingo) {
		this.intervaloEntDomingo = intervaloEntDomingo;
	}

	public String getIntervaloSaiDomingo() {
		return intervaloSaiDomingo;
	}

	public void setIntervaloSaiDomingo(String intervaloSaiDomingo) {
		this.intervaloSaiDomingo = intervaloSaiDomingo;
	}

	public String getSaidaDomingo() {
		return saidaDomingo;
	}

	public void setSaidaDomingo(String saidaDomingo) {
		this.saidaDomingo = saidaDomingo;
	}

	public Boolean getSegunda() {
		return segunda;
	}

	public void setSegunda(Boolean segunda) {
		this.segunda = segunda;
	}

	public Boolean getDescansoSegunda() {
		return descansoSegunda;
	}

	public void setDescansoSegunda(Boolean descansoSegunda) {
		this.descansoSegunda = descansoSegunda;
	}

	public String getEntradaSegunda() {
		return entradaSegunda;
	}

	public void setEntradaSegunda(String entradaSegunda) {
		this.entradaSegunda = entradaSegunda;
	}

	public String getIntervaloEntSegunda() {
		return intervaloEntSegunda;
	}

	public void setIntervaloEntSegunda(String intervaloEntSegunda) {
		this.intervaloEntSegunda = intervaloEntSegunda;
	}

	public String getIntervaloSaiSegunda() {
		return intervaloSaiSegunda;
	}

	public void setIntervaloSaiSegunda(String intervaloSaiSegunda) {
		this.intervaloSaiSegunda = intervaloSaiSegunda;
	}

	public String getSaidaSegunda() {
		return saidaSegunda;
	}

	public void setSaidaSegunda(String saidaSegunda) {
		this.saidaSegunda = saidaSegunda;
	}

	public Boolean getTerca() {
		return terca;
	}

	public void setTerca(Boolean terca) {
		this.terca = terca;
	}

	public Boolean getDescansoTerca() {
		return descansoTerca;
	}

	public void setDescansoTerca(Boolean descansoTerca) {
		this.descansoTerca = descansoTerca;
	}

	public String getEntradaTerca() {
		return entradaTerca;
	}

	public void setEntradaTerca(String entradaTerca) {
		this.entradaTerca = entradaTerca;
	}

	public String getIntervaloEntTerca() {
		return intervaloEntTerca;
	}

	public void setIntervaloEntTerca(String intervaloEntTerca) {
		this.intervaloEntTerca = intervaloEntTerca;
	}

	public String getIntervaloSaiTerca() {
		return intervaloSaiTerca;
	}

	public void setIntervaloSaiTerca(String intervaloSaiTerca) {
		this.intervaloSaiTerca = intervaloSaiTerca;
	}

	public String getSaidaTerca() {
		return saidaTerca;
	}

	public void setSaidaTerca(String saidaTerca) {
		this.saidaTerca = saidaTerca;
	}

	public Boolean getQuarta() {
		return quarta;
	}

	public void setQuarta(Boolean quarta) {
		this.quarta = quarta;
	}

	public Boolean getDescansoQuarta() {
		return descansoQuarta;
	}

	public void setDescansoQuarta(Boolean descansoQuarta) {
		this.descansoQuarta = descansoQuarta;
	}

	public String getEntradaQuarta() {
		return entradaQuarta;
	}

	public void setEntradaQuarta(String entradaQuarta) {
		this.entradaQuarta = entradaQuarta;
	}

	public String getIntervaloEntQuarta() {
		return intervaloEntQuarta;
	}

	public void setIntervaloEntQuarta(String intervaloEntQuarta) {
		this.intervaloEntQuarta = intervaloEntQuarta;
	}

	public String getIntervaloSaiQuarta() {
		return intervaloSaiQuarta;
	}

	public void setIntervaloSaiQuarta(String intervaloSaiQuarta) {
		this.intervaloSaiQuarta = intervaloSaiQuarta;
	}

	public String getSaidaQuarta() {
		return saidaQuarta;
	}

	public void setSaidaQuarta(String saidaQuarta) {
		this.saidaQuarta = saidaQuarta;
	}

	public Boolean getQuinta() {
		return quinta;
	}

	public void setQuinta(Boolean quinta) {
		this.quinta = quinta;
	}

	public Boolean getDescansoQuinta() {
		return descansoQuinta;
	}

	public void setDescansoQuinta(Boolean descansoQuinta) {
		this.descansoQuinta = descansoQuinta;
	}

	public String getEntradaQuinta() {
		return entradaQuinta;
	}

	public void setEntradaQuinta(String entradaQuinta) {
		this.entradaQuinta = entradaQuinta;
	}

	public String getIntervaloEntQuinta() {
		return intervaloEntQuinta;
	}

	public void setIntervaloEntQuinta(String intervaloEntQuinta) {
		this.intervaloEntQuinta = intervaloEntQuinta;
	}

	public String getIntervaloSaiQuinta() {
		return intervaloSaiQuinta;
	}

	public void setIntervaloSaiQuinta(String intervaloSaiQuinta) {
		this.intervaloSaiQuinta = intervaloSaiQuinta;
	}

	public String getSaidaQuinta() {
		return saidaQuinta;
	}

	public void setSaidaQuinta(String saidaQuinta) {
		this.saidaQuinta = saidaQuinta;
	}

	public Boolean getSexta() {
		return sexta;
	}

	public void setSexta(Boolean sexta) {
		this.sexta = sexta;
	}

	public Boolean getDescansoSexta() {
		return descansoSexta;
	}

	public void setDescansoSexta(Boolean descansoSexta) {
		this.descansoSexta = descansoSexta;
	}

	public String getEntradaSexta() {
		return entradaSexta;
	}

	public void setEntradaSexta(String entradaSexta) {
		this.entradaSexta = entradaSexta;
	}

	public String getIntervaloEntSexta() {
		return intervaloEntSexta;
	}

	public void setIntervaloEntSexta(String intervaloEntSexta) {
		this.intervaloEntSexta = intervaloEntSexta;
	}

	public String getIntervaloSaiSexta() {
		return intervaloSaiSexta;
	}

	public void setIntervaloSaiSexta(String intervaloSaiSexta) {
		this.intervaloSaiSexta = intervaloSaiSexta;
	}

	public String getSaidaSexta() {
		return saidaSexta;
	}

	public void setSaidaSexta(String saidaSexta) {
		this.saidaSexta = saidaSexta;
	}

	public Boolean getSabado() {
		return sabado;
	}

	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}

	public Boolean getDescansoSabado() {
		return descansoSabado;
	}

	public void setDescansoSabado(Boolean descansoSabado) {
		this.descansoSabado = descansoSabado;
	}

	public String getEntradaSabado() {
		return entradaSabado;
	}

	public void setEntradaSabado(String entradaSabado) {
		this.entradaSabado = entradaSabado;
	}

	public String getIntervaloEntSabado() {
		return intervaloEntSabado;
	}

	public void setIntervaloEntSabado(String intervaloEntSabado) {
		this.intervaloEntSabado = intervaloEntSabado;
	}

	public String getIntervaloSaiSabado() {
		return intervaloSaiSabado;
	}

	public void setIntervaloSaiSabado(String intervaloSaiSabado) {
		this.intervaloSaiSabado = intervaloSaiSabado;
	}

	public String getSaidaSabado() {
		return saidaSabado;
	}

	public void setSaidaSabado(String saidaSabado) {
		this.saidaSabado = saidaSabado;
	}

	public String getEntradaIntra() {
		return entradaIntra;
	}
	
	public String getSaidaIntra() {
		return saidaIntra;
	}
	
	public void setEntradaIntra(String entradaIntra) {
		this.entradaIntra = entradaIntra;
	}
	
	public void setSaidaIntra(String saidaIntra) {
		this.saidaIntra = saidaIntra;
	}
}
