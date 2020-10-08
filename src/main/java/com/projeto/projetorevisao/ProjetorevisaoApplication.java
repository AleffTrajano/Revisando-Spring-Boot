package com.projeto.projetorevisao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.projetorevisao.domain.Categoria;
import com.projeto.projetorevisao.repositories.CategoriaRepository;

@SpringBootApplication
public class ProjetorevisaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetorevisaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"escritorio");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		
	}

}
