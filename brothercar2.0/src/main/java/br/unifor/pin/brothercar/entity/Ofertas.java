package br.unifor.pin.brothercar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String statusOferta;
	
	@Column(nullable=false)
	private String situacaoOferta;
	
	@Column(name = "data_oferta")
	@Temporal(TemporalType.DATE)
	private Date dataOferta;
	
	@Column(name = "hora_oferta")
	@Temporal(TemporalType.TIME)
	private Date horaOferta;
	
	@Column
	private Integer quantidadeVagas;
	
	@OneToOne
	@JoinColumn(name = "caronas_id")
	private Caronas carona;
	
	@ManyToOne
	@JoinColumn(name = "usuarios_id")
	private Usuarios motorista;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusOferta() {
		return statusOferta;
	}

	public void setStatusOferta(String statusOferta) {
		this.statusOferta = statusOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
	}

	public Date getHoraOferta() {
		return horaOferta;
	}

	public void setHoraOferta(Date horaOferta) {
		this.horaOferta = horaOferta;
	}

	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}

	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}

	public Caronas getCarona() {
		return carona;
	}

	public void setCarona(Caronas carona) {
		this.carona = carona;
	}

	public Usuarios getMotorista() {
		return motorista;
	}

	public void setMotorista(Usuarios motorista) {
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
