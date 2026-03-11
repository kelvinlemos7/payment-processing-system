package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;
import domain.TipoAjuste;

public class BoletoPagamento implements Pagamento {

    private static final double DESCONTO_FIXO = 3.50;

    @Override
    public Recibo pagar(double valor) {
        return pagar(valor, 0);
    }

    public Recibo pagar(double valor, int diasAtraso) {

        double desconto;
        if (valor <= 100) {
            desconto = -DESCONTO_FIXO;
        } else if (valor <= 500) {
            desconto = -7.50;
        } else {
            desconto = -10.00;
        }

        double multa = diasAtraso > 0 ? diasAtraso * 1.5 : 0;

        double ajuste = desconto + multa;
        double valorFinal = valor + ajuste;

        return new Recibo(MetodoPagamento.BOLETO, valorFinal, ajuste, TipoAjuste.DESCONTO);
    }
}