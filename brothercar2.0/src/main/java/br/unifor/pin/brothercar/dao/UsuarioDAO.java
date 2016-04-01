package br.unifor.pin.brothercar.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.unifor.pin.brothercar.entity.Usuarios;
/**
 * @author maycon
 * @since 16/03/2016
 * 
 */

@Repository
public class UsuarioDAO extends GenericDAO<Integer, Usuarios> {

	
	/**
	 * Construtor para inicializa o contrutror da classe pai,
	 * passando o tipo (Usuario).
	 * */
	public UsuarioDAO() {
		super(Usuarios.class);
	}
	
	/**
	 * @param Usuario
	 * @return void
	 * Salvar, Atualiza, Deletar e Listar todos os Usuarios.
	 */
	
	public void salvarUsuario(Usuarios usuario) {
		super.save(usuario);
	}
	
	public void atualizarUsuario(Usuarios usuario) {
		super.update(usuario);
	}
	
	public void deletarUsuario(Usuarios usuario) {
		super.delete(usuario);
	}
	
	public List<Usuarios> listarTodosUsuarios() {
		return super.findAll();
	}
	
	public Usuarios buscarPorId(Integer id) {
		return super.getById(id);
	}
	
	/**
	 * @param email
	 * @return Usuario
	 * Retorna o usuario aparti do email.
	 */
	
	public Usuarios buscarPorEmail(String email) {
		Query query = (Query) super.createQuery("from Usuarios u where u.email=?");
		query.setString(0, email);
		
		try {
			return (Usuarios)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param nome
	 * @return List<Usuario>
	 * Retorna uma lista de usuarios aparti do nome usuario.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Usuarios> listarPorNome(String nomeUsuario) {
		Query query = (Query) super.createQuery("from Usuarios u where u.nome=?");
		query.setString(0, nomeUsuario);
		
		try {
			List<Usuarios> usuarios = query.list();
			return usuarios;
		} catch(NoResultException e){
			return null;
		}
	}
	
	/**
	 * @param email, senha
	 * @return Usuarios
	 * Retorna o usuario atravez do email e da senha.
	 */
	
	public Usuarios buscarPorEmailSenha(String email, String senha) {
		CriteriaBuilder criteriaBuilder = super.createCriteriaBuilder();
		CriteriaQuery<Usuarios> criteriaQuery = criteriaBuilder.createQuery(Usuarios.class);
		Root<Usuarios> usuarios = criteriaQuery.from(Usuarios.class);
		Predicate restriction = criteriaBuilder.and(
				criteriaBuilder.equal(usuarios.<String>get("email"), email),
				criteriaBuilder.equal(usuarios.<String>get("senha"), senha)
			);
		criteriaQuery.where(criteriaBuilder.and(restriction));
		
		Query query = (Query) super.createQuery(criteriaQuery);
		try {
			return (Usuarios)query.uniqueResult();
		} catch(NoResultException e){
			return null;
		}
	}
}
