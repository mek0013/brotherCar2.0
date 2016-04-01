package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Passageiros;
import br.unifor.pin.brothercar.entity.Pedidos;

/**
 * @author maycon
 * @since 16/03/2016*/

@Repository
public class PedidosDAO extends GenericDAO<Integer, Pedidos>{

	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Pedidos).
	 * */
	public PedidosDAO() {
		super(Pedidos.class);
	}
	
	/**
	 * @param Pedidos
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todos os Pedidos.
	 */
	
	public void salvarPedidos(Pedidos pedido) {
		super.save(pedido);
	}
	
	public void atualizarPedidos(Pedidos pedido) {
		super.update(pedido);
	}
	
	public void deletarPedidos(Pedidos pedido) {
		super.delete(pedido);
	}
	
	public List<Pedidos> listarTodosPedidos() {
		return super.findAll();
	}
	
	public Pedidos buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param statusPedidos
	 * @return Pedidos
	 * Retorna o Pedido pelo status.
	 */
	
	public Pedidos buscarPorStatusPedidos(String statusOferta) {
		Query query = (Query) super.createQuery("from Pedidos p where p.statusPedido=?");
		query.setString(0, statusOferta);
		
		try {
			return (Pedidos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param passageiro
	 * @return Pedidos
	 * Retorna o Pedidos pelo passageiro.
	 */
	
	public Pedidos buscarPeloPassageiro(Passageiros passageiro) {
		Query query = (Query) super.createQuery("from Pedidos p where p.passageiro=?");
		query.setEntity(0, passageiro);
		
		try {
			return (Pedidos)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
