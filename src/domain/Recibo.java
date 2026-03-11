package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recibo {

    private final MetodoPagamento metodo;
    private final double valorFinal;
    private final double ajuste;
    private final TipoAjuste tipoAjuste;
    private final LocalDateTime dataRecibo;

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Recibo(MetodoPagamento metodo, double valorFinal, double ajuste, TipoAjuste tipoAjuste) {
        this.metodo = metodo;
        this.valorFinal = valorFinal;
        this.ajuste = ajuste;
        this.tipoAjuste = tipoAjuste;
        this.dataRecibo = LocalDateTime.now();
    }

    public String resumo() {

        String dataFormatada = dataRecibo.format(FORMATADOR);
        String textoAjuste;

        switch (tipoAjuste) {
            case TAXA:
                textoAjuste = "Taxa: R$ " + ajuste;
                break;
            case DESCONTO:
                textoAjuste = "Desconto: R$ " + Math.abs(ajuste);
                break;
            case CASHBACK:
                textoAjuste = "Cashback: R$ " + ajuste;
                break;
            default:
                textoAjuste = "Sem ajustes";
        }

        return "Metodo: " + metodo +
               " | Valor: R$ " + valorFinal +
               " | " + textoAjuste +
               " | Data: " + dataFormatada;
    }
}