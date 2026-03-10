package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;

public class DebitoPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo(MetodoPagamento.DEBITO, valor, 0.0);
    }
}