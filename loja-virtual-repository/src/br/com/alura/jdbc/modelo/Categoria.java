package br.com.alura.jdbc.modelo;

public class Categoria {
	
	Integer id;
	String nome;
	
	public Categoria(Integer id, String nome) {
		
		this.id = id;
		this.nome = nome;		
	}
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	

}
