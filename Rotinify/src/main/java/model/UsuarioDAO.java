package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/rotinify";
	private String user = "root";
	private String password = "";
	
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void cadastroUsuario(Usuario usuario) {
		String create = "INSERT INTO Usuario (nome, email, senha, cuidador) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuario.getCuidador());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean verificarCadastro(Usuario usuario) {
	    String query = "SELECT COUNT(*) FROM Usuario WHERE nome = ? OR email = ? OR cuidador = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getEmail());
	        pst.setString(3, usuario.getCuidador());

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0; 
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return false; 
	}
	
	public boolean verificarLogin(Usuario usuario) {
	    String query = "SELECT COUNT(*) FROM Usuario WHERE nome = ? AND senha = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getSenha());

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0; 
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return false; 
	}
	
	public int obterIdUsuario(Usuario usuario) {
	    String query = "SELECT id FROM Usuario WHERE nome = ? AND senha = ?";
	    int idUsuario = -1; // valor padrão para indicar que nenhum usuário foi encontrado
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getSenha());

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                idUsuario = rs.getInt("id");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao obter ID do usuário: " + e);
	    }
	    
	    return idUsuario;
	}
	
	public Usuario obterUsuarioPorId(int idUsuario) {
	    String query = "SELECT * FROM Usuario WHERE id = ?";
	    Usuario usuario = null;
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setInt(1, idUsuario);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                usuario = new Usuario();
	                usuario.setId(rs.getInt("id"));
	                usuario.setNome(rs.getString("nome"));
	                usuario.setEmail(rs.getString("email"));
	                usuario.setSenha(rs.getString("senha"));
	                usuario.setCuidador(rs.getString("cuidador"));
	                usuario.setFotoPerfil(rs.getString("foto_url"));
	                // Se houver mais campos a serem mapeados, você pode adicionar aqui
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao obter usuário por ID: " + e);
	    }
	    
	    return usuario;
	}
	
	public boolean verificarDuplicidade(Usuario usuario) {
	    String query = "SELECT COUNT(*) FROM Usuario WHERE (nome = ? OR email = ?) AND id != ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getEmail());
	        pst.setInt(3, usuario.getId()); // Exclui o ID do usuário atual da verificação

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                int count = rs.getInt(1);
	                return count > 0; 
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    return false; 
	}
	
	public void atualizarPerfil(int idUsuario, Usuario usuario) {
	    String query = "UPDATE Usuario SET nome = ?, email = ?, cuidador = ?, foto_url = ? WHERE id = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getEmail());
	        pst.setString(3, usuario.getCuidador());
	        pst.setString(4, usuario.getFotoPerfil()); 
	        pst.setInt(5, idUsuario);

	        pst.executeUpdate();
	    } catch (Exception e) {
	        System.out.println("Erro ao atualizar perfil do usuário: " + e);
	    }
	}

	
	public void atualizarSenha(int idUsuario, String senhaNova) {
	    String query = "UPDATE Usuario SET senha = ? WHERE id = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, senhaNova);
	        pst.setInt(2, idUsuario);

	        pst.executeUpdate();
	    } catch (Exception e) {
	        System.out.println("Erro ao atualizar senha do usuário: " + e);
	    }
	}

	public boolean verificarSenha(int idUsuario, String senhaAntiga) {
	    String query = "SELECT senha FROM Usuario WHERE id = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setInt(1, idUsuario);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                String senhaAtual = rs.getString("senha");
	                return senhaAntiga.equals(senhaAtual);
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao verificar senha do usuário: " + e);
	    }
	    
	    return false; // Em caso de erro ou usuário não encontrado, retorna falso
	}


	
}
