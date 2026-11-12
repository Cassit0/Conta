public class Conta {
    private String titular;
    protected double saldo;

    //construtores vazios inicializar
    public Conta() {
        titular = "";
        saldo = 0;
    }

        //parametros da classe
    public Conta(String titular, double saldo){
            this.titular = titular;
            this.saldo = saldo;
        }

        // getters pega valor
        public String getTitular () {
            return titular;
        }

        public double getSaldo () {
            return saldo;
        }
        //setters

        public void setTitular (String titular){
            this.titular = titular;
        }

        public void setSaldo ( double saldo){
            this.saldo = saldo;
        }

        //metodos depositar e sacar

        public void depositar ( double soma){
            if (soma > 0) {
                saldo += soma;
            } else {
                System.out.println("Só aceita valor maior que 0;");
            }
        }

        public void sacar ( double valor){
            if (valor <= saldo) {
                saldo -= valor;
            } else {
                System.out.println("saldo insuficiente");
            }
        }

        public void extrato () {
            System.out.println("=====EXTRATO CONTA BANCÁRIA=====");
            System.out.println("Titular:" + titular);
            System.out.println("Saldo" + saldo);

        }

    }
