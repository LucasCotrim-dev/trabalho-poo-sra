package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CalendarioDAO {
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
	public ArrayList<Tarefa> listarTarefasDiaSemana(String diaSemana){
	    ArrayList<Tarefa> tarefas = new ArrayList<>();
	    String read = "SELECT nome, descricao, horario FROM tarefa WHERE dia_semana = ? ORDER BY horario";
	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        pst.setString(1, diaSemana);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()) {
	            String nome = rs.getString("nome");
	            String descricao = rs.getString("descricao");
	            String horario = rs.getString("horario");
	            tarefas.add(new Tarefa(nome, descricao, horario, diaSemana));
	        }
	        con.close();
	        return tarefas;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

}
