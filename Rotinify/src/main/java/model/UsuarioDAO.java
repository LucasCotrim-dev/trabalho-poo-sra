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
		String create = "INSERT INTO Usuario (nome, email, senha) values (?,?,?)";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public boolean verificarCadastro(Usuario usuario) {
	    String query = "SELECT COUNT(*) FROM Usuario WHERE nome = ? OR email = ?";
	    
	    try (Connection con = conectar();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuario.getNome());
	        pst.setString(2, usuario.getEmail());

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

}
