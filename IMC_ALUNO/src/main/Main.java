package main;

/*
 * Importa o pacote pessoaEAlunos e sua classe aluno, para assim
 * poder criar o objeto informando os seus dados.
 */
import pessoasEAlunos.Aluno;
import utilidades.FuncoesUteis;

/*
 * Classe Main que cria os objetos para teste dos métodos presentes
 * nos outros pacotes e classes.
 */
public class Main {

	public static void main(String[] args) {
        /*
         * Cria um objeto da classe Aluno para teste dos métodos.
         */
        Aluno aluno1 = new Aluno("Ozzy", "123.456.789-00", 70.0, 1.75, 8.0, 80.0);
        Aluno aluno2 = new Aluno("Tony", "12345678911", 71.0, 1.72, 5.0, 74.0);
        
        /*
         * Mostra no terminal os dados da pessoa que foi criada no objeto.
         */
        System.out.println(aluno1.dadosPessoa());
        
        /*
         * Uma instrução para retornar no terminal se o CPF informado é válido ou não.
         * 
         * Primeiro indica qual é a classe que deve ser chamada e em seguida diz
         * qual método presente nessa classe deve ser usado.
         * 
         * Assim, para finalizar, utiliza o getter do CPF do aluno como valor do
         * parâmetro deste método.
         */
        System.out.println("CPF válido: " + FuncoesUteis.verificarCpf(aluno1.getCpf()));
        
        /*
         * Para testar o método de calculo do IMC da pessoa, primeiramente é indicado qual
         * classe deve ser chamada, e logo em seguida o nome do método presente dentro desta
         * classe que deve ser usado para realizar o cálculo.
         * 
         * Por fim, utilizandos os getters, é informado os valores dos parâmetros do método
         * para poder realizar os cálculos.
         */
        System.out.println("IMC: " + FuncoesUteis.calcularImc(aluno1.getPeso(), aluno1.getAltura()));
        
        /*
         * Aqui, para realizar o teste do método de cálculo da situação do aluno é passado
         * que deve ser usado o objeto "aluno" e os seus valores informados.
         * 
         * Com isso no método de cálculo de situação do aluno é passado apenas os
         * valores dos atributos necessários para realizar o cálculo.
         */
        System.out.println("Situação do aluno: " + FuncoesUteis.situacaoAluno(aluno1));
        
        /*
         * Teste de aluno2.
         */
        System.out.println("\n\n" + aluno2.dadosPessoa());
        System.out.println("CPF válido: " + FuncoesUteis.verificarCpf(aluno2.getCpf()));
        System.out.println("IMC: " + FuncoesUteis.calcularImc(aluno2.getPeso(), aluno2.getAltura()));
        System.out.println("Situação do aluno: " + FuncoesUteis.situacaoAluno(aluno2));
        
	}

}
