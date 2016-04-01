package br.unifor.pin.brothercar.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author maycon
 * @since 16/03/2016
 */

@XmlRootElement
@Entity
@DiscriminatorValue("1")
public class Motoristas extends Usuarios {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "cnh", nullable = false, unique = true)
	private String cnh;
	
	@Column(name = "quantidade_pontos", nullable = false)
	private Integer quantidadePontos;
	
	@Column(name = "moedas_motorista", nullable = false)
	private Integer moedasMotorista;
	
	@OneToMany(mappedBy = "motorista", fetch = FetchType.EAGER)
	private List<Automoveis> listaAutomoveis;

	public String getCnh() {
		return cnh;
	}
	
	/**
	 * Gets E Sets
	 */

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Integer getQuantidadePontos() {
		return quantidadePontos;
	}

	public void setQuantidadePontos(Integer quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}

	public Integer getMoedasMotorista() {
		return moedasMotorista;
	}

	public void setMoedasMotorista(Integer moedasMotorista) {
		this.moedasMotorista = moedasMotorista;
	}

	public List<Automoveis> getListaAutomoveis() {
		return listaAutomoveis;
	}

	public void setListaAutomoveis(List<Automoveis> listaAutomoveis) {
		this.listaAutomoveis = listaAutomoveis;
	}
	
	

}
