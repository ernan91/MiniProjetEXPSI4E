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
 * Servlet implementation class updateClubSrv
 */
@WebServlet("/UpdateClubSrv")
public class UpdateClubSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateClubSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		// TODO Auto-generated method stub
	    try {
	    	ArrayList<ClubsModel> infos = ClubsModel.getClubInfo(id);
	        //clubModel.ajouterClub(param1, param2,  param3, param4);
	        request.setAttribute("clubInfos", infos);

	        // Redirection vers la page d'accueil
	        getServletContext().getRequestDispatcher("/modifierClub.jsp").forward(request, response);
	        
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
