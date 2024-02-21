//Classe que lida com lógica do evento

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Evento;
import model.EventoDAO;

@WebServlet(urlPatterns = {"/EventoController","/manageEvent", "/insertEvent", "/selectEvent", "/updateEvent", "/deleteEvent"})
public class EventoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EventoDAO eventoDao = new EventoDAO();
    Evento evento = new Evento();
       
    public EventoController() {
        super();
    }

    //Método que redireciona a página para realizar a ação selecionada (Listar eventos, CRUD)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if(action.equals("/manageEvent")) {
            eventos(request,response);
        } else if(action.equals("/insertEvent")) {
            adicionarEvento(request,response); 
        } else if (action.equals("/selectEvent")) { 
            listarEvento(request, response);   
        } else if (action.equals("/updateEvent")) { 
            editarEvento(request, response);   
        } else if (action.equals("/deleteEvent")) { 
            removerEvento(request, response);   
        }
    }

    //Método que mostra os eventos no calendário básico
    protected void eventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = (int) request.getSession().getAttribute("idUsuario"); 
        ArrayList<Evento> listaEventos = eventoDao.listarEventos(idUsuario);
        request.setAttribute("eventos", listaEventos);
        RequestDispatcher rd = request.getRequestDispatcher("listaEventos.jsp");
        rd.forward(request, response);
    }

    //Os demais métodos abaixo realizam o CRUD
    protected void adicionarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {      
        int idUsuario = (int) request.getSession().getAttribute("idUsuario");
        System.out.println("ID do usuário obtido da sessão: " + idUsuario);
        evento.setNome(request.getParameter("nome"));
        evento.setDescricao(request.getParameter("descricao"));
        evento.setHorario(request.getParameter("horario"));
        evento.setDia_semana(request.getParameter("dia_semana"));
        evento.setData(request.getParameter("data"));
        
        eventoDao.adicionarEvento(evento, idUsuario);  
        
        response.sendRedirect("manageEvent");
    }

    protected void listarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                
        int id = Integer.parseInt(request.getParameter("id"));
        evento.setId(id);
        eventoDao.selecionarEvento(evento);
        request.setAttribute("nome", evento.getNome());
        request.setAttribute("descricao", evento.getDescricao());
        request.setAttribute("horario", evento.getHorario());
        request.setAttribute("dia_semana", evento.getDia_semana());
        request.setAttribute("data", evento.getData());
        RequestDispatcher rd = request.getRequestDispatcher("editarEvento.jsp");
        rd.forward(request, response);
    }

    protected void editarEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        evento.setNome(request.getParameter("nome"));
        evento.setDescricao(request.getParameter("descricao"));
        evento.setHorario(request.getParameter("horario"));
        evento.setDia_semana(request.getParameter("dia_semana"));
        evento.setData(request.getParameter("data"));
        
        eventoDao.alterarEvento(evento);
        
        response.sendRedirect("manageEvent");
    }

    protected void removerEvento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        evento.setId(id);
        
        eventoDao.deletarEvento(evento);
        
        response.sendRedirect("manageEvent");
    }
}
