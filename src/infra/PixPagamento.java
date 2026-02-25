package infra;

import domain.Pagamento;
import domain.Recibo;

public class PixPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo("PIX", valor);
    }
}