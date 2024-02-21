//Classe para lidar com a interação entre objetos existentes no calendário básico e o banco de dados
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CalendarioDAO extends TarefaDAO{
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/rotinify";
	private String user = "root";
	private String password = "";
	
	//iniciar o banco de dados
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
	//atualizar informações da tarefa no banco de dados
	@Override
	public void alterarTarefa(Tarefa tarefa) {
        String update = "UPDATE tarefa SET nome=?, descricao=?, horario=? WHERE id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, tarefa.getNome());
            pst.setString(2, tarefa.getDescricao());
            pst.setString(3, tarefa.getHorario());
            pst.setInt(4, tarefa.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	
	//listar tarefas existentes no banco de dados a depender do ID do usuário
	public ArrayList<Tarefa> listarTarefas(String diaSemana, int idUsuario) {
	    ArrayList<Tarefa> tarefas = new ArrayList<>();
	    String read = "SELECT id, nome, descricao, horario FROM tarefa WHERE dia_semana = ? AND usuario_id = ? ORDER BY horario";
	    try {
	        Connection con = conectar();
	        PreparedStatement pst = con.prepareStatement(read);
	        pst.setString(1, diaSemana);
	        pst.setInt(2, idUsuario); 
	        ResultSet rs = pst.executeQuery();
	        while(rs.next()) {
	            int id = rs.getInt("id");
	            String nome = rs.getString("nome");
	            String descricao = rs.getString("descricao");
	            String horario = rs.getString("horario");
	            tarefas.add(new Tarefa(id, nome, descricao, horario, diaSemana));
	        }
	        con.close();
	        return tarefas;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	//remover a tarefa do banco de dados
	public void removerTarefa(Tarefa tarefa) {
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
