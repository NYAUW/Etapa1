package br.com.contmatic.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.contmatic.utils.DateUtils;
import br.com.contmatic.validator.CpfValidator;
import br.com.contmatic.validator.StringValidator;
import br.com.contmatic.validator.Validator;
import br.contmatic.type.SexoType;

public class Funcionario extends AbstractAuditable<Funcionario>{

	private String nome;

	private String cargo;

	private int codigo;

	private BigDecimal salario;

	private SexoType sexo;

	private Integer idade;

	private LocalDate dataNascimento;

	private LocalDate dataAdmissao;

	private LocalDate dataDesligamento;

	private String cpf;

	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public int getCodigo() {
		return codigo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargo(String cargoNome) {
		Validator.isNotNull(cargoNome, "nome do cargo");
		this.cargo = cargoNome;
	}

	public void setCodigo(int codigo) {
		Validator.isNotNull(codigo, "código");
		Validator.isNumberBetween(codigo, 1000, 9999, "código");
		this.codigo = codigo;
	}

	public void setSalario(BigDecimal salario) {
		Validator.isNotNull(salario, "salário");
		this.salario = salario;
	}

	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
		Validator.isNotNull(sexo, "sexo");
		this.sexo = sexo;
	}

	public Integer getIdade() {
		idade = DateUtils.getIdade(dataNascimento);
		return idade;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		Validator.isNotNull(dataNascimento, "data de nascimento");
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		Validator.isNotNull(dataAdmissao, "data de admissao");
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDate dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		Validator.isNotNull(cpf, "cpf");
		StringValidator.isCpfPattern(cpf);
		CpfValidator.isCpfValid(cpf);
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		if (codigo != other.codigo)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
}
