package domain;

public class Recibo {

    private final String metodo;
    private final double valor;

    public Recibo(String metodo, double valor) {
        this.metodo = metodo;
        this.valor = valor;
    }

    public String resumo() {
        return "Metodo: " + metodo + " | Valor: R$ " + valor;
    }
}