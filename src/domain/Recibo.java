package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Recibo {

    private final MetodoPagamento metodo;
    private final double valorFinal;
    private final double ajuste;
    private final LocalDateTime dataRecibo;

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Recibo(MetodoPagamento metodo, double valorFinal, double ajuste) {
        this.metodo = metodo;
        this.valorFinal = valorFinal;
        this.ajuste = ajuste;
        this.dataRecibo = LocalDateTime.now();
    }

    public String resumo() {
        String dataFormatada = dataRecibo.format(FORMATADOR);

        String textoAjuste;

        if (ajuste > 0) {
            textoAjuste = "Taxa: R$ " + ajuste;
        } else if (ajuste < 0) {
            textoAjuste = "Desconto: R$ " + Math.abs(ajuste);
        } else {
            textoAjuste = "Sem taxas";
        }

        return "Metodo: " + metodo.toString() +
               " | Valor: R$ " + valorFinal +
               " | " + textoAjuste +
               " | Data: " + dataFormatada;
    }
}