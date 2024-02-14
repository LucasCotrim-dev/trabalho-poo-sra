package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TarefaDAO {
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
	
	public void adicionarTarefa(Tarefa tarefa) {
        String create = "INSERT INTO `tarefa` (nome, descricao, horario, dia_semana) VALUES (?, ?, ?, ?)";
        
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);

            pst.setString(1, tarefa.getNome());
            pst.setString(2, tarefa.getDescricao());
            pst.setString(3, tarefa.getHorario());
            pst.setString(4, tarefa.getDia_semana());

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public ArrayList<Tarefa> listarTarefas(){
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		String read = "SELECT id, nome, descricao, horario, dia_semana FROM tarefa ORDER BY horario ASC";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String descricao = rs.getString(3);
				String horario = rs.getString(4);
				String dia_semana = rs.getString(5);
				
				tarefas.add(new Tarefa(id,nome,descricao,horario,dia_semana));
			}
			con.close();
			return tarefas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	public void selecionarTarefa(Tarefa tarefa) {
		String read2 = "select nome, descricao, horario, dia_semana from tarefa where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setInt(1, tarefa.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				tarefa.setNome(rs.getString(1));
				tarefa.setDescricao(rs.getString(2));
				tarefa.setHorario(rs.getString(3));
				tarefa.setDia_semana(rs.getString(4));

			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void alterarTarefa(Tarefa tarefa) {
		String create = "update tarefa set nome=?, descricao=?, horario=?, dia_semana=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, tarefa.getNome());
			pst.setString(2, tarefa.getDescricao());
			pst.setString(3, tarefa.getHorario());
			pst.setString(4, tarefa.getDia_semana());
			pst.setInt(5, tarefa.getId());
			pst.executeUpdate();
            con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarTarefa(Tarefa tarefa) {
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
