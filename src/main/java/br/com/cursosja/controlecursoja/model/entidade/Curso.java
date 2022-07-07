package br.com.cursosja.controlecursoja.model.entidade;

public class Curso {
	private long id;
	private String nome;
	private double valor;
	
	public Curso(){
		this.id = 0;
		this.nome = "";
		this.valor = 0.0;
	}
	
	public Curso(long codigo, String n, double v) {
		this.id = codigo;
		this.nome = n;
		this.valor = v;
	}
	
	public void setId(long i) {
		this.id = i;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
}