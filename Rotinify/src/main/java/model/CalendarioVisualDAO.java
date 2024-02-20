package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CalendarioVisualDAO extends TarefaVisualDAO{
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
	@Override
	public void alterarTarefa(TarefaVisual tarefa) {
        String update = "UPDATE tarefa SET imagem=?, horario=? WHERE id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, tarefa.getCaminho_imagem());
            pst.setString(2, tarefa.getHorario());
            pst.setInt(3, tarefa.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	public ArrayList<TarefaVisual> listarTarefas(String diaSemana, int idUsuario) {
	    ArrayList<TarefaVisual> tarefas = new ArrayList<>();
	    String read = "SELECT id, imagem, horario FROM tarefa WHERE dia_semana = ? AND usuario_id = ? ORDER BY horario";
	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        pst.setString(1, diaSemana);
	        pst.setInt(2, idUsuario); 
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()) {
	            int id = rs.getInt("id");
	            String imagem = rs.getString("imagem");
	            String horario = rs.getString("horario");
	            tarefas.add(new TarefaVisual(id, imagem, horario, diaSemana));
	        }
	        con.close();
	        return tarefas;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	
	public void removerTarefa(TarefaVisual tarefa) {
        String delete = "DELETE FROM tarefa WHERE id=?";
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
