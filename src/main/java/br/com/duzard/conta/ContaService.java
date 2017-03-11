package br.com.duzard.conta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.duzard.utils.GenericService;

@RestController
@RequestMapping(path = "/api/conta")
public class ContaService extends GenericService<ContaEntity, Long>{
	
	@Autowired
	protected ContaRepository contaRepository;
	
	@RequestMapping(path= "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ContaEntity> delete(@PathVariable Long id) {
		
		ContaEntity contaEncontrada = contaRepository.findById(id);
		
		contaRepository.delete(contaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ContaEntity findById(@PathVariable Long id){
		
		ContaEntity contaEncontrada = contaRepository.findById(id);
		
		return contaEncontrada;
	}	
	
	@RequestMapping(path= "/status/{status}", method = RequestMethod.GET)
	public List<ContaEntity> findByStatus(@PathVariable String status){
	
		 List<ContaEntity> listaContas = contaRepository.findAllByStatus(status);

		 return listaContas;
	}
	
	@RequestMapping(path= "/filtrar/{year}/{month}/{status}", method = RequestMethod.GET)
	public List<ContaEntity> findByStatus(@PathVariable("year") int year, @PathVariable("month") int month,@PathVariable("status") String status){
	
		 List<ContaEntity> listaContas = contaRepository.findAllByYearAndMonthAndStatus(year, month, status);

		 return listaContas;
	}
}
