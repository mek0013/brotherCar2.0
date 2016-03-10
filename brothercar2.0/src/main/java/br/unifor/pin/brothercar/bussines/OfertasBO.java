package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.OfertasDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;

@Loggable
@Service
public class OfertasBO {

	@Autowired
	private OfertasDAO ofertasDAO;

	@Autowired
	private SegurancaTO segurancaTO;

	public void salvar(Ofertas oferta) throws BOException {
		oferta.setStatusOferta("DISPONIVEL");
		oferta.setSituacaoOferta("ABERTA");
		oferta.setMotorista(segurancaTO.getUsuario());
		ofertasDAO.salvarOfertas(oferta);
	}

	public void atualizar(Ofertas oferta) throws BOException {

		try {
			ofertasDAO.atualizarOfertas(oferta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualizar sua oferta!");
		}
	}

	public void excluir(Ofertas oferta) throws BOException {

		try {
			ofertasDAO.deletarOfertas(oferta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir sua oferta!");
		}
	}

	public List<Ofertas> listarOfertasDoMotorista() {
		return ofertasDAO.listarOfertasDisponiveisDoMotorista(segurancaTO
				.getUsuario());
	}

	public List<Ofertas> listarOfertasDeMotoristasDiferentes() {
		return ofertasDAO
				.listarOfertasDisponiveisDeMotoristaDiferentes(segurancaTO
						.getUsuario());
	}

	public void atualizarOfertasComIndisponivel() {
		List<Ofertas> ofertasComQuantidadeVagasZero = ofertasDAO.listarOfertasComQuantidadeZero();
		
		for (Ofertas oferta : ofertasComQuantidadeVagasZero) {
			oferta.setStatusOferta("INDISPONIVEL");
			oferta.setSituacaoOferta("FECHADA");
			ofertasDAO.atualizarOfertas(oferta);
		}
	}
	
	public void degrementarQuantidadeVagas(Ofertas oferta) {
		oferta.setQuantidadeVagas(oferta.getQuantidadeVagas() - 1);
		ofertasDAO.atualizarOfertas(oferta);
	}
}
