package br.unifor.pin.brothercar.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="ofertas")
public class Ofertas {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false)
	private Boolean statusOferta;
	
	@Column(nullable=false)
	private String situacaoOferta;
	
	@Column(name = "data_oferta")
	@Temporal(TemporalType.DATE)
	private Date dataOferta;
	
	@Column(name = "quantidade_vagas", nullable = false)
	private Integer quantidadeVagas;
	
	@Column(nullable = false)
	private Double quilometragem;
	
	@OneToOne
	@JoinColumn(name = "trajeto_id")
	private Trajetos trajetos;
	
	@OneToOne
	@JoinColumn(name = "usuarios_id")
	private Motoristas motorista;
	
	@OneToMany(mappedBy = "oferta", targetEntity = Pedidos.class)
	private List<Pedidos> listaPedidos;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatusOferta() {
		return statusOferta;
	}

	public void setStatusOferta(Boolean statusOferta) {
		this.statusOferta = statusOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public Double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Double quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Trajetos getTrajetos() {
		return trajetos;
	}

	public void setTrajetos(Trajetos trajetos) {
		this.trajetos = trajetos;
	}

	public Motoristas getMotorista() {
		return motorista;
	}

	public void setMotorista(Motoristas motorista) {
		this.motorista = motorista;
	}

	public String getSituacaoOferta() {
		return situacaoOferta;
	}

	public void setSituacaoOferta(String situacaoOferta) {
		this.situacaoOferta = situacaoOferta;
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
		Ofertas other = (Ofertas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
