package br.unifor.pin.brothercar.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unifor.pin.brothercar.entity.Ofertas;
import br.unifor.pin.brothercar.entity.Usuarios;


@RestController
@RequestMapping("user")
public class UsuarioResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuarios>> getUsuarios() {
		
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
		
		Usuarios usuario2 = new Usuarios();
		usuario2.setNome("neto");
		usuario2.setSenha("123456");
		usuario2.setEmail("neto@gmail.com");
		usuario2.setAtivo(true);
		usuario2.setAdministrador(false);
		usuario2.setCnh(null);
		usuario2.setCpf("00000000000");
		usuario2.setDataNascimento(new Date(0, 0, 0));
		usuario2.setMoedas(0);
		usuario2.setQuantidadePontos(null);
		usuario2.setOfertas(new ArrayList<Ofertas>());
		usuario2.setPerfil("M");
		
		List<Usuarios> listUsuarios = new ArrayList<Usuarios>();
		listUsuarios.add(usuario);
		listUsuarios.add(usuario2);
		
		return new ResponseEntity<List<Usuarios>>(listUsuarios, HttpStatus.OK);
	}
}
