<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.ClubsModel" %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html>
<!-- Modal d'ajout de club -->
<!-- Modal d'ajout de joueur -->
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<link rel="stylesheet"  href="assets/Club.css">
<script src="assets/Joueur.js" language="javascript"></script>
<script src="assets/Club.js" language="javascript"></script>
<meta charset="ISO-8859-1">
<title>Ajouter joueur</title>
</head>
<div> <%@ include file="navbar.jsp" %></div>
<body style="background-image: url('assets/img/backgroundRed.jpg')">
<form id="ajouterJoueurForm">
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" required>
  </div>
  <div class="mb-3">
    <label for="prenom" class="form-label">Prénom</label>
    <input type="text" class="form-control" id="prenom" name="prenom" required>
  </div>
  <div class="mb-3">
    <label for="age" class="form-label">Âge</label>
    <input type="number" class="form-control" id="age" name="age" required>
  </div>
    <div class="mb-3">
		      <label for="club" class="form-label">Poste</label>
		<select class="form-select" id="poste" name="poste" required>
		  <option value="" >Sélectionner un poste</option>
		  <option value="gardien de but">gardien de but</option>
		  <option value="défenseur central">défenseur central</option>
		  <option value="défenseur latéral">défenseur latéral</option>
		  <option value="milieu défensif">milieu défensif</option>
		  <option value="milieu central">milieu central</option>
		  <option value="milieu offensif">milieu offensif</option>
		  <option value="ailier">ailier</option>
		  <option value="attaquant">attaquant</option>
		</select>
		</div>
  <div class="mb-3">
    <label for="club" class="form-label">Club</label>
    <select class="form-select" id="club" name="club" required>
      <option value="" selected disabled hidden>Sélectionner un club</option>
<%
			//récupérer les clubs renvoyés par la servlet
					ArrayList<ClubsModel> lc=(ArrayList<ClubsModel>)request.getAttribute("tableauClub");
    		for(ClubsModel re:lc)
			{
    			out.println("<option value='");
    			out.println(re.getId());
    			out.println("'>");
    			out.println(re.getNom());
    			out.println("</option>");
			}
    		%>
    </select>
  </div>
  <div class="mb-3">
    <button id="add_j" class="btn btn-primary" >Ajouter</button>
  </div>
</form>
</body>
</html>
