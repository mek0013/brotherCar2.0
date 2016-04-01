package br.unifor.pin.brothercar.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@DiscriminatorValue("0")
public class Passageiros extends Usuarios {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "moedas_passageiro", nullable = false)
	private Integer moedasPassageiro;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getMoedasPassageiro() {
		return moedasPassageiro;
	}

	public void setMoedasPassageiro(Integer moedasPassageiro) {
		this.moedasPassageiro = moedasPassageiro;
	}
	
	

}
