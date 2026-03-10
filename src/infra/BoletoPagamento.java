package infra;

import domain.MetodoPagamento;
import domain.Pagamento;
import domain.Recibo;

public class BoletoPagamento implements Pagamento {

    // Valor base de desconto
    private static final double DESCONTO_FIXO = 3.50;

    @Override
    public Recibo pagar(double valor) {
        // Chama método interno com zero dias de atraso
        return pagar(valor, 0);
    }

    // Método sobrecarregado: recebe valor e dias de atraso
    public Recibo pagar(double valor, int diasAtraso) {

        // Desconto variável conforme o valor do boleto
        double desconto;
        if (valor <= 100) {
            desconto = -DESCONTO_FIXO;
        } else if (valor <= 500) {
            desconto = -7.50;
        } else {
            desconto = -10.00;
        }

        // Multa por atraso (simples: 1,5 por dia)
        double multa = diasAtraso > 0 ? diasAtraso * 1.5 : 0;

        // Valor final = valor original + ajuste (desconto + multa)
        double ajuste = desconto + multa;
        double valorFinal = valor + ajuste;

        // Retorna recibo completo
        return new Recibo(MetodoPagamento.BOLETO, valorFinal, ajuste);
    }
}