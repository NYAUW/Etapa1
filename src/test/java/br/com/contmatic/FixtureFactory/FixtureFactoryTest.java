package br.com.contmatic.FixtureFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import org.junit.Test;

import br.com.contmatic.cliente.Cadastro;
import br.com.contmatic.cliente.Orcamento;
import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Funcionario;
import br.com.contmatic.endereco.Endereco;
import br.com.contmatic.endereco.TipoEndereco;
import br.com.contmatic.telefone.Telefone;
import br.com.contmatic.telefone.TipoTelefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FixtureFactoryTest implements TemplateLoader {

    @Test
    @Override
    public void load() {
        Fixture.of(Cadastro.class).addTemplate("cadastro", new Rule() {
            {
                add("nome", name());
                add("email", "pauzinho@gmail.com");
                add("senha", regex("[a-zA-Z0-9]{6}"));
                add("cpf", GeraCpf());
                add("rg", regex("[0-9]{1}.[0-9]{3}.[0-9]{3}-[0-9]{2}"));
            }
        });

        Fixture.of(Telefone.class).addTemplate("telefone", new Rule() {
            {
                add("numero", regex(
                    "(([1][1-9])|([2][1-2])|([2][4-8])|([3][1-5])|([3][7-8])|([4][1-9])|([5][1])|([5][3-5])|([6][1-9])|([7][1])|([7][3-5])|([7][7])|([7][9])|([8][1-9]))(([2-9]{8})|([2-9]{9}))"));
                add("ramal", regex("[0-9]{3}"));
                add("tipo", random(TipoTelefone.CELULAR, TipoTelefone.FIXO));
            }
        });

        Fixture.of(Endereco.class).addTemplate("endereco", new Rule() {
            {
                add("rua", random("Rua Manoel Padre Satanista", "Rua Tuiti", "Av. Estados"));
                add("bairro", random("Mascarenhas de Morais", "Sao Matheus", "Santa Adélia"));
                add("numero", random(1000));
                add("regiao", random("Zona Leste", "Zona Sul", "Zona Norte", "Sudeste"));
                add("cep", regex("[0-9]{8}"));
                add("tipo", random(TipoEndereco.APARTAMENTO, TipoEndereco.CASA, TipoEndereco.CONDOMINIO, TipoEndereco.EMPRESARIAL));
            }
        });

        Fixture.of(Orcamento.class).addTemplate("orcamento", new Rule() {
            {
                add("marca", random("Sony", "Phillips", "Nitendo"));
                add("serial", regex("[A-Z]{3}[0-9]{3}"));
                add("defeito", regex("[a-z]{10} [a-z]{10}"));
            }
        });

        Fixture.of(Empresa.class).addTemplate("empresa", new Rule() {
            {
                add("cnpj", cnpj());
                add("nome", name());
                add("razaoSocial", regex("[a-z]{7} [a-z]{15} [a-z]{10}"));
                add("proprietarios", name());
                add("telefones", new HashSet<>());
                add("endereco", new HashSet<>());
            }
        });

        Fixture.of(Funcionario.class).addTemplate("funcionario", new Rule() {
            {
                add("nome", name());
                add("cargo", random("Atendente", "Tecnico", "Auxiliar"));
                add("codigo", random(9999));
                add("salario", random(9999));
            }
        });

    }

    private String GeraCpf() {
        Random random = new Random();
        int numeros[] = new int[9];
        for(int i = 0 ; i < numeros.length ; i++) {
            numeros[i] = random.nextInt(9);
        }
        int calculoDigito1 = (((numeros[0] * 10) + (numeros[1] * 9) + (numeros[2] * 8) + (numeros[3] * 7) + (numeros[4] * 6) + (numeros[5] * 5) + (numeros[6] * 4) + (numeros[7] * 3) +
            (numeros[8] * 2)));
        int divisaoDigito1 = calculoDigito1 / 11;
        int multiplicacaoDigito1 = 11 * divisaoDigito1;
        int subtracaoDigito1 = calculoDigito1 - multiplicacaoDigito1;
        int Digito1 = 11 - subtracaoDigito1;
        String aux = Integer.toString(Digito1);

        if (Digito1 >= 11) {
            Digito1 += -Digito1;
        } else if (aux.length() >= 2) {
            Digito1 += -10;
        }
        int calculoDigito2 = (((numeros[0] * 11) + (numeros[1] * 10) + (numeros[2] * 9) + (numeros[3] * 8) + (numeros[4] * 7) + (numeros[5] * 6) + (numeros[6] * 5) + (numeros[7] * 4) +
            (numeros[8] * 3) + (Digito1 * 2)));
        int divisaoDigito2 = calculoDigito2 / 11;
        int multiplicacaoDigito2 = 11 * divisaoDigito2;
        int subtracaoDigito2 = calculoDigito2 - multiplicacaoDigito2;
        int Digito2 = 11 - subtracaoDigito2;
        String aux2 = Integer.toString(Digito2);

        if (Digito2 >= 11) {
            Digito2 += -Digito2;
        } else if (aux2.length() >= 2) {
            Digito2 += -10;
        }
        String cpf = Arrays.toString(numeros).replace("[", "").replace(",", "").replace("]", "").replace(" ", "") + Digito1 + Digito2;
        return cpf;
    }
}
