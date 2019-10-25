package com.carros.reinaldo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carros.reinaldo.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

	List<Carro> findByTipo(String tipo);

}
