<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="models.JoueursModel" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<link rel="stylesheet"  href="assets/Club.css">
<script src="assets/Club.js" language="javascript"></script>
<script src="assets/Joueur.js" language="javascript"></script>
<meta charset="ISO-8859-1">
<title>Gestion des joueurs</title>
</head>
<body style="background-image: url('assets/img/backgroundRed.jpg')">
<div> <%@ include file="navbar.jsp" %></div>
<%
			//récupérer les clubs renvoyés par la servlet
					ArrayList<JoueursModel> lc=(ArrayList<JoueursModel>)request.getAttribute("tableauJoueurs");
					// on boucle sur la liste des clubs et on les affiche
					out.println("<center>");
					out.println("<table id='table_club' class=' table-striped table table-dark' border=1>");
					out.println("<th scope='col'> Nom</th>");
					out.println("<th scope='col'> Prenom </th>");
					out.println("<th scope='col'> Age </th>");
					out.println("<th scope='col'> Club </th>");
					out.println("<th scope='col'> Liste des Matchs </th>");
					
					out.println("<th scope='col'> Actions  ");
					out.println("<button type='button' onclick='addJoueurPage()' class='btn btn-success'> <span class='glyphicon glyphicon-plus'></span>Ajouter</button>");
					out.println("</th>");
						for(JoueursModel re:lc)
						{
							
							out.println("<tr>");
							//
							out.println("<td>");
							out.println(re.getNom());
							out.println("</td>");
							//
							out.println("<td>");
							out.println(re.getPrenom());
							out.println("</td>");
							//
							out.println("<td>");
							out.println(re.getAge());
							out.println("</td>");
							//
							out.println("<td>");
							out.println(re.getClub());
							out.println("</td>");
							//
							out.println("<td>");
							out.println("<button type='button' class='btn btn-light'><i class='fa-solid fa-file'></i></button>");
							out.println("</td>");
							
							//
							out.println("<td>");
							out.println("<button type='button' onclick='supprimerJoueur(this.id)' class='btn btn-danger'");
							out.println("id="+(re.getId()));
							out.println("><span class='glyphicon glyphicon-trash'></span> Supprimer</button>");
							//
							out.println("<button type='button' onclick='updateJoueurPage(this.id)' class='btn btn-primary' ");
							out.println("id="+(re.getId()));
							out.println("><span class='glyphicon glyphicon-edit '></span> Modifier</button>");
							out.println("</td>");
							out.println("</tr>");
						}
						out.println("</table>");
						out.println("</center>");
			%>

</body>
</html>