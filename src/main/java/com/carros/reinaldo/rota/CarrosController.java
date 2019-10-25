package com.carros.reinaldo.rota;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carros.reinaldo.domain.Carro;
import com.carros.reinaldo.service.CarroService;

@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping
	public ResponseEntity<Iterable<Carro>> get() {
		
		return ResponseEntity.ok(service.getCarros());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity getId(@PathVariable("id") Long id) {
		
		Optional<Carro>carro= service.getCarrosById(id);
		
		if(carro.isPresent()) {
			return ResponseEntity.ok(carro.get());
			
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
		
		List<Carro>carros = service.getCarrosByTipo(tipo);
		
		return carros.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(carros) ;
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public String post(@RequestBody Carro carro) {
		Carro c = service.insert(carro);
		
		return "Carro Inserido com sucesso: " + c.getId();
		
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("id")Long id,@RequestBody Carro carro) {
		Carro c = service.update(carro, id);
		
		return "Atualizado com sucesso: " + c.getId();
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id")Long id) {
		
		service.delete(id);
		
		return "Deletado com sucesso!";
		
	}
	
}
