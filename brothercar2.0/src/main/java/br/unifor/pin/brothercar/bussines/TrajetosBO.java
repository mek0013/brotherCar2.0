package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.TrajetosDAO;
import br.unifor.pin.brothercar.entity.Trajetos;
import br.unifor.pin.brothercar.exceptions.BOException;

@Loggable
@Service
public class TrajetosBO {

	@Autowired
	private TrajetosDAO trajetoDAO;

	public void salvar(Trajetos trajeto) throws BOException {

		Trajetos trajetoComLatitudeELongitudeInicialCadastrado = trajetoDAO
				.buscarPorLatitudeLongitudeInicial(
						trajeto.getLatitudeInicial(),
						trajeto.getLongitudeInicial());

		if (trajetoComLatitudeELongitudeInicialCadastrado != null) {
			throw new BOException(
					"Trajeto com localização de partida já cadastrado!");
		}

		Trajetos trajetoComLatitudeELongitudeFinalCadastrado = trajetoDAO
				.buscarPorLatitudeLongitudeInicial(trajeto.getLatitudeFinal(),
						trajeto.getLongitudeFinal());

		if (trajetoComLatitudeELongitudeFinalCadastrado != null) {
			throw new BOException(
					"Trajeto com localização de destino já cadastrado!");
		}

		trajetoDAO.salvarTrajeto(trajeto);
	}

	public void atualizar(Trajetos trajeto) throws BOException {

		try {
			trajetoDAO.atualizarTrajeto(trajeto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualizar seu trajeto!");
		}
	}

	public void excluir(Trajetos trajeto) throws BOException {

		try {
			trajetoDAO.deletarTrajeto(trajeto);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir seu trajeto!");
		}
	}
	
	public List<Trajetos> listarTodostrajetos() {
		return trajetoDAO.findAll();
	}
}
