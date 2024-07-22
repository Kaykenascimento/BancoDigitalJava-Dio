package domain;

import java.util.Date;
import java.util.Random;

public class Conta extends instituicaoFinanceira {
    private String numero;

    private boolean ativa;

    private Double saldo;

    private Cliente cliente;

    private Date dataCriacao;

    private CreditCard creditCard;

    private boolean possuiCredito;

    public Conta() {
        Random random = new Random();
        this.numero = "" + random.nextInt(4) + "-" + random.nextInt(1);
        this.cliente = new Cliente();
        this.saldo = 0.0;
        this.ativa = Boolean.TRUE;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getPessoa() {
        return cliente;
    }

    public void setPessoa(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public CreditCard getCartaoCredito() {
        return creditCard;
    }

    public void setCreditCard(CreditCard cartaoCredito) {
        this.creditCard = cartaoCredito;
    }

    public boolean isPossuiCredito() {
        return possuiCredito;
    }

    public void setPossuiCredito(boolean possuiCredito) {
        this.possuiCredito = possuiCredito;
    }
}
