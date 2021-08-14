package com.ala.main.repositories;

import com.ala.main.models.Teste;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TesteRepo extends JpaRepository<Teste, Integer> {

}