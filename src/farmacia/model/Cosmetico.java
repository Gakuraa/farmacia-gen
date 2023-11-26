package farmacia.model;

public class Cosmetico extends Produto {

	private String fragancia;

	public Cosmetico(int id, String nome, int tipo, double preco, String fragancia) {
		super(id, nome, tipo, preco);
		this.fragancia = fragancia;
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}

	@Override
	public void visualizar() {
		System.out.println("ID: " + getId());
		System.out.println("Nome: " + getNome());
		System.out.println("Tipo: Cosmético");
		System.out.println("Preço: " + getPreco());
		System.out.println("Fragrância: " + fragancia);
	}
}
