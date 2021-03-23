package br.com.contmatic.model;

import static br.com.contmatic.constants.Regex.ALFA;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.contmatic.type.SexoType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"cpf", "codigo"})
public class Funcionario extends AbstractAuditable {
	
	@Id
	@NotBlank
	@Min(value = 1, message = "O código deve ser maior que 0")
	private Integer codigo;
	
	@Id
	@NotBlank(message = "O CPF não pode ser vazio!")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	@NotBlank
	@Pattern(regexp = ALFA)
	@Size(min = 2, max = 120, message = "O nome deve conter de 2 a 120 caracteres")
	private String nome;
	
	@NotBlank
	@Size(min = 2, max = 120, message = "O cargo deve conter de 2 a 120 caracteres")
	private String cargo;
	
	@NotNull(message = "O salario precisa ser informado")
	private BigDecimal salario;

	@NotNull(message = "O sexo precisa ser informado")
	private SexoType sexo;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	@PastOrPresent(message = "A data de nascimento não pode ser superior que a atual")
	private LocalDate dataNascimento;

	@NotNull(message = "A data de admissão não pode ser vazia")
	@PastOrPresent(message = "A data de admissão não pode ser superior que a atual")
	private LocalDate dataAdmissao;
	
	@PastOrPresent(message = "A data de desligamento não pode ser superior que a atual")
	private LocalDate dataDesligamento;
}
