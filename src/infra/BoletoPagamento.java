package infra;

import domain.Pagamento;
import domain.Recibo;

public class BoletoPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {
        return new Recibo("Boleto", valor);
    }
}