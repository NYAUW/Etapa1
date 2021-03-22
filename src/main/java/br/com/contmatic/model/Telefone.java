package br.com.contmatic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.TelefoneType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "numero")
public class Telefone extends AbstractAuditable{
	
	@Id
	@Digits(fraction = 0, integer = 9)
	@NotBlank(message = "O numero não pode ser vazio")
	@Min(value = 8, message = "O número informado é inválido")
	@Max(value = 9, message = "O número informado é inválido")
	private String numero;
	
	@NotNull(message = "O tipo do telefone precisa ser informado")
	private TelefoneType tipoTelefone;
	
	@NotNull(message = "O ddd precisa ser informado")
	private DddType ddd;
	
	@NotNull(message = "O domínio precisa ser informado")
	private DominioTelefoneType dominio;

}
