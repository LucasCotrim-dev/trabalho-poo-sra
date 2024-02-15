package model;

public class Tarefa {
    private int id;
    private int usuario_id;
    private String nome;
    private String descricao;
    private String horario;
    private String dia_semana;
    
    public Tarefa() {
        
    }
    
    public Tarefa(String nome, String descricao, String horario, String dia_semana) {
        this.nome = nome;
        this.descricao = descricao;
        this.horario = horario;
        this.dia_semana = dia_semana;
    }
    public Tarefa(int id, String nome, String descricao, String horario, String dia_semana) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.horario = horario;
        this.dia_semana = dia_semana;
    }
    
    public Tarefa(int id, int usuario_id, String nome, String descricao, String horario, String dia_semana) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.nome = nome;
        this.descricao = descricao;
        this.horario = horario;
        this.dia_semana = dia_semana;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
}
