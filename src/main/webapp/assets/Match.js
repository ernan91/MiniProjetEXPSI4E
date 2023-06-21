/**
 * 
 */

 function supprimerMatch(id){
	 var answer = confirm("Voulez vous supprimer ce match ?")
	    if (answer){
	 url="RemoveMatchSrv"
	 window.document.location=url+"?id="+id
	 }
 }
 
 function addMatchPage(){
	 url="AddMatchSrv"
	 window.document.location=url
 }
 
 function updateMatchPage(id){
	 url="UpdateMatchSrv"
	 window.document.location=url+"?id="+id
 }
 
 window.addEventListener("DOMContentLoaded", (event) => {
  const el = document.getElementById('add_m');
  if (el) {
    el.addEventListener('click', function(event) {
      event.preventDefault();
      var club_dom = document.getElementById('club_dom').value;
      var club_ext = document.getElementById('club_ext').value;
      var date = document.getElementById('date_match').value;
      var resultat = document.getElementById('resultat-input').value;
      console.log(club_dom)
      console.log(date)
      
      var param1 = club_dom; // Ajout de "var" pour déclarer la variable
      var param2 = club_ext; // Ajout de "var" pour déclarer la variable
      var param3 = date; // Ajout de "var" pour déclarer la variable
      var param4 = resultat; // Ajout de "var" pour déclarer la variable

      
      var url = "InsertMatchSrv";
     
      
      // Ajout de la ligne suivante pour rediriger vers la page avec les paramètres
      window.location.href = url + "?param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 ;
    });
  }
});
