package pessoasEAlunos;

/*
 * Classe Aluno que estende a super classe Pessoa.
 * Essa sub classe herda os atributos da super classe e
 * define os seus atributos únicos.
 */
public class Aluno extends Pessoa{
	private double nota;
	private double percentualPresenca;
	
	/*
	 * Método construtor que herda os atributos e seus valores vindos da super classe.
	 * E inicializa os atributos únicos da classe com os valores dos parâmetros.
	 */
	public Aluno(String nome, String cpf, double peso, double altura, double nota, double percentualPresenca) {
		super(nome, cpf, peso, altura);
		this.nota = nota;
		this.percentualPresenca = percentualPresenca;
	}
	
	/*
	 * Setters para instanciar os atributos da classe com os valores vindos da classe Main.
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public void setPercentualPresenca(double percentualPresenca) {
		this.percentualPresenca = percentualPresenca;
	}
	
	/*
	 * Getters que retornam os valores de suas respectivas variáveis.
	 * Para assim controlar o acesso direto aos atributos.
	 */
	public double getNota() {
		return nota;
	}
	
	public double getPercentualPresenca() {
		return percentualPresenca;
	}
	
}
