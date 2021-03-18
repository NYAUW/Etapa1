package br.com.contmatic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CNPJ;

import br.contmatic.type.RamoAtividadeType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "cnpj")
public class Empresa extends AbstractAuditable {

	@NotBlank(message = "O CNPJ não pode ser vazio")
	@CNPJ(message = "CNPJ inválido")
	@Id
	private String cnpj;

	@NotBlank(message = "O nome fantasia não pode estar vazio!")
	@Min(value = 2, message = "O nome fantasia não contém a quantidade minima de 2 caracteres")
	@Max(value = 60, message = "O nome fantasia não pode conter mais que 60 caracteres")
	private String nomeFantasia;

	@NotNull(message = "O telefone não foi definido")
	private Telefone telefone;

	@NotNull(message = "O endereço não foi defnido")
	private Endereco endereco;

	@NotBlank(message = "A razão social não pode ficar vazia")
	@Min(value = 2, message = "A razão social não contém a quantidade minima de 2 caracteres")
	@Max(value = 80, message = "A razão social não pode conter mais que 80 caracteres")
	private String razaoSocial;

	@NotNull(message = "O ramo de atividade não foi deifinido")
	private RamoAtividadeType ramoAtividade;

	@NotBlank
	@Pattern(regexp = "[a-zA-Z]", message = "O nome do proprietário está inválido")
	@Min(value = 2, message = "O proprietario não contém a quantidade minima de 2 caracteres")
	@Max(value = 120, message = "A proprietario não pode conter mais que 120 caracteres")
	private String proprietario;
}
