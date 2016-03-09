package br.unifor.pin.brothercar.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "trajetos")
public class Trajetos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6066521983576079774L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "latitude_inicial", nullable = false, length = 15)
	private String latitudeInicial;
	
	@Column(name = "longitude_inicial", nullable = false, length = 15)
	private String longitudeInicial;
	
	@Column(name = "latitude_final", nullable = false, length = 15)
	private String latitudeFinal;
	
	@Column(name = "longitude_final", nullable = false, length = 15)
	private String longitudeFinal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLatitudeInicial() {
		return latitudeInicial;
	}

	public void setLatitudeInicial(String latitudeInicial) {
		this.latitudeInicial = latitudeInicial;
	}

	public String getLongitudeInicial() {
		return longitudeInicial;
	}

	public void setLongitudeInicial(String longitudeInicial) {
		this.longitudeInicial = longitudeInicial;
	}

	public String getLatitudeFinal() {
		return latitudeFinal;
	}

	public void setLatitudeFinal(String latitudeFinal) {
		this.latitudeFinal = latitudeFinal;
	}

	public String getLongitudeFinal() {
		return longitudeFinal;
	}

	public void setLongitudeFinal(String longitudeFinal) {
		this.longitudeFinal = longitudeFinal;
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
		Trajetos other = (Trajetos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
