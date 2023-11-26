package farmacia.repository;

import java.util.List;

import farmacia.model.Produto;

public interface ProdutoRepository {

	void salvar(Produto produto);

	void atualizar(Produto produto);

	void excluir(int id);

	Produto encontrarPorId(int id);

	List<Produto> listarTodos();
}
