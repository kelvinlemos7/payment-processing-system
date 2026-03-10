package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;

public class CartaoCreditoPagamento implements Pagamento {

    private static final double TAXA_CARTAO = 0.02;

    @Override
    public Recibo pagar(double valor) {

        double taxa = valor * TAXA_CARTAO;
        double valorFinal = valor + taxa;

        return new Recibo(MetodoPagamento.CARTAO_CREDITO, valorFinal, taxa);
    }
}