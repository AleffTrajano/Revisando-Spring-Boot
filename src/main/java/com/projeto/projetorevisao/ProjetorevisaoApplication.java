package com.projeto.projetorevisao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.projetorevisao.domain.Categoria;
import com.projeto.projetorevisao.domain.Produto;
import com.projeto.projetorevisao.repositories.CategoriaRepository;
import com.projeto.projetorevisao.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetorevisaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetorevisaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		Produto p1 = new Produto(null, 200.00,"computador");
		Produto p2 = new Produto(null, 100.00,"impressora");
		Produto p3 = new Produto(null, 80.00,"mouse");
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2, cat2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
