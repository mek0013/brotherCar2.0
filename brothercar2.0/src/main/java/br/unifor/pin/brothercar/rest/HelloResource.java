package br.unifor.pin.brothercar.rest;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "HTTP GET";
	}
	
	public String post() {
		return "HTTP POST";
	}
	
	public String put() {
		return "HTTP PUT";
	}
	
	public String delete() {
		return "HTTP DELETE";
	}
}
