package br.unifor.pin.brothercar.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3108891161807276721L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(nullable = true, length = 11, unique = true)
	private String cnh;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String senha;
	
	@Column(name = "quantidade_pontos", nullable = true)
	private Integer quantidadePontos;
	
	@Column(nullable = false)
	private Integer moedas;
	
	@Column(nullable = false, length = 1)
	private String perfil;

	@Column(nullable = false)
	private boolean ativo;

	@Column(nullable = false)
	private boolean administrador;
	
	@OneToMany(mappedBy = "usuario")
	@JoinColumn(name = "automoveis_id", nullable = false)
	private List<Automoveis> automovel;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getQuantidadePontos() {
		return quantidadePontos;
	}

	public void setQuantidadePontos(Integer quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}

	public Integer getMoedas() {
		return moedas;
	}

	public void setMoedas(Integer moedas) {
		this.moedas = moedas;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}


	public List<Automoveis> getAutomovel() {
		return automovel;
	}

	public void setAutomovel(List<Automoveis> automovel) {
		this.automovel = automovel;
	}
	
	public void adicionarAutomovel( Automoveis automovel) {
		this.automovel.add(automovel);
		automovel.setUsuario(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nome + ", email=" + email
				+ "]";
	}

}