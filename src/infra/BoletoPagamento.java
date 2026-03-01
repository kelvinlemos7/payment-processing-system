package infra;

import domain.Pagamento;
import domain.Recibo;

public class BoletoPagamento implements Pagamento {

    private static final double DESCONTO_FIXO = 3.50;

    @Override
    public Recibo pagar(double valor) {

        double desconto = -DESCONTO_FIXO;
        double valorFinal = valor - desconto;

        return new Recibo("Boleto", valorFinal, desconto);
    }
}