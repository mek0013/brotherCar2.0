package br.unifor.pin.brothercar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="pedidos")
public class Pedidos {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "ponto_escolhido_id")
	private PontoParada pontoEscolhido;
	
	@Column
	private String statusPedido;
	
	@OneToOne
	@JoinColumn(name="usuarios_id", nullable=false)
	private Usuarios passageiro;
	
	@ManyToOne
	@JoinColumn(name="ofertas_id", nullable = false)
	private Ofertas ofertas;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PontoParada getPontoEscolhido() {
		return pontoEscolhido;
	}

	public void setPontoEscolhido(PontoParada pontoEscolhido) {
		this.pontoEscolhido = pontoEscolhido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Usuarios getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Usuarios passageiro) {
		this.passageiro = passageiro;
	}

	public Ofertas getOfertas() {
		return ofertas;
	}

	public void setOfertas(Ofertas ofertas) {
		this.ofertas = ofertas;
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
		Pedidos other = (Pedidos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", statusPedido=" + statusPedido + "]";
	}

	

	
	
}
