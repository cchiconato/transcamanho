package br.com.duzard.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long>{

	public EmpresaEntity findById(Long id);
	

}
