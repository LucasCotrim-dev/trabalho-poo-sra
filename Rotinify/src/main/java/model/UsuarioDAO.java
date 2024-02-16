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
	
	public void cadastroUsuario(Usuario usuario, UsuarioAutista usuarioAutista) {
		String create = "INSERT INTO Usuario (nome, email, senha, cuidador) values (?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getEmail());
			pst.setString(3, usuario.getSenha());
			pst.setString(4, usuarioAutista.getCuidador());
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
	                usuario.setFotoPerfil(rs.getString("foto_url"));
	                // Se houver mais campos a serem mapeados, você pode adicionar aqui
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Erro ao obter usuário por ID: " + e);
	    }
	    
	    return usuario;
	}
	public void atualizarPerfil(int idUsuario, Usuario usuario, UsuarioAutista usuarioAutista, String fotoUrl) {
	    String updateUsuario = "UPDATE Usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
	    String updateUsuarioAutista = "UPDATE UsuarioAutista SET cuidador = ? WHERE id_usuario = ?";
	    String updateFoto = "UPDATE Usuario SET foto_url = ? WHERE id = ?";
	    
	    try (Connection con = conectar()) {
	        // Atualiza informações básicas do usuário
	        PreparedStatement pstUsuario = con.prepareStatement(updateUsuario);
	        pstUsuario.setString(1, usuario.getNome());
	        pstUsuario.setString(2, usuario.getEmail());
	        pstUsuario.setString(3, usuario.getSenha());
	        pstUsuario.setInt(4, idUsuario);
	        pstUsuario.executeUpdate();
	        
	        // Se o usuário for do tipo autista, atualiza informações adicionais
	        if (usuarioAutista != null) {
	            PreparedStatement pstUsuarioAutista = con.prepareStatement(updateUsuarioAutista);
	            pstUsuarioAutista.setString(1, usuarioAutista.getCuidador());
	            pstUsuarioAutista.setInt(2, idUsuario);
	            pstUsuarioAutista.executeUpdate();
	        }
	        
	        // Atualiza a URL da foto de perfil
	        PreparedStatement pstFoto = con.prepareStatement(updateFoto);
	        pstFoto.setString(1, fotoUrl);
	        pstFoto.setInt(2, idUsuario);
	        pstFoto.executeUpdate();
	        
	    } catch (Exception e) {
	        System.out.println("Erro ao atualizar perfil do usuário: " + e);
	    }
	}


	
}
