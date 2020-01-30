package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.cliente.CadastroTest;
import br.com.contmatic.cliente.OrcamentoTest;
import br.com.contmatic.entidades.FuncionarioTest;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, CadastroTest.class, OrcamentoTest.class })
public class TestAllClass {

}
