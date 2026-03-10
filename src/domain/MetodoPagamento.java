package domain;

public enum MetodoPagamento {

    PIX("Pix"),
    BOLETO("Boleto"),
    CARTAO_CREDITO("Cartão de Crédito"),
    DEBITO("Débito");

    private final String descricao;

    MetodoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}