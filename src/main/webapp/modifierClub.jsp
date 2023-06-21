<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="models.ClubsModel" %>
<%@ page import="java.util.Arrays" %>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet"  href="assets/Club.css">
<script src="assets/Club.js" language="javascript"></script>
<meta charset="ISO-8859-1">
<title>Gestion des clubs</title>
</head>
<body>
<div> <%@ include file="navbar.jsp" %></div>
<%
//récupérer les restos renvoyés par la servlet
ArrayList<ClubsModel> lr=(ArrayList<ClubsModel>)request.getAttribute("clubInfos"); 

for (ClubsModel club : lr) {
     // remplacez "getNom()" par le nom de l'attribut que vous souhaitez afficher
%>
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nomClub" placeholder="Entrez le nom" value="<% out.println(club.getNom()); %>">
  </div>
  <div class="mb-3">
    <label for="ville" class="form-label">Ville</label>
    <input type="text" class="form-control" id="villeClub" placeholder="Entrez la ville" value="<% out.println(club.getVille()); %>">
  </div>
  <div class="mb-3">
    <label for="titres" class="form-label">Titres</label>
    <input type="text" class="form-control" id="titres" placeholder="Entrez le nombre de titres" value="<% out.println(club.getTitres()); %>">
  </div>
  <div class="mb-3">
    <label for="position" class="form-label">Position dans le classement</label>
    <input type="text" class="form-control" id="classementClub" placeholder="Entrez la position" value="<% out.println(club.getPositionClassement()); %>">
  </div>
  <button  id="<% out.println(club.getId()); %>" onclick="SaveUpdateClub(this.id)" class="btn btn-primary">Enregistrer</button>
<% } %>
</body>
