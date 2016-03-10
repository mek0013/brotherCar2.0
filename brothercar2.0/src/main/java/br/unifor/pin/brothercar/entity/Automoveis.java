package br.unifor.pin.brothercar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name="automoveis")
public class Automoveis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6013171331710157158L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String cor;
	
	@Column(nullable = false, length = 8)
	private String placa;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id", nullable = false)
	private Usuarios motorista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	public Usuarios getUsuario() {
		return motorista;
	}

	public void setUsuario(Usuarios usuario) {
		this.motorista = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automoveis other = (Automoveis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
