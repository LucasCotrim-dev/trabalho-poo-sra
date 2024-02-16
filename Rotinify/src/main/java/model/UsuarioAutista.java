package model;

public class UsuarioAutista extends Usuario {
    private String cuidador;

    public UsuarioAutista() {

    }
  
    public UsuarioAutista(int id, String nome, String email, String senha, String cuidador) {
        super(id, nome, email, senha);
        this.cuidador = cuidador;
    }

    public String getCuidador() {
        return cuidador;
    }

    public void setCuidador(String cuidador) {
        this.cuidador = cuidador;
    }
}
