package br.unifor.pin.brothercar.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(name = "nome_trajeto", nullable = false)
	private String nomeTrajeto;
	
	@Column(name = "latitude_saida", nullable = false, length = 15)
	private String latitudeSaida;
	
	@Column(name = "longitude_saida", nullable = false, length = 15)
	private String longitudeSaida;
	
	@Column(name = "latitude_chegada", nullable = false, length = 15)
	private String latitudeChegada;
	
	@Column(name = "longitude_chegada", nullable = false, length = 15)
	private String longitudeChegada;
	
	@OneToMany(mappedBy = "trajeto", fetch = FetchType.EAGER)
	private List<PontoParada> listaPontos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTrajeto() {
		return nomeTrajeto;
	}

	public void setNomeTrajeto(String nomeTrajeto) {
		this.nomeTrajeto = nomeTrajeto;
	}

	public String getLatitudeSaida() {
		return latitudeSaida;
	}

	public void setLatitudeSaida(String latitudeSaida) {
		this.latitudeSaida = latitudeSaida;
	}

	public String getLongitudeSaida() {
		return longitudeSaida;
	}

	public void setLongitudeSaida(String longitudeSaida) {
		this.longitudeSaida = longitudeSaida;
	}

	public String getLatitudeChegada() {
		return latitudeChegada;
	}

	public void setLatitudeChegada(String latitudeChegada) {
		this.latitudeChegada = latitudeChegada;
	}

	public String getLongitudeChegada() {
		return longitudeChegada;
	}

	public void setLongitudeChegada(String longitudeChegada) {
		this.longitudeChegada = longitudeChegada;
	}

	public List<PontoParada> getListaPontos() {
		return listaPontos;
	}

	public void setListaPontos(List<PontoParada> listaPontos) {
		this.listaPontos = listaPontos;
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
