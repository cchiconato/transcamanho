package br.com.duzard.conta;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.duzard.empresa.EmpresaEntity;
import br.com.duzard.utils.BaseEntity;
import lombok.Data;

@Data
@Entity
@Table(name = "contas")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class ContaEntity extends BaseEntity<Long> {
	
	private static final long serialVersionUID = 201602010251L;

	@ManyToOne
	@JoinColumn(name ="empresa" , nullable= false)
	private EmpresaEntity empresaId;

	@Column(name = "descricao", length = 255, nullable = true)
	private String descricao;

	@Column(name = "valor", length = 80, nullable = true)
	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "data", length = 80, nullable = true)
	private Date data;
	
	@Column(name = "forma_pagamento", length = 80, nullable = true)
	private String fomaPagamento;
	
	@Column(name = "status", length = 80, nullable = true)
	private String status;
	
}
