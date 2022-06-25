package br.com.cursosja.controlecursoja.model.entidade;

public class Professor {
	private long id;
	private String nome;
	private String celular;
	private double valorHora;
	
	public Professor() {
		this.id = 0;
		this.nome = "";
		this.celular = "";
		this.valorHora = 0.00;
	}
	
	
	
	public Professor(long id, String nome, String celular, double valorHora) {
		super();
		this.id = id;
		this.nome = nome;
		this.celular = celular;
		this.valorHora = valorHora;
	}



	public void setId(long i) {
		this.id = i;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setNome(String n) {
		this.nome = n;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCelular(String c) {
		this.celular = c;
	}
	
	public String getCelular() {
		return this.celular;
	}
	
	public double getValorHora() {
		return this.valorHora;
	}
	
	public void setValorHora(double valor) {
		this.valorHora = valor;
	}
}