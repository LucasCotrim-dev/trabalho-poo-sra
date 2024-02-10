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
        String create = "INSERT INTO `tarefa` (nome, descricao, horario, categoria) VALUES (?, ?, ?, ?)";
        
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);

            pst.setString(1, tarefa.getNome());
            pst.setString(2, tarefa.getDescricao());
            pst.setString(3, tarefa.getHorario());
            pst.setString(4, tarefa.getCategoria());

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public ArrayList<Tarefa> listarTarefas(){
		ArrayList<Tarefa> tarefas = new ArrayList<>();
		String read = "SELECT * FROM tarefa";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				String descricao = rs.getString(2);
				String horario = rs.getString(3);
				String categoria = rs.getString(4);
				
				tarefas.add(new Tarefa(nome,descricao,horario,categoria));
			}
			con.close();
			return tarefas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}
