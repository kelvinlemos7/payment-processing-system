package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;

public class PixPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo(MetodoPagamento.PIX, valor, 0.0);
    }
}