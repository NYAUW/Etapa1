package br.com.contmatic.model;

import static br.com.contmatic.constants.Regex.ALFA;
import static br.com.contmatic.constants.Regex.EMAIL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "cpf")
public class Usuario extends AbstractAuditable {
	
	@Id
	@CPF(message = "CPF inválido")
	@NotBlank(message = "O CPF não pode ser vazio")
	private String cpf;

	@NotBlank(message = "O nome do usuário não pode ser vazio")
	@Pattern(regexp = ALFA, message = "O nome contém caracteres inválidos")
	@Size(min = 2, max = 120, message = "O nome do usuário deve conter de 2 a 120 caracteres")
	private String nome;
	
	@NotBlank(message = "O email não pode ser vazio")
	@Email(regexp = EMAIL,  message = "O email está inválido")
	@Size(min = 2, max = 80, message = "O email deve conter de 2 a 80 caracteres")
	private String email;

	@NotBlank(message = "A senha não pode ser vazia")
	@Size(min = 4, max = 16, message = "A senha deve conter de 4 a 16 caracteres")
	private String senha;
	
	@NotBlank(message = "O rg não pode ser vazio")
	@Size(min = 8, max = 8, message = "O RG deve conter de 8caracteres")
	@Digits(fraction = 0, integer = 8, message = "RG inválido")
	private String rg;

	@NotNull(message = "O endereço não pode ser vazio")
	private Endereco endereco;
	
	@NotNull(message = "O telefone não pode ser vazio")
	private Telefone telefone;

}
