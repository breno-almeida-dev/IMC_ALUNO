package pessoasEAlunos;

/*
 * Classe pessoa, que tem seus atributos como privados para acesso e manipulação
 * apenas de dentro da classe.
 */
public class Pessoa {
	String nome;
	String cpf;
	double peso;
	double altura;
	
	/*
	 * Método construtor que inicializa os atributos com os valores dos parâmetros
	 * para depois receberem os valores através dos Setters.
	 */
	public Pessoa(String nome, String cpf, double peso, double altura) {
		this.nome = nome;
		this.cpf = cpf;
		this.peso = peso;
		this.altura = altura;
	}
	
	/*
	 * Setters para definir os valores dos atributos com os valores
	 * vindos da classe Main. 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	/*
	 * Getters que retornam os valores de seus respectivos atributos para
	 * acesso de fora da classe.
	 */
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	/*
	 * Método para descrever os dados da pessoa que foi
	 * criado o objeto na classe Main. 
	 */
	public String dadosPessoa() {
		return
			"Nome completo: " + getNome() + "\n" +
			"Peso: " + getPeso() + "\n" +
			"Altura: " + getAltura() + "m";

	}
	
}
