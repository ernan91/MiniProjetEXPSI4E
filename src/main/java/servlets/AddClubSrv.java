package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ClubsModel;

/**
 * Servlet implementation class addClub
 */
@WebServlet("/AddClubSrv")
public class AddClubSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClubSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			//int id = Integer.parseInt(request.getParameter("id"));
			String param1 = request.getParameter("param1");
			String param2 = request.getParameter("param2");
			int param3 = Integer.parseInt(request.getParameter("param3"));
			int param4 =Integer.parseInt(request.getParameter("param4"));

		    try {
		        // Ajout du club à la base de données
		        ClubsModel.ajouterClub( param1, param2,  param3, param4);
		        

		        // Redirection vers la page d'accueil
		        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		        

		        
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
