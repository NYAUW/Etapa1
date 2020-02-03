package br.com.contmatic.FixtureFactory;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.cliente.Orcamento;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FixtureFactoryTest implements TemplateLoader {

    public void load() {
        Fixture.of(Cadastro.class).addTemplate("cadastro", new Rule() {
            {
                add("nome", name());
                add("email", "new.heroes_234@gmail.com");
                add("senha", regex("[a-zA-Z0-9]{6}"));
                add("cpf", regex("[0-9]{14}"));
                add("rg", regex("[0-9]{9}"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("telefone", new Rule() {{
            add("numero", regex("[0-9]{10}"));
            add("ramal", regex("[0-9]{3}"));
            add("tipo", random("Empresarial", "Domestico", "Teste"));
        }});
        
        Fixture.of(Endereco.class).addTemplate("endereco", new Rule() {{
            add("rua", name());
            add("bairro", random("Vila Ema", "Vila Carmosinha", "Pq. Erasmo Assunção", "Vila Clara", "Vila Diva", "Aguas Razas", "Sapopemba"));
            add("numero", random(1000));
            add("regiao", random("Zona Leste", "Zona Sul", "Zona Norte", "Sudeste"));
            add("cep", regex("[0-9]{8}"));
        }});
        
        Fixture.of(Orcamento.class).addTemplate("orcamento", new Rule() {{
            add("marca", random("Sony", "Phillips", "Nitendo"));
            add("serial", regex("[A-Z]{3}[0-9]{3}"));
            add("defeito", regex("[a-z]{10} [a-z]{10}"));
        }});
        
    }
}
