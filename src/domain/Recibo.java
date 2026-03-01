package domain;

public class Recibo {

    private final String metodo;
    private final double valorFinal; 
    private final double ajuste;

    public Recibo(String metodo, double valorFinal, double ajuste) {
        this.metodo = metodo;
        this.valorFinal = valorFinal;
        this.ajuste = ajuste;
    }

    public String resumo() {

        if (ajuste > 0) {
            return "Metodo: " + metodo +
                   " | Valor: R$ " + valorFinal +
                   " | Taxa: R$ " + ajuste;
        }

        if (ajuste < 0) {
            return "Metodo: " + metodo +
                   " | Valor: R$ " + valorFinal +
                   " | Desconto: R$ " + Math.abs(ajuste);
        }

        return "Metodo: " + metodo +
               " | Valor: R$ " + valorFinal +
               " | Sem taxas";
    }
}