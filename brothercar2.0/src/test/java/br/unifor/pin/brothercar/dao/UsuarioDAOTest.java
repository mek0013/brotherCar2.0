package br.unifor.pin.brothercar.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.unifor.pin.brothercar.bussines.UsuarioBO;
import br.unifor.pin.brothercar.dao.UsuarioDAO;
import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Usuarios;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
public class UsuarioDAOTest {
	
	@Autowired
	private UsuarioDAO usuarioDao;

	@Test
	public void testSalvar() throws Exception {
		
		Usuarios usuario = new Usuarios();
		usuario.setNome("neto");
		usuario.setSenha("123456");
		usuario.setEmail("neto@gmail.com");
		usuario.setAtivo(true);
		usuario.setAdministrador(false);
		usuario.setCnh(null);
		usuario.setCpf("00000000000");
		usuario.setDataNascimento(new Date(0, 0, 0));
		usuario.setMoedas(0);
		usuario.setQuantidadePontos(null);
		usuario.setOfertas(new ArrayList<Ofertas>());
		usuario.setPerfil("M");
		
		usuarioDao.salvarUsuario(usuario);
		
		Assert.assertNotNull(usuario.getId());
		System.out.println(usuario.getId());
		
		
	}
	
	@Test
	public void testListaPorNome(){
		List<Usuarios> usuarios = usuarioDao.listarPorNome("neto");
		Assert.assertEquals(1, usuarios.size());
	}

}
