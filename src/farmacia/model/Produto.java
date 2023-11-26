package farmacia.model;

public abstract class Produto {

	private int id;
	private String nome;
	private int tipo;
	private double preco;

	public Produto(int id, String nome, int tipo, double preco) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void visualizar() {
		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Medicamento";
			break;
		case 2:
			tipo = "Cosmético";
			break;
		default:
			tipo = "Tipo desconhecido";
			break;
		}
		
		System.out.println("ID: " + id);
		System.out.println("Nome: " + nome);
		System.out.println("Tipo: " + tipo);
		System.out.println("Preço: " + preco);

	}

}
