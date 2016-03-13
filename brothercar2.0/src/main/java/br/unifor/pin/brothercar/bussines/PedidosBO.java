package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.PedidosDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Pedidos;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;

@Loggable
@Service
public class PedidosBO {

	@Autowired
	private PedidosDAO pedidosDAO;

	@Autowired
	private SegurancaTO segurancaTO;

	public void salvar(Ofertas oferta, Integer pontoEscolhido) {
		Pedidos pedido = new Pedidos();
		pedido.setOfertas(oferta);
		pedido.setPontoEscolhido(pontoEscolhido);
		pedido.setStatusPedido("AGUARDANDO");
		pedido.setPassageiro(segurancaTO.getUsuario());
		pedidosDAO.salvarPedido(pedido);

	}

	public void atualizar(Pedidos pedido) throws BOException {

		try {
			pedidosDAO.atualizarPedido(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualizar seu pedido!");
		}
	}

	public void excluir(Pedidos pedido) throws BOException {

		try {
			pedidosDAO.deletarPedido(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir seu pedido!");
		}
	}

	public List<Pedidos> listaPedidoPorOferta(Ofertas oferta) {
		return pedidosDAO.listarPedidosPorOferta(oferta);
	}

	public List<Pedidos> listarPedidosDoPassageiro() {
		return pedidosDAO.listarPedidosDoPassageiro(segurancaTO.getUsuario());
	}

	public void confirmaPedido(Pedidos pedido) throws BOException {
		pedido.setStatusPedido("ACEITO");
		pedidosDAO.atualizarPedido(pedido);
	}

	public void recusarPedido(Pedidos pedido) throws BOException {
		pedido.setStatusPedido("RECUSADO");
		pedidosDAO.atualizarPedido(pedido);
	}
}
