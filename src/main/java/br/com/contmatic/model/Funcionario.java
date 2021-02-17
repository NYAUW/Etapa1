package br.com.contmatic.model;

import static br.com.contmatic.validator.StringValidator.validaFormataCpf;
import static br.com.contmatic.validator.StringValidator.validaNome;
import static br.com.contmatic.validator.Validator.isNotNull;
import static br.com.contmatic.validator.Validator.isNumeroEntre;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.contmatic.utils.DateUtils;
import br.contmatic.type.SexoType;

public class Funcionario {

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
		this.nome = validaNome(nome);
	}

	public void setCargo(String cargoNome) {
		this.cargo = (String) isNotNull(cargoNome);
	}

	public void setCodigo(int codigo) {
		this.codigo = isNumeroEntre(codigo, 99, 1000);
	}

	public void setSalario(BigDecimal salario) {
		this.salario = (BigDecimal) isNotNull(salario);
	}

	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
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
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
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
		this.cpf = validaFormataCpf(cpf);
	}
}
