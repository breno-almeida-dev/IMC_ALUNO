package utilidades;

/*
 * Importa o pacote pessoaEAlunos e sua classe Aluno, para realizar
 * os métodos presentes nessa classe de:
 * - Verificar o CPF.
 * - Calcular o IMC.
 * - Calcular a situação do aluno.
 */
import pessoasEAlunos.Aluno;

public class FuncoesUteis {
	
	public static boolean verificarCpf(String cpf) {
		/*
		 * Essa instrução remove os caracteres que não são númericos.
		 * De modo que, se houver algum caractere não númerico o mesmo deve
		 * ser substituído por um espaço vazio.
		 */
		cpf = cpf.replaceAll("[^\\d]", "");
		
		/*
		 * Essa condição verifica, após remover os caracteres não numéricos, se
		 * os caracteres numéricos presentes resultam em 11 caracteres numéricos.
		 * 
		 * Caso haja mais ou menos de 11 caracteres, retorna como um CPF falso.
		 */
		if (cpf.length() != 11) {
			return false;
		}
		
		/*
		 * Essa condição faz uma última verificação antes do cálculo do CPF.
		 * 
		 * A condição verifica se os 11 caracteres númericos são iguais, caso sejam
		 * retorna "false", pois se trata de um CPF inválido.
		 */
		if (cpf.matches("(\\d)\\1{10}")) {
			return false;
		}
		
        /*
         * As regras oficiais de validação do número de CPF de uma pessoa, diz que para determinar o
         * primeiro dígito verificador, é preciso multiplicar os 9 primeiros números do CPF por 10
         * de forma decrescente, ou seja, o primeiro número do CPF é multiplicado por 10, o segundo por 9
         * e assim por diante até o 9º dígito, que será multiplicado por 2.
         * 
         * Primeiro é criada e inicializada uma variável "soma" para 
         * acumular o resultado das multiplicações dos 9 primeiros dígitos do CPF. 
         * 
         * Dentro do laço "for" a variável "soma" recebe o valor da multiplicação do
         * número da posição que "i" representa e multiplica o número dessa posição por
         * 10 menos o valor de "i", ou seja, o primeiro dígito será multiplicado por 10 - 0, já
         * o segundo dígito por 10 - 1, e assim sucessivamente.
         * 
         * Ao passar por cada dígito do CPF pela posição de "i", é realizada uma subtração por 0.
         * Isso acontece pois, por mais que sejam números armazenados na String, os mesmo não representam o número
         * em si, mas sim o caractere do número. Mas quando é realizada a subtração o caractere se transforma
         * em seu valor inteiro correspondente.
         */
        int soma = 0;        
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        
        /*
         * No processo de inicialização é realizado o cálculo do primeiro dígito.
         */
        int primeiroDigitoVerificador = 11 - (soma % 11);
        
        /*
         * Outra regra do cálculo dos digitos verificadores do CPF é a regra do 0 e 1.
         * 
         * Caso o restante da divisão da variável "soma" por 11 dê 0 ou 1, o número verificador
         * deve ser 0.
         * 
         * No caso a condição "if" leva em consideração o valor atribuído a variável após o cálculo.
         * Caso o valor chegue como maior ou igual a 10 indica que o restante da divisão menos 11
         * resultou em 1 ou 0, já que se deu 0, a variável chega como 11, e se deu 1 chega como 10.
         * 
         * E se for real a condição a variavél recebe o valor de 0.
         */
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }
        
        /*
         * Calcula o segundo dígito verificador, com a mesma lógica e equação do primeiro
         * dígito verificador, porém, agora como já foi descoberto o primeiro dígito, são
         * 10 números para realizar o cálculo e não 9. Portanto como no primeiro dígito
         * era multiplicado a partir do 10 até o 2, agora é a partir do 11 até o 2.
         * 
         * A variável "soma" é zerada, para ser reutilizada aqui, com a mesma função.
         */
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        
        /*
         * Semelhante ao primeiro dígito, na inicialização da variável é realizada o
         * calcúlo para se descobrir o segundo dígito verificador.
         */
        int segundoDigitoVerificador = 11 - (soma % 11);
        
        /*
         * Seguindo as mesmas regras, caso o resultado seja 10 ou 11, indica que o restante
         * da divisão deu 1 ou 0, então a condição se torna real e o valor do segundo dígito
         * recebe o valor de 0. 
         */
        if (segundoDigitoVerificador >= 10) {
        	segundoDigitoVerificador = 0;
        }
        
        /*
         * Verifica se os dígitos calculados conferem com os do CPF informado.
         * 
         * Caso sejam diferentes retorna "false" pois se trata de um CPF inválido.
         */
        return (cpf.charAt(9) - '0') == primeiroDigitoVerificador &&
        		(cpf.charAt(10) - '0') == segundoDigitoVerificador;
        
    }
	
	
	/*
	 * Esse método calcula o índice de massa corporal da pessoa (IMC).
	 * 
	 * O cálculo de IMC é feito ao dividir o peso da pessoa pela sua altura
	 * elevada ao cubo. 
	 */
	public static double calcularImc(double peso, double altura) {
		return peso/ (altura * altura);
	}
	
	
	/*
	 * Esse método calcula a situação de aprovação de um aluno.
	 * Levando em consideração a sua nota e seu percentual de presença.
	 * 
	 * Caso a nota seja maior ou igual a 5, e a presença seja maior ou igual a
	 * 75%, o aluno está aprovado, caso alguma condição seja falsa o aluno está reprovado.
	 * 
	 * Como parâmetro é passado o objeto "aluno" da classe Aluno, chamando os atributos
	 * específicos da classe, assim puxando o getNota e getPercentualPresenca.
	 */
	public static String situacaoAluno(Aluno aluno) {
		if (aluno.getNota() >= 5 && aluno.getPercentualPresenca() >= 75) {
			return "Aprovado!";
		} else {
			return "Reprovado!";
		}
	}
	
}
