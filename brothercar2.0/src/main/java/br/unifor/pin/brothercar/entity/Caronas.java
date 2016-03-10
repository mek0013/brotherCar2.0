package br.unifor.pin.brothercar.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement
@Entity
@Table(name="caronas")
public class Caronas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome_trajeto", nullable = false)
	private String nomeTrajeto;
	
	@OneToOne
	@JoinColumn(name = "trajetos_id", nullable = false)
	private Trajetos trajeto;
	
	@OneToMany(mappedBy = "carona", targetEntity = PontoParada.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PontoParada> pontosParada;
	
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

	public Trajetos getTrajeto() {
		return trajeto;
	}

	public void setTrajeto(Trajetos trajeto) {
		this.trajeto = trajeto;
	}

	public List<PontoParada> getPontosParada() {
		return pontosParada;
	}

	public void setPontosParada(List<PontoParada> pontosParada) {
		this.pontosParada = pontosParada;
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
		Caronas other = (Caronas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	

	
}
