package domain;

import java.util.Date;

public class instituicaoFinanceira {

    private String nomeBanco;

    private String cnpj;

    private Date dataCriacao;

    private String codigo;

    public instituicaoFinanceira() {
        this.nomeBanco = "Java Bank";
        this.cnpj = "29538342000141";
        this.dataCriacao = new Date();
        this.codigo = "0001";
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
