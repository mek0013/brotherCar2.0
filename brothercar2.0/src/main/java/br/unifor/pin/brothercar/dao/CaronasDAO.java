package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.entity.Trajetos;



@Repository
public class CaronasDAO extends GenericDAO<Integer, Caronas>{

	public CaronasDAO() {
		super(Caronas.class);
	}
	
	public void salvarCarona(Caronas carona) {
		super.save(carona);
	}
	
	public boolean atualizarCarona(Caronas carona) {
		super.update(carona);
		return true;
	}
	
	public boolean deletarCarona(Caronas carona) {
		super.delete(carona);
		return true;
	}
	
	public List<Caronas> listarTodasCaronas() {
		return super.findAll();
	}
	
	public Caronas buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	public Caronas buscarPorNomeTrajeto(String nomeTrajeto) {
		Query query = (Query) super.createQuery("from Caronas c where c.nome_trajeto=?");
		query.setString(0, nomeTrajeto);
		
		try {
			return (Caronas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Caronas buscarPorTrajeto(Trajetos trajeto) {
		Query query = (Query) super.createQuery("from Caronas c where c.trajeto= :trajeto");
		query.setEntity("trajeto", trajeto);
		
		try {
			return (Caronas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Caronas buscarPorPontoParada(PontoParada pontoParada) {
		Query query = (Query) super.createQuery("from Caronas c where c.pontoParada= :pontoParada");
		query.setEntity("pontoParada", pontoParada);
		
		try {
			return (Caronas)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
