package farmacia.model;

public class Medicamento extends Produto {

	private String generico;

	public Medicamento(int id, String nome, int tipo, double preco, String generico) {
		super(id, nome, tipo, preco);
		this.generico = generico;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	@Override
	public void visualizar() {
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + getNome());
		System.out.println("Tipo: Medicamento");
		System.out.println("Preço: " + getPreco());
		System.out.println("Genérico: " + generico);
	}
}
