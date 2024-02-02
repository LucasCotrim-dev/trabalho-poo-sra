package model;

import java.util.ArrayList;

public class CalendarioSemanal {
	private int id;
    private ArrayList<Evento> eventos = new ArrayList<>();
    
    public CalendarioSemanal() {
    }
    
    public CalendarioSemanal(int id, ArrayList<Evento> eventos) {
		super();
		this.id = id;
		this.eventos = eventos;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
}
