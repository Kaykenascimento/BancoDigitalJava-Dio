package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class CreditCard {
    private Integer numeroCartao;

    private Date validade;

    private Integer codigoSeg;

    public CreditCard() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        Random random = new Random();

        this.numeroCartao = random.nextInt(16);
        this.codigoSeg = random.nextInt(3);
        this.validade = simpleDateFormat.parse("01/01/2030");
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Integer getCodigoSeg() {
        return codigoSeg;
    }

    public void setCodigoSeg(Integer codigoSeg) {
        this.codigoSeg = codigoSeg;
    }

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
}
