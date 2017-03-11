package br.com.duzard.user.security;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.duzard.user.UserEntity;
import br.com.duzard.user.UserRepository;
import br.com.duzard.utils.ServiceMap;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*")
@RestController
public class SecutiryService implements ServiceMap {
		
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public LoginResponse autenticar(@RequestBody UserEntity user) throws ServletException{
		
		if(user.getEmail() == null || user.getPassword() == null){
			throw new ServletException("nome e senha são obrigatórias");
		}
		
		UserEntity useAutenticado = userRepository.findByEmail(user.getEmail());
		
		if(useAutenticado == null){
			throw new ServletException("Usuário não encontrado");
		}
		
		if(!useAutenticado.getPassword().equals(user.getPassword())){
			throw new ServletException("Usuário ou senha inválido");
		}
		
    	String token = Jwts.builder()
    			.setSubject(useAutenticado.getEmail())
    			.signWith(SignatureAlgorithm.HS512, "banana")
    			.setExpiration(new Date(System.currentTimeMillis() + 10 * 6000 * 100000 ))
    			.compact();
				
		return new LoginResponse(token);
	}
	
	private class LoginResponse{
		private String token;
		public LoginResponse(String token){
			this.token = token;
		}
		
		public String getToken() {
			return token;
		}
		
	}
}
	