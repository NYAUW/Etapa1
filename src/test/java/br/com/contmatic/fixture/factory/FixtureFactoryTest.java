package br.com.contmatic.fixture.factory;

import static br.com.contmatic.utils.CpfUtil.geraCpf;
import static br.com.contmatic.utils.EnumUtil.getRandomValue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

import org.junit.Test;

import br.com.contmatic.model.Empresa;
import br.com.contmatic.model.Endereco;
import br.com.contmatic.model.Funcionario;
import br.com.contmatic.model.Telefone;
import br.com.contmatic.model.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.contmatic.type.DddType;
import br.contmatic.type.DominioTelefoneType;
import br.contmatic.type.EstadosType;
import br.contmatic.type.SexoType;
import br.contmatic.type.TelefoneType;

public class FixtureFactoryTest<E> implements TemplateLoader {

    @Test
    @Override
    public void load() {
        Fixture.of(Usuario.class).addTemplate("usuario", new Rule() {
            {
                add("nome", name());
                add("email", regex("[a-z]{8}@gmail.com"));
                add("senha", regex("[a-zA-Z0-9]{5}"));
                add("cpf", geraCpf());
                add("rg", regex("[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9]{2}"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("telefone", new Rule() {
            {
                add("ddd", random(getRandomValue(DddType.values())));
                add("numero", regex("([0-9]{8})|(9[0-9]{8})"));
                add("tipoTelefone", random(TelefoneType.CELULAR, TelefoneType.FIXO));
                add("dominio", random(getRandomValue(DominioTelefoneType.values())));
            }
        });

        Fixture.of(Endereco.class).addTemplate("endereco", new Rule() {
            {
                add("logradouro", name());
                add("bairro", random("Mascarenhas de Morais", "Sao Matheus", "Santa Adélia"));
                add("numero", new Random().nextInt(9999));
                add("estado", random(getRandomValue(EstadosType.values())));
                add("cep", regex("[0-9]{8}"));
                add("complemento", name());
            }
        });
        Fixture.of(Empresa.class).addTemplate("empresa", new Rule() {
            {
                add("cnpj", cnpj());
                add("nomeFantasia", name());
                add("razaoSocial", regex("[a-z]{7} [a-z]{15}"));
                add("proprietario", name());
            }
        });

        Fixture.of(Funcionario.class).addTemplate("funcionario", new Rule() {
            {
                add("nome", name());
                add("cargo", random("Atendente", "Tecnico", "Auxiliar"));
                add("codigo", random(Integer.class, range(100, 500)));
                add("salario", random(BigDecimal.class, range(1045, 5000)));
                add("sexo", random(getRandomValue(SexoType.values())));
                add("dataNascimento", random(LocalDate.of(2001, 12, 11)));
                add("dataAdmissao", random(LocalDate.now()));
            }
        });

    }
}