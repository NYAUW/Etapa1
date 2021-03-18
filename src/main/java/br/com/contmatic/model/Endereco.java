package br.com.contmatic.model;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.contmatic.type.EstadosType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"cep", "numero"})
public class Endereco extends AbstractAuditable {
	
	@NotBlank
	@Min(value = 2, message = "O nome do Bairro deve conter ao menos 2 caracteres")
	@Max(value = 80, message = "O nome do Bairro deve ter no máximo 80 caracteres")
	private String bairro;
	
	@NotNull(message = "O estado não pode ser vazio!")
	private EstadosType estado;
	
	@NotBlank(message = "O Logradouro não pode ser vazio!")
	@Min(value = 2, message = "O Logradouro deve conter ao menos 2 caracteres")
	@Max(value = 80, message = "O Logradouro deve ter no máximo 80 caracteres")
	private String logradouro;
	
	@Id
	@NotBlank
	@Min(value = 8, message = "O CEP não contem a quantidade mínima de 8 caracteres")
	@Max(value = 8, message = "O CEP excedeu a quantidade máxima de 8 caracteres")
	private String cep;
	
	@Min(value = 2, message = "O complemento deve conter ao menos 2 caracteres")
	@Max(value = 60, message = "O complemento excedeu a quantidade de 60 caracteres")
	private String complemento;
	
	@Id
	@NotNull
	@Min(value = 1, message = "O número não pode ser menor que 1")
	private Integer numero;
	
}
