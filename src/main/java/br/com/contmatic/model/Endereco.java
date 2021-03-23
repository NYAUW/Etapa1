package br.com.contmatic.model;

import static br.com.contmatic.constants.Regex.ALFA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.contmatic.type.EstadosType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = {"cep", "numero"})
public class Endereco extends AbstractAuditable {
	
	@Id
	@NotBlank
	@Digits(fraction = 0, integer = 8, message = "O CEP está inválido")
	@Size(min = 8, max = 8, message = "O CEP deve conter 8 caracteres")
	private String cep;
	
	@Id
	@NotNull
	@Min(value = 1, message = "O número não pode ser menor que 1")
	private Integer numero;
	
	@NotBlank
	@Pattern(regexp = ALFA, message = "Bairro inválido")
	@Size(min = 2, max = 80, message = "O nome do Bairro deve conter de 2 a 80 caracteres")
	private String bairro;
	
	@NotNull(message = "O estado não pode ser vazio!")
	private EstadosType estado;
	
	@NotBlank(message = "O Logradouro não pode ser vazio!")
	@Pattern(regexp = ALFA, message = "Logradouro inválido")
	@Size(min = 2, max = 80, message = "O Logradouro deve conter de 2 a 80 caracteres")
	private String logradouro;
	
	@Size(min = 2, max = 60, message = "O complemento deve conter de 2 a 60 caracteres")
	private String complemento;
	
}
