package br.unifor.pin.brothercar.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.PontoParadaDAO;
import br.unifor.pin.brothercar.entity.PontoParada;
import br.unifor.pin.brothercar.exceptions.BOException;


@Loggable
@Service
public class PontoParadaBO {

	@Autowired
	private PontoParadaDAO pontoParadaDao;
	
	public void salvar(PontoParada pontoParada) {
		
		pontoParadaDao.salvarPontoParada(pontoParada);
	}
	
	public void atualizar(PontoParada pontoParada) throws BOException {
		
		try {
			pontoParadaDao.atualizarPontoParada(pontoParada);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualiza seu ponto de parada!");
		}
		
	}
	
	public void excluir(PontoParada pontoParada) throws BOException {
		
		try {
			pontoParadaDao.deletarPontoParada(pontoParada);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir seu ponto de parada!");
		}
		
	}
	
	public PontoParada buscarPorLatitudeLongitude(String latitude, String longitude) {
		return pontoParadaDao.buscarPorLatitudeLongitude(latitude, longitude);
	}
	
	
}
