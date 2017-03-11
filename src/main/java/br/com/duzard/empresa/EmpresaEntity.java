package br.com.duzard.empresa;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.duzard.utils.BaseEntity;
import lombok.Data;


@Data
@Entity
@Table(name = "empresa")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class EmpresaEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	@Column(name = "razao_social", length = 120, nullable = true)
	private String razaoSocial;

	@Column(name = "nome_fantasia", length = 255, nullable = true)
	private String nomeFantasia;

	@Column(name = "cidade", length = 80, nullable = true)
	private String cidade;

	@Column(name = "bairro", length = 80, nullable = true)
	private String bairro;
	
	@Column(name = "rua", length = 80, nullable = true)
	private String rua;
	
	@Column(name = "mumero", length = 80, nullable = true)
	private String numero;
	
	@Column(name = "cep", length = 80, nullable = true)
	private String cep;

	@Column(name = "telefone", length = 80, nullable = true)
	private String telefone;

	@Column(name = "celular", length = 80, nullable = true)
	private String celular;

	@Column(name = "email", length = 80, nullable = true)
	private String email;

}
