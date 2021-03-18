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
	
	@NotNull
	private BigDecimal salario;

	@NotNull
	private SexoType sexo;
	
	@NotNull
	@GreaterThanToday
	private LocalDate dataNascimento;

	@NotNull
	@GreaterThanToday
	private LocalDate dataAdmissao;
	
	@NotNull
	@GreaterThanToday
	private LocalDate dataDesligamento;
	
	@Id
	@NotBlank
	@CPF
	private String cpf;
}
