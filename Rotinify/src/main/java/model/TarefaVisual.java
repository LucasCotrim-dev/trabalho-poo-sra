//Objeto tarefaVisual para uso em demais classes, apenas contém atributos, construtores, getters e setters
package model;

public class TarefaVisual {
    private int id;
    private int usuario_id;
    private String caminho_imagem;
    private String horario;
    private String dia_semana;
    
    public TarefaVisual() {
        
    }
    
    public TarefaVisual(String caminho_imagem, String descricao, String horario, String dia_semana) {
        this.caminho_imagem = caminho_imagem;
        this.horario = horario;
        this.dia_semana = dia_semana;
    }
    public TarefaVisual(int id, String caminho_imagem, String horario, String dia_semana) {
        this.id = id;
        this.caminho_imagem = caminho_imagem;
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

    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
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
