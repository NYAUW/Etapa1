package br.com.contmatic.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.empresa.test.EmpresaTest;
import br.com.contmatic.funcionario.test.FuncionarioTest;
import br.com.contmatic.orcamento.test.OrcamentoTest;
import br.com.contmatic.usuario.test.UsuarioTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	EmpresaTest.class,
	FuncionarioTest.class,
	UsuarioTest.class,
	OrcamentoTest.class })
public class TestAllClass {

}
