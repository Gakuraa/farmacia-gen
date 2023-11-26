package farmacia.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import farmacia.model.Produto;
import farmacia.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private List<Produto> produtos = new ArrayList<>();

	@Override
	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	@Override
	public void atualizar(Produto produto) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == produto.getId()) {
				produtos.set(i, produto);
				return;
			}
		}
		throw new RuntimeException("Produto não encontrado para atualização");
	}

	@Override
	public void excluir(int id) {
		Iterator<Produto> iterator = produtos.iterator();
		while (iterator.hasNext()) {
			Produto produto = iterator.next();
			if (produto.getId() == id) {
				iterator.remove();
				return;
			}
		}
		throw new RuntimeException("Produto não encontrado para exclusão");
	}

	@Override
	public Produto encontrarPorId(int id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		return new ArrayList<>(produtos);
	}
}