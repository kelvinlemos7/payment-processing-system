package infra;

import domain.Pagamento;
import domain.Recibo;

public class DebitoPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo("Débito", valor, 0.0);
    }
}