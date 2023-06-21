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
import models.MatchsModel;

/**
 * Servlet implementation class UpdateMatchSrv
 */
@WebServlet("/UpdateMatchSrv")
public class UpdateMatchSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMatchSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    try {
	    	ArrayList<MatchsModel> infos = MatchsModel.Match(id);
	        //clubModel.ajouterClub(param1, param2,  param3, param4);
	        request.setAttribute("MatchInfos", infos);
	        
	        ArrayList<ClubsModel> lstNomClub = ClubsModel.listeNomClub();
			//je met le tableau des restaurants dans un attribut de session (un param) pour
			//que la page appelée puisse les afficher
			
			request.setAttribute("tableauClub", lstNomClub);

	        // Redirection vers la page d'accueil
	        getServletContext().getRequestDispatcher("/modifierMatch.jsp").forward(request, response);
	        
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
