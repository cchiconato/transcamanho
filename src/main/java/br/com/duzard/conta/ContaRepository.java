package br.com.duzard.conta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContaRepository extends JpaRepository<ContaEntity, Long>{
	
	public ContaEntity findById(Long id);
	
	public List<ContaEntity> findAllByStatus(String string);
	
	@Query(value= "select * from contas where extract('year' from data ) = ?1 and extract('month' from data) = ?2 and status = ?3", nativeQuery = true)
	public List<ContaEntity> findAllByYearAndMonthAndStatus(int year, int month, String status);
}
