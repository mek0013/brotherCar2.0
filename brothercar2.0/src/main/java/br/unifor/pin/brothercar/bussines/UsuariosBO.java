package br.unifor.pin.brothercar.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unifor.pin.brothercar.dao.MotoristasDAO;
import br.unifor.pin.brothercar.dao.PassageirosDAO;
import br.unifor.pin.brothercar.dao.UsuarioDAO;
import br.unifor.pin.brothercar.entity.Motoristas;
import br.unifor.pin.brothercar.entity.Passageiros;
import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.exceptions.BOException;


@Service
public class UsuariosBO {

	@Autowired
	private UsuarioDAO usuariosDAO;
	
	@Autowired
	private PassageirosDAO passageirosDAO;
	
	@Autowired
	private MotoristasDAO motoristasDAO;
	
	public void salvarUsuario(Usuarios usuario) throws BOException {
		usuario.setAtivo(true);
		
		if (usuario instanceof Passageiros) {
			Usuarios passageiroComCpfJaCadastrado = passageirosDAO.buscarPorCpf(((Passageiros)usuario).getCpf());
			if (passageiroComCpfJaCadastrado != null) {
				throw new BOException("CPF já cadastrado!");
			}
		} else {
			Usuarios motoristaComCnhJaCadastrado = motoristasDAO.buscarPorCnh(((Motoristas)usuario).getCnh());
			if (motoristaComCnhJaCadastrado != null) {
				throw new BOException("CNH já cadastrada!");
			}
		}
		
		try {
			usuariosDAO.salvarUsuario(usuario);
		} catch (Exception e) {
			throw new BOException("Não foi possivel cadastra!");
		}
	}
}
