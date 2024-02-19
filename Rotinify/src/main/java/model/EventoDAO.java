package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventoDAO extends TarefaDAO{
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

    public void adicionarEvento(Evento evento, int idUsuario) {
        String create = "INSERT INTO Evento (nome, descricao, horario, dia_semana, data, usuario_id) VALUES (?,?,?,?,?,?)";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(create);

            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getDescricao());
            pst.setString(3, evento.getHorario());
            pst.setString(4, evento.getDia_semana());
            pst.setString(5, evento.getData());
            pst.setInt(6, idUsuario);

            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar evento: " + e);
        }
    }

    public ArrayList<Evento> listarEventos(int idUsuario) {
        ArrayList<Evento> eventos = new ArrayList<>();
        String read = "SELECT id, nome, descricao, horario, dia_semana, data FROM evento WHERE usuario_id = ? ORDER BY data ASC";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                String horario = rs.getString(4);
                String dia_semana = rs.getString(5);
                String data = rs.getString(6);

                eventos.add(new Evento(id, nome, descricao, horario, dia_semana, data));
            }
            con.close();
            return eventos;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void selecionarEvento(Evento evento) {
        String read2 = "SELECT nome, descricao, horario, dia_semana, data FROM evento WHERE id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setInt(1, evento.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                evento.setNome(rs.getString(1));
                evento.setDescricao(rs.getString(2));
                evento.setHorario(rs.getString(3));
                evento.setDia_semana(rs.getString(4));
                evento.setData(rs.getString(5));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alterarEvento(Evento evento) {
        String update = "UPDATE evento SET nome=?, descricao=?, horario=?, dia_semana=?, data=? WHERE id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, evento.getNome());
            pst.setString(2, evento.getDescricao());
            pst.setString(3, evento.getHorario());
            pst.setString(4, evento.getDia_semana());
            pst.setString(5, evento.getData());
            pst.setInt(6, evento.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletarEvento(Evento evento) {
        String delete = "DELETE FROM evento WHERE id=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setInt(1, evento.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
