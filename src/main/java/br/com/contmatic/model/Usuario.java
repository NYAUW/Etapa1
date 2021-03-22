package br.com.contmatic.model;

import static br.com.contmatic.constants.Regex.EMAIL;
import static br.com.contmatic.constants.Regex.NOME;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@Pattern(regexp = NOME, message = "O nome contém caracteres inválidos")
	@Max(value = 120, message = "O nome do usuario não pode exceder 120 caracteres")
	@Min(value = 2, message = "O nome do usuário não pode ser menor que 2 caracteres")
	private String nome;
	
	@NotBlank(message = "O email não pode ser vazio")
	@Email(regexp = EMAIL,  message = "O email está inválido")
	@Min(value = 2, message = "O email não pode ser menor que 2 caracteres")
	@Max(value = 80, message = "O email não pode ser maior que 80 caracteres")
	private String email;

	@NotBlank(message = "A senha não pode ser vazia")
	@Min(value = 4, message = "A senha precisa ser maior que 4 caracteres")
	@Max(value = 16, message = "A senha precisa ser menor que 16 caracteres")
	private String senha;
	
	@NotBlank(message = "O rg não pode ser vazio")
	@Min(value = 8, message = "O RG deve conter 8 caracteres")
	@Max(value = 8, message = "O RG deve conter 8 caracteres")
	@Digits(fraction = 0, integer = 8, message = "RG inválido")
	private String rg;

	@NotNull(message = "O endereço não pode ser vazio")
	private Endereco endereco;
	
	@NotNull(message = "O telefone não pode ser vazio")
	private Telefone telefone;

}
