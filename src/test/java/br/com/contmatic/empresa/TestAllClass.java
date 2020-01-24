package br.com.contmatic.empresa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.contmatic.entidades.FuncionarioTest;
import br.com.contmatic.features.CadastroTest;
import br.com.contmatic.features.OrcamentoTest;

@RunWith(Suite.class)
@SuiteClasses({ EmpresaTest.class, FuncionarioTest.class, CadastroTest.class, OrcamentoTest.class })
public class TestAllClass {

}
