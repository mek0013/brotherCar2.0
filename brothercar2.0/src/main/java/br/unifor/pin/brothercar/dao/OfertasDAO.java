package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Usuarios;

@Repository
public class OfertasDAO extends GenericDAO<Integer, Ofertas>{

	public OfertasDAO() {
		super(Ofertas.class);
	}
	
	public void salvarOfertas(Ofertas oferta) {
		super.save(oferta);
	}
	
	public boolean atualizarOfertas(Ofertas oferta) {
		super.update(oferta);
		return true;
	}
	
	public boolean deletarOfertas(Ofertas oferta) {
		super.delete(oferta);
		return true;
	}
	
	public List<Ofertas> listarTodasOfertas() {
		return super.findAll();
	}
	
	public Ofertas buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ofertas> listarOfertasDisponiveisDoMotorista(Usuarios motorista) {
		Query query = (Query) super.createQuery("from Ofertas o where o.motorista= :motorista"
												+" and statusOferta= 'DISPONIVEL'");
		query.setEntity("motorista", motorista);
		
		try {
			List<Ofertas> ofertas = query.list();
			return ofertas;
		} catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Ofertas> listarOfertasDisponiveisDeMotoristaDiferentes(Usuarios motorista) {
		Query query = (Query) super.createQuery("from Ofertas o where o.motorista != :motorista"
												+" and statusOferta= 'DISPONIVEL'");
		query.setEntity("motorista", motorista);
		
		try {
			List<Ofertas> ofertas = query.list();
			return ofertas;
		} catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Ofertas> listarOfertasComQuantidadeZero() {
		Query query = (Query) super.createQuery("from Ofertas o where o.quantidadeVagas != :quantidadeVagas");
		query.setString("quantidadeVagas", "0");
		
		try {
			List<Ofertas> ofertas = query.list();
			return ofertas;
		} catch(NoResultException e){
			return null;
		}
	}
	
}
