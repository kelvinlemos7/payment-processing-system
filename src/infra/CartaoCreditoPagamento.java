package infra;

import domain.Pagamento;
import domain.Recibo;

public class CartaoCreditoPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo("Cartão de Crédito", valor);
    }
}