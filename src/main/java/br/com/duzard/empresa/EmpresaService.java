package br.com.duzard.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.duzard.utils.GenericService;

@RestController
@RequestMapping(path = "/api/empresa")
public class EmpresaService extends GenericService<EmpresaEntity, Long> {
	
	@Autowired
	protected EmpresaRepository empresaRepository;
	
	@RequestMapping(path= "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmpresaEntity> delete(@PathVariable Long id) {
		
		EmpresaEntity empresaEncontrada = empresaRepository.findById(id);
		
		empresaRepository.delete(empresaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public EmpresaEntity findById(@PathVariable Long id){
		
		EmpresaEntity empresaEncontrada = empresaRepository.findById(id);
		
		return empresaEncontrada;
	}
	
}
