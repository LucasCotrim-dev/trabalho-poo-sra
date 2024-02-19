package model;

public class Evento extends Tarefa {
    private String data;

    public Evento() {
    }

    public Evento(String nome, String descricao, String horario, String dia_semana, String data) {
        super(nome, descricao, horario, dia_semana);
        this.data = data;
    }

    public Evento(int id, String nome, String descricao, String horario, String dia_semana, String data) {
        super(id, nome, descricao, horario, dia_semana);
        this.data = data;
    }

    public Evento(int id, int usuario_id, String nome, String descricao, String horario, String dia_semana, String data) {
        super(id, usuario_id, nome, descricao, horario, dia_semana);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
