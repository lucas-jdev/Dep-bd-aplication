package com.ala.main;

import java.util.ArrayList;
import java.util.List;

import com.ala.main.models.Teste;
import com.ala.main.repositories.TesteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

	@Autowired
	private TesteRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var t1 = new Teste(1, 2);
		var t2 = new Teste(2, 3.7);

		List<Teste> listSave = new ArrayList<>();
		listSave.add(t1);
		listSave.add(t2);
		repo.saveAll(listSave);

		List<Teste> listFind = repo.findAll();

		listFind.forEach(obj -> {
			if (obj.getNum() instanceof Double) {
				System.out.println(obj.getNum() + " é real");
			} else if (obj.getNum() instanceof Integer) {
				System.out.println(obj.getNum() + " é inteiro");
			} else if (obj.getNum() instanceof Float) {
				System.out.println(obj.getNum() + " é flutuante");
			}
		});

	}

}
