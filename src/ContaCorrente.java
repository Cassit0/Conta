public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo); // Chama o construtor da superclasse Conta
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // O saque é permitido se o valor couber na soma do saldo + limite
        if (valor <= (saldo + limite)) {
            saldo -= valor;
        } else {
            System.out.println("Limite excedido!");
        }
    }

    @Override
    public void exibirExtrato() {
        super.exibirExtrato(); // Mostra titular e saldo da classe mãe
        System.out.println("Limite: " + limite); // Mostra o limite específico da corrente
    }
}