package br.unifor.pin.brothercar.bussines;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.CaronasDAO;
import br.unifor.pin.brothercar.entity.Caronas;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.entity.Trajetos;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.to.SegurancaTO;

@Loggable
@Service
public class CaronasBO {

	@Autowired
	private CaronasDAO caronasDAO;
	@Autowired
	private PontoParadaBO pontoParadaBO;

	public void salvarCarona(Caronas carona, List<PontoParada> pontos)
			throws BOException {

		Caronas caronaComNomeCadastrado = caronasDAO
				.buscarPorNomeTrajeto(carona.getNomeTrajeto());

		if (caronaComNomeCadastrado != null) {
			throw new BOException("Carona com o mesmo nome já cadastrada!");
		}

		caronasDAO.salvarCarona(carona);
		carona.setPontosParada(new ArrayList<PontoParada>());
		for (PontoParada ponto : pontos) {
			carona.getPontosParada().add(ponto);
			ponto.setCarona(carona);
			pontoParadaBO.salvar(ponto);
		}

	}

	public void atualizarCarona(Caronas carona) throws BOException {

		try {
			caronasDAO.atualizarCarona(carona);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualiza sua carona!");
		}
	}

	public void excluirCarona(Caronas carona) throws BOException {

		try {
			caronasDAO.deletarCarona(carona);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir sua carona!");
		}
	}

	public List<Caronas> listarTodosCaronas() {
		return caronasDAO.findAll();
	}

}
