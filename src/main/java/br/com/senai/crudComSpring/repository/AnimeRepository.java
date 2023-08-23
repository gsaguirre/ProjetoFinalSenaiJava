package br.com.senai.crudComSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.crudComSpring.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>{
}

