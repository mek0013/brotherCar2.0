package br.unifor.pin.brothercar.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.brothercar.aspectj.Loggable;
import br.unifor.pin.brothercar.dao.UsuarioDAO;
import br.unifor.pin.brothercar.entity.Usuarios;
import br.unifor.pin.brothercar.exceptions.BOException;
import br.unifor.pin.brothercar.exceptions.DAOException;


/**
 * 
 * 
 */
@Loggable
@Service
public class UsuarioBO {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public void salvar(Usuarios usuario) throws BOException {
		
		usuario.setAtivo(true);
		
		Usuarios usuarioComEmailCadastrado = usuarioDAO.buscarPorEmail(usuario.getEmail());
		if(usuarioComEmailCadastrado != null){
			throw new BOException("Email já cadastrado.");
		}
		
		Usuarios usuarioComCpfCadastrado = usuarioDAO.buscarPorCpf(usuario.getCpf());
		if(usuarioComCpfCadastrado != null){
			throw new BOException("CPF já cadastrada.");
		}
		
		usuarioDAO.salvarUsuario(usuario);
	}

	public void atualizar(Usuarios usuario) {
		usuarioDAO.atualizarUsuario(usuario);
	}

	@Loggable(enable = false)
	public Usuarios loggar(String email, String senha) {
		return usuarioDAO.buscarPorEmailSenha(email, senha);
	}

	@Loggable(enable = false)
	public Usuarios buscarUsuariosPorCpf(String cpf) {
		return usuarioDAO.buscarPorCpf(cpf);
	}

	@Loggable(enable = false)
	public List<Usuarios> listaUsuarioPorNome(String nome) {
		List<Usuarios> usuarios = usuarioDAO.listarPorNome(nome);
		return usuarios;
	}

	@Loggable(enable = false)
	public Usuarios buscarPorId(Integer id) throws DAOException {
		return usuarioDAO.buscarPorId(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void excluir(Usuarios usuario) throws BOException{
		try {
			usuario.setAtivo(false);
			usuarioDAO.atualizarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException("Não foi possível excluir sua conta.");
		}
	}
	

}
