package regrasNegocio;

import domain.Conta;
import domain.CreditCard;
import domain.Genero;
import interfaces.operacoesConta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class helperTransaction implements operacoesConta {

    public static void sacarDinheiro(Conta conta, double valor) {
        if(helperValidation.verificarPossibilidadeTransacaoBancaria(conta, valor)) {
            double novoSaldo = conta.getSaldo() - valor;
            conta.setSaldo(novoSaldo);

            System.out.println("Você sacou: R$ " + valor);
        }
    }

    public static void depositarDinheiro(Conta conta, double valor) {
        if(helperValidation.verificarPossibilidadeDeposito(valor)) {
            double novoSaldo = conta.getSaldo() + valor;
            conta.setSaldo(novoSaldo);

            System.out.println("Você depositou: R$ " + valor);
        }
    }

    public static void transferirDinheiro(Conta suaConta, Conta contaDestino, double valor) {
        if(helperValidation.verificarPossibilidadeTransacaoBancaria(suaConta, valor)) {
            sacarDinheiro(suaConta, valor);
            depositarDinheiro(contaDestino, valor);

            System.out.println("Você transferiu para " + contaDestino.getPessoa().getNome() + " o total de: R$ " + suaConta.getSaldo());
            System.out.println("Seu saldo atual da sua conta é: R$ " + suaConta.getSaldo());
        }
    }

    public static void solicitarCartaoCredito(Conta conta) throws ParseException {
        if(helperValidation.verificarPossibilidadeCartao(conta)) {
            CreditCard cartaoCredito = new CreditCard();
            conta.setCreditCard(cartaoCredito);

            System.out.println("Cartão de Crédito solicitado com sucesso!");
        }
    }

    public void exibirDadosBancarios(Conta conta) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        System.out.println("Nome: " + conta.getPessoa().getNome());
        System.out.println("CPF: " + conta.getPessoa().getCpf());
        System.out.println("Gênero: " + Genero.getNomeGenero(conta.getPessoa().getGenero().getGenero()));
        System.out.println("Data de Nascimento: " + simpleDateFormat.format(conta.getPessoa().getDataNascimento()));
        System.out.println("Banco: " + conta.getNomeBanco());
        System.out.println("Agência: " + conta.getCodigo());
        System.out.println("Nº da Conta: " + conta.getNumero());
    }

}
