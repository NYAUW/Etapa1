package br.com.contmatic.model;

import static br.com.contmatic.validator.CpfValidator.isCpfValid;
import static br.com.contmatic.validator.DateValidator.isDateGreatherThanToday;
import static br.com.contmatic.validator.StringValidator.isCpfPattern;
import static br.com.contmatic.validator.StringValidator.isMaxChararacters;
import static br.com.contmatic.validator.StringValidator.isMinChararacters;
import static br.com.contmatic.validator.StringValidator.isNotBlank;
import static br.com.contmatic.validator.Validator.isNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.contmatic.utils.DateUtils;
import br.contmatic.type.SexoType;

public class Funcionario extends AbstractAuditable {

	private String nome;

	private String cargo;

	private Integer codigo;

	private BigDecimal salario;

	private SexoType sexo;

	private LocalDate dataNascimento;

	private LocalDate dataAdmissao;

	private LocalDate dataDesligamento;

	private String cpf;

	public Funcionario(String cpf) {
		setCpf(cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		isNotNull(nome, "nome");
		isNotBlank(nome, "nome");
		isMinChararacters(nome, 2);
		isMaxChararacters(nome, 100);
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		isNotNull(cargo, "cargo");
		isNotBlank(cargo, "cargo");
		isMinChararacters(nome, 2);
		isMaxChararacters(nome, 100);
		this.cargo = cargo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		isNotNull(codigo, "código");
		this.codigo = codigo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		isNotNull(salario, "salário");
		this.salario = salario;
	}

	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
		isNotNull(sexo, "sexo");
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return DateUtils.getIdade(dataNascimento);
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		isNotNull(dataNascimento, "data de nascimento");
		isDateGreatherThanToday(dataNascimento);
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		isNotNull(dataAdmissao, "data de admisão");
		isDateGreatherThanToday(dataAdmissao);
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		isNotNull(dataDesligamento, "data de desligamento");
		isDateGreatherThanToday(dataDesligamento);
		this.dataDesligamento = dataDesligamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		isNotNull(cpf, "cpf");
		isNotBlank(cpf, "cpf");
		isCpfPattern(cpf);
		isCpfValid(cpf);
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
