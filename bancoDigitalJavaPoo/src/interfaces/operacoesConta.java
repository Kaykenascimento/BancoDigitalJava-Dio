package interfaces;

import domain.Conta;

import java.text.ParseException;

public interface operacoesConta {

    public static void sacarDinheiro(Conta conta, double valor) {

    }

    public static void depositarDinheiro(Conta conta, double valor) {

    }

    public static void transferirDinheiro(Conta suaConta, Conta contaDestino, double valor) {

    }

    public static void solicitarCartaoCredito(Conta conta) throws ParseException {

    }

    public void exibirDadosBancarios(Conta conta);
}
