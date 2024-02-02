package model;

import java.util.ArrayList;

public class Rotina {
	private int id;
	private ArrayList<Tarefa> tarefas;
	
	public Rotina() {
		
	}
	 
	 public Rotina(int id, ArrayList<Tarefa> tarefas) {
		super();
		this.id = id;
		this.tarefas = tarefas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(ArrayList<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}
