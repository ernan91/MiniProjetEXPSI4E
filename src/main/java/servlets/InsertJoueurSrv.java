package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.JoueursModel;
/**
 * Servlet implementation class InsertJoueurSrv
 */
@WebServlet("/InsertJoueurSrv")
public class InsertJoueurSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertJoueurSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		int param3 = Integer.parseInt(request.getParameter("param3"));
		
		int param4 =Integer.parseInt(request.getParameter("param4"));
		String param5 = request.getParameter("param5");

	    try {
	        // Ajout du club � la base de donn�es
	    	JoueursModel.ajouterJoueur( param1, param2,  param3, param4,param5);
	        

	        // Redirection vers la page d'accueil
	        getServletContext().getRequestDispatcher("/JoueursSrv").forward(request, response);
	        

	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
