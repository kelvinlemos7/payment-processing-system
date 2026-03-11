package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;
import domain.TipoAjuste;

public class DebitoPagamento implements Pagamento {

    @Override
    public Recibo pagar(double valor) {

        if (valor > 1000) {
            throw new IllegalArgumentException("Limite diario excedido! Volte no dia seguinte para conseguir realizar a transferencia.");
        }
        return new Recibo(MetodoPagamento.DEBITO, valor, 0.0, TipoAjuste.NENHUM);
    }
}