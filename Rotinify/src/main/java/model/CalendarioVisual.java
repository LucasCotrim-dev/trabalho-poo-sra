//Objeto calendárioVisual para uso em demais classes, apenas contém atributos, construtores, 
//getters e setters
package model;

import java.util.ArrayList;

public class CalendarioVisual {
    private int id;
    private ArrayList<TarefaVisual> tarefasV = new ArrayList<>();

    public CalendarioVisual() {
    }

    public CalendarioVisual(int id, ArrayList<TarefaVisual> tarefasV) {
        this.id = id;
        this.tarefasV = tarefasV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<TarefaVisual> getTarefas() {
        return tarefasV;
    }

    public void setTarefas(ArrayList<TarefaVisual> tarefasV) {
        this.tarefasV = tarefasV;
    }
}

