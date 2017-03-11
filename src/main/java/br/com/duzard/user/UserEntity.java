package br.com.duzard.user;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.duzard.utils.BaseEntity;

@Entity
@Table(name = "usuarios")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;

	@NotNull
	@Size(min = 4, max = 120)
	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@Email
	@NotNull
	@NotEmpty
	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@NotNull
	@Size(min = 3, max = 80)
	@Column(name = "password", length = 80, nullable = false)
	private String password;
	
	@Column(name = "data_cadastro")
	private String dataCadastro;

	public UserEntity() {
	}

	public UserEntity(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		Date d = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatador.format(d.getTime());
		this.dataCadastro = data;
	}
	

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}

}
