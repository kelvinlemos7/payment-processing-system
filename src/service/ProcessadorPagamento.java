package service;

import domain.Pagamento;
import domain.Recibo;

public class ProcessadorPagamento {

    public Recibo processar(Pagamento pagamento, double valor) {
        return pagamento.pagar(valor);
    }
}