package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TarefaVisual;
import model.TarefaVisualDAO;
import model.CalendarioVisualDAO;


@WebServlet(urlPatterns = {"/RotinaVisualController","/manageVisual", "/mainVisual", "/insertVisual", "/selectVisual", "/updateVisual", "/deleteVisual"})
public class RotinaVisualController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TarefaVisualDAO tarefaVisualDao = new TarefaVisualDAO();
	TarefaVisual tarefaV = new TarefaVisual();
	CalendarioVisualDAO calendarioVisualDao = new CalendarioVisualDAO();
       
    public RotinaVisualController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/manageVisual")) {
	        tarefas(request,response);
		}else if(action.equals("/mainVisual")) {
			tarefasCalendario(request,response);
		}else if(action.equals("/insertVisual")) {
			adicionarTarefa(request,response);	
		}else if (action.equals("/selectVisual")) { 
	        listarTarefa(request, response);   
	    }else if (action.equals("/updateVisual")) { 
	        editarTarefa(request, response);   
	    }else if (action.equals("/deleteVisual")) { 
	        removerTarefa(request, response);   
	    }
	}
	
	
	
	protected void tarefasCalendario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int idUsuario = (int) request.getSession().getAttribute("idUsuario"); 
	    ArrayList<TarefaVisual> listaTarefas = tarefaVisualDao.listarTarefas(idUsuario);
	    request.setAttribute("tarefas", listaTarefas);
	    RequestDispatcher rd = request.getRequestDispatcher("calendarioVisual.jsp");
	    rd.forward(request, response);
	}

	protected void tarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int idUsuario = (int) request.getSession().getAttribute("idUsuario"); // Obtém o ID do usuário da sessão
	    String diaSelecionado = request.getParameter("dia_semana");
	    if (diaSelecionado != null) { 
	        ArrayList<TarefaVisual> listaTarefas = calendarioVisualDao.listarTarefas(diaSelecionado, idUsuario); // Usando o método modificado do CalendarioDAO
	        request.setAttribute("tarefas", listaTarefas);
	    }
	    request.setAttribute("diaSelecionado", diaSelecionado != null ? diaSelecionado : ""); // Passa o dia selecionado para o JSP
	    RequestDispatcher rd = request.getRequestDispatcher("rotinaVisual.jsp");
	    rd.forward(request, response);
	}



	
	protected void adicionarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int idUsuario = (int) request.getSession().getAttribute("idUsuario");
		System.out.println("ID do usuário obtido da sessão: " + idUsuario);
	    tarefaV.setCaminho_imagem(request.getParameter("imagem"));
	    tarefaV.setHorario(request.getParameter("horario"));
	    tarefaV.setDia_semana(request.getParameter("dia_semana"));
	    
	    tarefaVisualDao.adicionarTarefa(tarefaV,idUsuario);  
	    
	    response.sendRedirect("manageVisual?dia_semana=" + java.net.URLEncoder.encode(tarefaV.getDia_semana(), "UTF-8"));

	}
	
	protected void listarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                
	    int id = Integer.parseInt(request.getParameter("id"));
	    tarefaV.setId(id);
	    tarefaVisualDao.selecionarTarefa(tarefaV);
	    request.setAttribute("imagem", tarefaV.getCaminho_imagem());
	    request.setAttribute("horario", tarefaV.getHorario());
	    request.setAttribute("dia_semana", tarefaV.getDia_semana());
	    RequestDispatcher rd = request.getRequestDispatcher("editarTarefaVisual.jsp");
	    rd.forward(request, response);
	}
	
	protected void editarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tarefaV.setCaminho_imagem(request.getParameter("imagem"));
	    tarefaV.setHorario(request.getParameter("horario"));
	    tarefaV.setDia_semana(request.getParameter("dia_semana")); 
	    
	    tarefaVisualDao.alterarTarefa(tarefaV);
	    
	    calendarioVisualDao.alterarTarefa(tarefaV);
	    
	    response.sendRedirect("manageVisual?dia_semana=" + java.net.URLEncoder.encode(tarefaV.getDia_semana(), "UTF-8"));

	}
	
	protected void removerTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tarefaV.setId(id);
		
		tarefaVisualDao.deletarTarefa(tarefaV);
		calendarioVisualDao.removerTarefa(tarefaV);
		
		String diaSemana = java.net.URLEncoder.encode(request.getParameter("dia_semana"), "UTF-8");
		response.sendRedirect("manageVisual?dia_semana=" + diaSemana);

	}
}
