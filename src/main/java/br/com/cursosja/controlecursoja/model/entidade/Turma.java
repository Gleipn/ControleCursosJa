package br.com.cursosja.controlecursoja.model.entidade;

import java.util.Date;

public class Turma {
	private long id;
	private Date dataInicio;
	private Date dataFim;
	private double valor;
	
	private Curso curso;
	private Professor professor;
	public Turma(long id, Date dataInicio, Date dataFim, double valor, Curso curso, Professor professor) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valor = valor;
		this.curso = curso;
		this.professor = professor;
	}
	public Turma() {
		super();
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.dataInicio = new Date();
		this.dataFim = new Date();
		this.valor = 0.0;
		this.curso = new Curso();
		this.professor = new Professor();
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
	
}