Java Bank - Atividade de Herança em Java | Versão do Aluno Página 1
Atividade de Java
Sistema Bancário com Herança
Programação Orientada a Objetos | Versão do Aluno
Nível Tema Duração sugerida
Iniciante Classe, superclasse e subclasse 2 aulas de 50 min
Nome: ______________________________________________ Data: ____/____/______
1. Objetivos
Ao final, você deverá ser capaz de:
• Criar uma superclasse com atributos e métodos comuns;
• Criar subclasses com extends;
• Usar super(...) no construtor e super.metodo();
• Sobrescrever métodos com @Override;
• Encontrar e corrigir erros de herança.
2. Contexto
O banco Java Bank quer um sistema simples de contas. Existem três tipos:
Tipo Regras
Conta (genérica) Tem titular e saldo. Pode depositar, sacar e exibir o extrato.
ContaCorrente É uma Conta, mas tem limite de cheque especial. Pode sacar além do saldo, até o
limite.
ContaPoupanca É uma Conta, mas tem taxa de rendimento. Pode render juros sobre o saldo.
Pense assim: ContaCorrente é uma Conta e ContaPoupanca é uma Conta. Quando a frase "é um"
funciona, a herança faz sentido.
3. Parte 1: Construindo o sistema (passo a passo)
Passo 1: Superclasse Conta
Crie o arquivo Conta.java com:
• Atributos: private String titular e protected double saldo;
• Construtor: recebe titular e saldo inicial;
• void depositar(double valor): soma o valor ao saldo. Só aceita valor maior que 0;
• void sacar(double valor): subtrai do saldo somente se houver saldo suficiente. Caso
contrário, imprime "Saldo insuficiente!";
• void exibirExtrato(): imprime titular e saldo;
• getTitular() e getSaldo().
Dica: protected permite que as subclasses acessem saldo diretamente. private não permite.
Java Bank - Atividade de Herança em Java | Versão do Aluno Página 2
Passo 2: Subclasse ContaCorrente
Crie ContaCorrente.java:
• Use extends Conta;
• Novo atributo: private double limite;
• Construtor: recebe titular, saldo e limite. Chame super(titular, saldo) na
primeira linha;
• Sobrescreva sacar(double valor): permite sacar se valor <= saldo + limite. Caso
contrário, imprime "Limite excedido!";
• Sobrescreva exibirExtrato(): chame super.exibirExtrato() e depois imprima o limite.
Passo 3: Subclasse ContaPoupanca
Crie ContaPoupanca.java:
• Use extends Conta;
• Novo atributo: private double taxaRendimento (ex.: 0.05 = 5%);
• Construtor: recebe titular, saldo e taxaRendimento, e usa super(...);
• Novo método void render(): calcula saldo * taxaRendimento e adiciona ao saldo;
• Sobrescreva exibirExtrato(): chame super.exibirExtrato() e imprima a taxa.
Passo 4: Classe Main
Crie e teste:
public class Main {
public static void main(String[] args) {
ContaCorrente cc = new ContaCorrente("Ana", 500.0, 300.0);
ContaPoupanca cp = new ContaPoupanca("Bruno", 1000.0, 0.05);
cc.sacar(700.0); // deve funcionar (500 + 300 de limite)
cc.sacar(200.0); // deve falhar: "Limite excedido!"
cc.exibirExtrato();
cp.depositar(500.0);
cp.render();
cp.sacar(2000.0); // deve falhar: "Saldo insuficiente!"
cp.exibirExtrato();
}
}
Saída esperada:
Limite excedido!
Titular: Ana
Saldo: -200.0
Limite: 300.0
Saldo insuficiente!
Titular: Bruno
Saldo: 1575.0
Taxa de rendimento: 5.0%
Java Bank - Atividade de Herança em Java | Versão do Aluno Página 3
4. Parte 2: A Pegadinha! (Detetive de Bugs)
Um estagiário escreveu o código abaixo, mas ele tem 3 erros. Seu trabalho é: (a) encontrar cada
erro, (b) explicar por que acontece e (c) corrigir.
public class Conta {
private String titular;
protected double saldo;
public Conta(String titular, double saldo) {
this.titular = titular;
this.saldo = saldo;
}
public void sacar(double valor) {
if (valor <= saldo) {
saldo -= valor;
} else {
System.out.println("Saldo insuficiente!");
}
}
public String getTitular() { return titular; }
public double getSaldo() { return saldo; }
}
public class ContaCorrente extends Conta {
private double limite;
public ContaCorrente(String titular, double saldo, double limite) {
this.limite = limite;
}
public void sacar(int valor) {
if (valor <= saldo + limite) {
saldo -= valor;
} else {
System.out.println("Limite excedido!");
}
}
}
public class ContaPoupanca extends Conta {
private double taxaRendimento;
public ContaPoupanca(String titular, double saldo, double taxaRendimento) {
super(titular, saldo);
this.taxaRendimento = taxaRendimento;
}
public void render() {
double juros = saldo * taxaRendimento;
saldo + juros;
}
public void exibir() {
System.out.println("Titular: " + titular);
}
}
Perguntas guiadas
1. Tente compilar. Quais mensagens de erro aparecem? Qual linha cada uma aponta?
Java Bank - Atividade de Herança em Java | Versão do Aluno Página 4
2. Mesmo depois de corrigir os erros de compilação, rode este teste:
Conta c = new ContaCorrente("Ana", 500.0, 300.0);
c.sacar(700.0);
O resultado é o esperado? Por que a conta corrente não usou o limite? (Dica: compare a
assinatura do sacar da subclasse com a da superclasse. Adicionar @Override ajuda a
descobrir.)
3. Na ContaPoupanca, o método render() calcula os juros, mas o saldo nunca muda. O que
está faltando?
4. Na ContaPoupanca, o método exibir() tenta usar titular. Por que dá erro, mesmo sendo
uma subclasse? Qual a forma correta de obter o titular?
Tabela para preencher
Nº Classe Tipo do erro
(compilação ou
lógica)
Explicação com suas palavras Correção
1
2
3
4
Atenção: o enunciado diz 3 erros, mas ao analisar com cuidado você encontra um quarto. Fique de
olho!
5. Parte 3: Desafio extra (opcional)
1. Crie a subclasse ContaSalario, que não permite depósitos feitos por terceiros (sobrescreva
depositar) e tem um limite de 2 saques por mês.
2. Crie um array Conta[] contas com um objeto de cada tipo e percorra com for, chamando
exibirExtrato() em todos. Observe o que acontece e responda: como o Java sabe qual
versão do método chamar? (isso é polimorfismo).
6. Critérios de avaliação
Critério Pontos
Superclasse Conta correta 2,0
ContaCorrente com super, @Override e limite 2,0
ContaPoupanca com render() funcionando 1,5
Pegadinha: erros identificados e explicados 3,0
Código organizado e saída igual à esperada 1,5
Total 10,0
