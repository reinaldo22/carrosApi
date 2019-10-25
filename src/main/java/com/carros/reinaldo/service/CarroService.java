package com.carros.reinaldo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.carros.reinaldo.domain.Carro;
import com.carros.reinaldo.repository.CarroRepository;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;

	// Busca todos os carros
	public List<Carro> getCarros() {

		return carroRepository.findAll();
	}

	// Busca os carros pelo id
	public Optional<Carro> getCarrosById(Long id) {

		return carroRepository.findById(id);
	}
	// Busca os carros pelo tipo
	public List<Carro> getCarrosByTipo(String tipo) {
		
		return carroRepository.findByTipo(tipo);
	}

	public Carro insert(Carro carro) {
		
		return carroRepository.save(carro);
	}

	public Carro update(Carro carro, Long id) {
		Assert.notNull(id, "Não foi possível atualizar o registro");
		
		//Busca o carro no banco de dados
		 Optional<Carro> oprional = getCarrosById(id);
		 //Se caso exista esse carro
		 if(oprional.isPresent()) {
			 Carro db = oprional.get();
			 
			 //copiar as propriedades
			 db.setNome(carro.getNome());
			 db.setTipo(carro.getTipo());
			 System.out.println("Carro id " + db.getId());
			 
			 //atualiza o carro
			 carroRepository.save(db);
			 return db;
		 }else {
			 throw new RuntimeException("Não foi possível atualizar o registro");
		 }
		 
		
	}

	public void delete(Long id) {
		Optional<Carro> carro = getCarrosById(id);
		if(carro.isPresent()) {
			carroRepository.deleteById(id);
		}
	}
	

}
