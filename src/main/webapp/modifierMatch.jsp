<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="models.ClubsModel" %>
     <%@ page import="models.MatchsModel" %>
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
<script src="assets/Match.js" language="javascript"></script>
<script src="assets/Club.js" language="javascript"></script>
<meta charset="ISO-8859-1">
<title>Ajouter joueur</title>
</head>
<div> <%@ include file="navbar.jsp" %></div>
<body style="background-image: url('assets/img/backgroundRed.jpg')">

<form id="modifierMatchForm">
<%
		//r�cup�rer les clubs renvoy�s par la servlet
		ArrayList<MatchsModel> match=(ArrayList<MatchsModel>)request.getAttribute("MatchInfos");
		for(MatchsModel m:match)
		{
%>
 <div class="mb-3" >
    <input hidden type="text" class="form-control" id="id" name="nom" value="<% out.println(m.getId());%>" required>
  </div>
  <div class="mb-3">
    <label for="club" class="form-label">Club domicile</label>
    <select class="form-select" id="club_domicile" name="club_domicile"   required>

    
<%
			//r�cup�rer les clubs renvoy�s par la servlet
			ArrayList<ClubsModel> lc=(ArrayList<ClubsModel>)request.getAttribute("tableauClub");
    		for(ClubsModel re:lc)
			{
    			if(re.getNom().equals(m.getClubDomNom())) {
    			    out.print("<option value='");
    			    out.print(re.getId());
    			    out.print("' selected>");
    			    out.print(re.getNom());
    			    out.println("</option>");
    			}
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
    <label for="club" class="form-label">Club ext�rieur</label>
    <select <%out.println(m.getClubExtNom());%> class="form-select" id="club_ext�rieur" name="club_ext�rieur"   required>

      
<%
			//r�cup�rer les clubs renvoy�s par la servlet
			ArrayList<ClubsModel> lc2=(ArrayList<ClubsModel>)request.getAttribute("tableauClub");
    		for(ClubsModel re2:lc2)
			{
    			if(re2.getNom().equals(m.getClubExtNom())) {
    			    out.print("<option value='");
    			    out.print(re2.getId());
    			    out.print("' selected>");
    			    out.print(re2.getNom());
    			    out.println("</option>");
    			}
    			out.println("<option value='");
    			out.println(re2.getId());
    			out.println("'>");
    			out.println(re2.getNom());
    			out.println("</option>");
			}
    		%>
    </select>
  </div>
  
    <label for="date" class="col-1 col-form-label">Date</label>
    <div class="col-5">
      <div class="input-group date" id="datepicker">
        <input value="<%out.println(m.getDateMatch());%>" type="date" class="form-control" id="date_match"/>
 
      </div>
    </div>
    

    
     <div class="mb-3">
    <label for="R�sultat" class="form-label">R�sultat</label>
	<input value="<% out.println(m.getResultat()); %>" id="resultat-input" type="text" class="form-control" placeholder="R�sultat">
	</div>

      <% } %>
  <div class="mb-3">
    <button id="saveMod_j" class="btn btn-primary" >Enregistrer</button>
  </div>
  
</form>
</body>

<script>
function isValidResultat(resultat) {
	  const regex = /^\d+-\d+$/; // Expression r�guli�re pour le format "score1-score2"
	  return regex.test(resultat);
	}


// S�lectionner l'input
const resultatInput = document.getElementById("resultat-input");

// Ajouter un �couteur d'�v�nements pour l'�v�nement "input"
resultatInput.addEventListener("input", () => {
  const resultat = resultatInput.value.trim();
  const isValid = isValidResultat(resultat);
  resultatInput.classList.toggle("is-valid", isValid);
  resultatInput.classList.toggle("is-invalid", !isValid);
});

</script>
</html>
