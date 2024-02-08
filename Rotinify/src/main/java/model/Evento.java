package model;

public class Evento extends Tarefa {
	private int id;
	 private String data;
	 private CalendarioSemanal calendarioSemanal;
	 
	 public Evento() {
		 
	 }
	 
	 public Evento(int id, String data, CalendarioSemanal calendarioSemanal) {
		super();
		this.id = id;
		this.data = data;
		this.calendarioSemanal = calendarioSemanal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CalendarioSemanal getCalendarioSemanal() {
		return calendarioSemanal;
	}

	public void setCalendarioSemanal(CalendarioSemanal calendarioSemanal) {
		this.calendarioSemanal = calendarioSemanal;
	}
	 
	 
}
