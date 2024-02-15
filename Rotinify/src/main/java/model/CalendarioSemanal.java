package model;

import java.util.ArrayList;

public class CalendarioSemanal {
    private int id;
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    private ArrayList<Evento> eventos = new ArrayList<>();

    public CalendarioSemanal() {
    }

    public CalendarioSemanal(int id, ArrayList<Tarefa> tarefas, ArrayList<Evento> eventos) {
        this.id = id;
        this.tarefas = tarefas;
        this.eventos = eventos;
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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }
}

