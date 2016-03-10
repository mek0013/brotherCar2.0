package br.unifor.pin.brothercar.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import br.unifor.pin.brothercar.entity.Automoveis;


@Repository
public class AutomoveisDAO extends GenericDAO<Integer, Automoveis>{

	public AutomoveisDAO() {
		super(Automoveis.class);
	}
	
	public void salvarAutomovel(Automoveis automovel) {
		super.save(automovel);
	}
	
	public boolean atualizarAutomovel(Automoveis automovel) {
		super.update(automovel);
		return true;
	}
	
	public boolean deletarAutomovel(Automoveis automovel) {
		super.delete(automovel);
		return true;
	}
	
	public List<Automoveis> listarTodosAutomoveis() {
		return super.findAll();
	}
	
	public Automoveis buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	public Automoveis buscarPorModelo(String modelo) {
		Query query = (Query) super.createQuery("from Automoveis a where a.modelo=?");
		query.setString(0, modelo);
		
		try {
			return (Automoveis)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	public Automoveis buscarPorPlaca(String placa) {
		Query query = (Query) super.createQuery("from Automoveis a where a.placa=?");
		query.setString(0, placa);
		
		try {
			return (Automoveis)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
