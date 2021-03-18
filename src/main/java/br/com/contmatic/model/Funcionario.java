package br.com.contmatic.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.custom.annotations.GreaterThanToday;
import br.contmatic.type.SexoType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"cpf", "codigo"})
public class Funcionario extends AbstractAuditable {
	
	@NotBlank
	@Min(value = 2, message = "O nome deve conter ao menos 2 caracteres")
	@Max(value = 120, message = "O nome excedeu o tamanho máximo de 120 caracteres")
	private String nome;
	
	@NotBlank
	@Min(value = 2, message = "O cargo deve conter ao menos 2 caracteres")
	@Max(value = 120, message = "O cargo excedeu o tamanho máximo de 120 caracteres")
	private String cargo;
	
	@Id
	@NotBlank
	@Min(value = 1, message = "O código deve ser maior que 0")
	private Integer codigo;
	
	@NotNull(message = "O salario precisa ser informado")
	private BigDecimal salario;

	@NotNull(message = "O sexo precisa ser informado")
	private SexoType sexo;
	
	@NotNull(message = "A data de nascimento não pode ser vazia")
	@GreaterThanToday(message = "A data de nascimento não pode ser superior que a atual")
	private LocalDate dataNascimento;

	@NotNull(message = "A data de admissão não pode ser vazia")
	@GreaterThanToday(message = "A data de admissão não pode ser superior que a atual")
	private LocalDate dataAdmissao;
	
	@GreaterThanToday(message = "A data de desligamento não pode ser superior que a atual")
	private LocalDate dataDesligamento;
	
	@Id
	@NotBlank(message = "O CPF não pode ser vazio!")
	@CPF(message = "CPF inválido")
	private String cpf;
}
