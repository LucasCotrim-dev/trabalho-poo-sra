//Objeto usuário para uso em demais classes, apenas contém atributos, construtores, getters e setters
package model;

public class Usuario {
	private int id;
    private String nome;
    private String email;
    private String senha;
    private String cuidador;
    private String fotoPerfil;
    
    public Usuario() {
    	
    }
    
    public Usuario(int id, String nome, String email, String senha, String cuidador) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cuidador = cuidador;
    }
    
    public Usuario(int id, String nome, String email, String senha, String cuidador, String fotoPerfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cuidador = cuidador;
        this.fotoPerfil = fotoPerfil;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCuidador() {
        return cuidador;
    }

    public void setCuidador(String cuidador) {
        this.cuidador = cuidador;
    }
	
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
}
