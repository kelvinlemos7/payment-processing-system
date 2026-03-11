package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;
import domain.TipoAjuste;

public class PixPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {

        double cashback = valor * 0.05;
        return new Recibo(MetodoPagamento.PIX, valor, cashback, TipoAjuste.CASHBACK);
    }
}