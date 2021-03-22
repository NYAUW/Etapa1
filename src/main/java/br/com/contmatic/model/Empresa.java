package br.com.contmatic.model;

import static br.com.contmatic.constants.Regex.ALFA;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Size(min = 2, max = 60, message = "O nome fantasia deve ter entre 2 e 60 caracteres")
	private String nomeFantasia;

	@NotNull(message = "O telefone não foi definido")
	private Telefone telefone;

	@NotNull(message = "O endereço não foi defnido")
	private Endereco endereco;

	@NotBlank(message = "A razão social não pode ficar vazia")
	@Size(min = 2, max = 80, message = "A razão social deve ter entre 2 e 80 caracteres")
	private String razaoSocial;

	@NotNull(message = "O ramo de atividade não foi deifinido")
	private RamoAtividadeType ramoAtividade;

	@NotBlank
	@Pattern(regexp = ALFA, message = "O nome do proprietário está inválido")
	@Size(min = 2, max = 120, message = "O nome do proprietario deve estar entre 2 e 120 caracteres")
	private String proprietario;
}
