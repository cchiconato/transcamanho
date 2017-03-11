package br.com.duzard.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.duzard.utils.GenericService;


@RestController
@RequestMapping(path = "/api/user")
public class UserService extends GenericService<UserEntity, Long> {
	
	@Autowired
	protected UserRepository userRepository;
	
	
	@RequestMapping(path= "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> delete(@PathVariable Long id) {
		
		UserEntity usuarioEncontrado = userRepository.findById(id);
		
		userRepository.delete(usuarioEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@RequestMapping(path= "/{email}", method = RequestMethod.GET)
	public UserEntity findByEmail(@PathVariable String email) {
		return userRepository.findByEmailStartingWith(email);
		
	}	
}
