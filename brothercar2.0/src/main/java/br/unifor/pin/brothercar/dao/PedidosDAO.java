package br.unifor.pin.brothercar.dao;



import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Pedidos;
import br.unifor.pin.brothercar.entity.Usuarios;



@Repository
public class PedidosDAO extends GenericDAO<Integer, Pedidos>{

	public PedidosDAO() {
		super(Pedidos.class);
	}
	
	public void salvarPedido(Pedidos pedido) {
		super.save(pedido);
	}
	
	public boolean atualizarPedido(Pedidos pedido) {
		super.update(pedido);
		return true;
	}
	
	public boolean deletarPedido(Pedidos pedido) {
		super.delete(pedido);
		return true;
	}
	
	public List<Pedidos> listarTodasOfertas() {
		return super.findAll();
	}
	
	public Pedidos buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedidos> listarPedidosDoPassageiro(Usuarios passageiro) {
		Query query = (Query) super.createQuery("from Pedidos o where o.passageiro= :passageiro");
		query.setParameter("passageiro", passageiro);
		
		try {
			List<Pedidos> pedidos = query.list();
			return pedidos;
		} catch(NoResultException e){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedidos> listarPedidosPorOferta(Ofertas oferta) {
		Query query = (Query) super.createQuery("from Pedidos o where o.oferta= :oferta");
		query.setParameter("oferta", oferta);
		
		try {
			List<Pedidos> pedidos = query.list();
			return pedidos;
		} catch(NoResultException e){
			return null;
		}
	}
}
