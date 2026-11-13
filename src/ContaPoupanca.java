public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(String titular, double saldo, double taxaRendimento) {
        super(titular, saldo); // Chama o construtor da superclasse Conta
        this.taxaRendimento = taxaRendimento;
    }

    public void render() {
        double juros = saldo * taxaRendimento;
        saldo += juros; // Adiciona os juros gerados ao saldo
    }

    @Override
    public void exibirExtrato() {
        super.exibirExtrato(); // Mostra titular e saldo da classe mãe
        System.out.println("Taxa de rendimento: " + (taxaRendimento * 100) + "%");
    }
}