package com.teste.p.perfumecontroller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.p.Dto.PerfumeDto;

import ch.qos.logback.core.model.Model;


@RestController
@RequestMapping("perfumaria")
public class PerfumeController {

    @Autowired
    private Repository repo;  // Corrigindo o nome do repositório
    



    // GET: Listar todos os perfumes
    @GetMapping("/perfumes")
    public ResponseEntity<List<Model>> listarTodos() {
        List<Model> perfumes = repo.findAll();  // Usando o repositório correto
        if (perfumes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(perfumes);
    }

    @PostMapping("/perfume")
    public ResponseEntity<?> cadastrarPerfume(@RequestBody PerfumeDto dto) {
    	Optional<Model> perfumeExistente= new Model (PerfumeDto);
    	repo.save(perfumeExistente);
    	return ResponseEntity.status(HttpStatus.CREATED).body("Perfume adicionado ao estoque!");
    }
    
    @PutMapping("/perfume/{id}")
    public ResponseEntity<?> updatePerfume(@PathVariable UUID ID, @RequestBody PerfumeDto dto){
    	Optional<Model> perfumeExistente = repo.findById(ID);
    	
    	if (perfumeExistente.isPresent()){
    		Model perfumeAtualizado = perfumeExistente.get();
    		perfumeAtualizado.setNome(dto.Nome());
    		perfumeAtualizado.setEstoque(dto.Estoque());
    		perfumeAtualizado.setMarca(dto.Marca());
    		perfumeAtualizado.setPreco(dto.Preco());
    		repo.save(perfumeAtualizado);
    		return ResponseEntity.ok(perfumeAtualizado);
    	}
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfume não encontrado!");
    }
    
    @DeleteMapping("/perfume/{id}")
    public ResponseEntity<?> deletarPerfume (@PathVariable UUID ID){
    	Optional<Model> perfumeExistente = repo.findById(ID);
    	
    	if(perfumeExistente.isPresent()) {
    		repo.deleteById(ID);
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    		
    	}
    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfume não encontrado!");
    }
    	
    
}