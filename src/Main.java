import domain.Pagamento;
import domain.Recibo;
import infra.BoletoPagamento;
import infra.CartaoCreditoPagamento;
import infra.DebitoPagamento;
import infra.PixPagamento;
import service.ProcessadorPagamento;

public class Main {

    public static void main(String[] args) {

        ProcessadorPagamento processador = new ProcessadorPagamento();

        Pagamento pix = new PixPagamento();
        Pagamento cartao = new CartaoCreditoPagamento();
        Pagamento boleto = new BoletoPagamento();
        Pagamento debito = new DebitoPagamento();

        Recibo reciboPix = processador.processar(pix, 150.00);
        Recibo reciboCartao = processador.processar(cartao, 320.00);
        Recibo reciboBoleto = processador.processar(boleto, 90);
        Recibo reciboDebito = processador.processar(debito, 230);

        System.out.println(reciboPix.resumo());
        System.out.println(reciboCartao.resumo());
        System.out.println(reciboBoleto.resumo());
        System.out.println(reciboDebito.resumo());
    }
}