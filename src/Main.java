public class Main {
    static void main(String[] args) {
        Conta conta1 = new Conta("bellinha", 500);

        conta1.depositar(1);
        conta1.sacar(500);
        conta1.extrato();


    }
}