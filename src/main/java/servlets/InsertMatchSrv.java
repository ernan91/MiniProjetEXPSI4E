package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import models.MatchsModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Servlet implementation class InsertMatchSrv
 */
@WebServlet("/InsertMatchSrv")
public class InsertMatchSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMatchSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		String param3 = request.getParameter("param3");
		Date date = null;
		try {
		  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  date = format.parse(param3);
		} catch (ParseException e) {
		  // Gérer l'erreur de format de date ici
		}
		String param4 =request.getParameter("param4");

	    try {
	        // Ajout du club à la base de données
	    	MatchsModel.ajouterMatch( param1, param2,  date, param4);
	        

	        // Redirection vers la page d'accueil
	        getServletContext().getRequestDispatcher("/MatchsSrv").forward(request, response);
	        

	        
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
