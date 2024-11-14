package com.teste.p.perfumemodel;

import java.util.UUID;

import com.teste.p.Dto.PerfumeDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="ana")
public class Model {

	@Id
	@GeneratedValue(strategy= GenerationType.UUID)
	private UUID ID;
	private String Nome;
	public String Marca;
	public double Preco;
	private int Estoque;
	
	public Model(PerfumeDto dto) {
		this.Estoque=dto.Estoque();
		this.Marca=dto.Marca();
		this.Nome=dto.Nome();
		this.Preco=dto.Preco();
	
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public double getPreco() {
		return Preco;
	}

	public void setPreco(double preco) {
		Preco = preco;
	}

	public int getEstoque() {
		return Estoque;
	}

	public void setEstoque(int estoque) {
		Estoque = estoque;
	}
	

	}
