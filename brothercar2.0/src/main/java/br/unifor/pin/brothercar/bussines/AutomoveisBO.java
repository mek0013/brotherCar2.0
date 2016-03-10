package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.AutomoveisDAO;
import br.unifor.pin.brothercar.entity.Automoveis;
import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.exceptions.BOException;

@Loggable
@Service
public class AutomoveisBO {

	@Autowired
	private AutomoveisDAO automovelDAO;

	public void salvar(Automoveis automovel) throws BOException {


		Automoveis automovelComPlacaCadastrada = automovelDAO.buscarPorPlaca(automovel.getPlaca());
		if (automovelComPlacaCadastrada != null) {
			throw new BOException("Automovel com placa já cadastrado.");
		}

		automovelDAO.salvarAutomovel(automovel);
	}
	
	public void atualizar(Automoveis automovel) throws BOException {
		
		try {
			automovelDAO.atualizarAutomovel(automovel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel atualizar seu automovel!");
		}
			
	}
	
	public void excluir(Automoveis automovel) throws BOException {
		
		try {
			automovelDAO.deletarAutomovel(automovel);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possivel excluir seu automovel!");
		}
	}
	
	public List<Automoveis> listarAutomoveisPorMotorista(Usuarios motorista) {
		return automovelDAO.listarDoMotorista(motorista);
	}
}
