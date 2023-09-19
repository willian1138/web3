package com.fatec.produto.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.produto.model.Catalogo;
import com.fatec.produto.model.IProdutoRepository;
import com.fatec.produto.model.Imagem;
import com.fatec.produto.model.Produto;

@Service
public class ProdutoServico implements IProdutoServico {

	@Autowired
	IProdutoRepository repositoryP;
	@Autowired
	ImagemServico imagemServico;
	public List<Catalogo> consultaCatalogo() {

		Catalogo c = null;
		List < Catalogo > lista = new ArrayList < Catalogo > ();
		List < Produto > listaP = repositoryP.findAll();
		List < Imagem > listaI = imagemServico.getAll();
		for (Produto p : listaP) {
			for (Imagem i : listaI) {
				if (p.getId().equals(i.getId())) {
					c = new Catalogo(p.getId(), p.getDescricao(), p.getCategoria(),
						p.getCusto(), p.getQuantidadeNoEstoque(), i.getArquivo());
					lista.add(c);
				}
			}
		}
		return lista;
	}
	@Override
	public List<Produto> consultaPorDescricao() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultaPorDescricao'");
	}
	@Override
	public Optional<Produto> cadastrar(Produto produto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
	}
	@Override
	public Optional<Produto> consultarPorId(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'consultarPorId'");
	}
	@Override
	public Optional<Produto> atualizar(Long id, Produto produto) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
	}
	@Override
	public void excluir(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'excluir'");
	}
}