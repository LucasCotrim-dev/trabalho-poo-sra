package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefa;
import model.TarefaDAO;

@WebServlet(urlPatterns = {"/RotinaController", "/main"})
public class RotinaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaDAO tarefaDao = new TarefaDAO();
       
    public RotinaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			
		}
	}
	
	protected void tarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ArrayList<Tarefa> listaTarefas = tarefaDao.listarTarefas();
	    request.setAttribute("tarefas", listaTarefas);
	    RequestDispatcher rd = request.getRequestDispatcher("rotina.jsp");
	    rd.forward(request, response);
	}

}
