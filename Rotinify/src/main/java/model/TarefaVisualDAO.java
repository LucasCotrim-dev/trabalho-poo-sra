package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TarefaVisualDAO {
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
	
	public void adicionarTarefa(TarefaVisual tarefaVisual, int idUsuario) {
	    String create = "INSERT INTO Tarefa (imagem, horario, dia_semana, usuario_id) values (?,?,?,?)";
	    
	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(create);
	        pst.setString(1, tarefaVisual.getCaminho_imagem());
	        pst.setString(2, tarefaVisual.getHorario());
	        pst.setString(3, tarefaVisual.getDia_semana());
	        pst.setInt(4, idUsuario);
	        
	        pst.executeUpdate();
	        con.close();
	    } catch (Exception e) {
	        System.out.println("Erro ao cadastrar tarefa: " + e);
	    }
	}

	
	public ArrayList<TarefaVisual> listarTarefas(int idUsuario){
	    ArrayList<TarefaVisual> tarefasV = new ArrayList<>();
	    String read = "SELECT id, imagem, horario, dia_semana FROM tarefa WHERE usuario_id = ? ORDER BY horario ASC";
	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        pst.setInt(1, idUsuario);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()) {
	            int id = rs.getInt(1);
	            String imagem = rs.getString(2);
	            String horario = rs.getString(3);
	            String dia_semana = rs.getString(4);
	            
	            tarefasV.add(new TarefaVisual(id,imagem,horario,dia_semana));
	        }
	        con.close();
	        return tarefasV;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	public void selecionarTarefa(TarefaVisual tarefaVisual) {
		String read2 = "select imagem, horario, dia_semana from tarefa where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, tarefaVisual.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				tarefaVisual.setCaminho_imagem(rs.getString(1));
				tarefaVisual.setHorario(rs.getString(2));
				tarefaVisual.setDia_semana(rs.getString(3));

			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarTarefa(TarefaVisual tarefaVisual) {
		String create = "update tarefa set caminho=?, horario=?, dia_semana=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, tarefaVisual.getCaminho_imagem());
			pst.setString(2, tarefaVisual.getHorario());
			pst.setString(3, tarefaVisual.getDia_semana());
			pst.setInt(4, tarefaVisual.getId());
			pst.executeUpdate();
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarTarefa(TarefaVisual tarefa) {
		String delete = "delete from tarefa where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1, tarefa.getId());
			pst.executeUpdate();
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
