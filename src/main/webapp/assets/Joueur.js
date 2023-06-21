/**
 * 
 */
 function supprimerJoueur(id){
		var answer = confirm("Voulez vous supprimer ce joueur ?")
	    if (answer){
	   	var url="RemoveJoueurSrv"
		window.document.location=url+"?id="+id
 	}
 }
		 
function addJoueurPage(){
	var url="AddJoueurSrv"
	window.document.location=url
}
function updateJoueurPage(id){
	var url="UpdateJoueurSrv"
	window.document.location=url+"?id="+id
}
window.addEventListener("DOMContentLoaded", (event) => {
  const el = document.getElementById('add_j');
  if (el) {
    el.addEventListener('click', function(event) {
      event.preventDefault();
      var nom = document.getElementById('nom').value;
      var prenom = document.getElementById('prenom').value;
      var club = document.getElementById('club').value;
      var age = document.getElementById('age').value;
      var poste = document.getElementById('poste').value;
      
      
      var param1 = nom; // Ajout de "var" pour déclarer la variable
      var param2 = prenom; // Ajout de "var" pour déclarer la variable
      var param3 = club; // Ajout de "var" pour déclarer la variable
      var param4 = age; // Ajout de "var" pour déclarer la variable
      var param5 = poste; // Ajout de "var" pour déclarer la variable
      
      var url = "InsertJoueurSrv";
     
      
      // Ajout de la ligne suivante pour rediriger vers la page avec les paramètres
      window.location.href = url + "?param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5;
    });
  }
});

window.addEventListener("DOMContentLoaded", (event) => {
  const el = document.getElementById('saveMod_j');
  if (el) {
    el.addEventListener('click', function(event) {
      event.preventDefault();
      var ids = document.getElementById('id').value
      var nom = document.getElementById('nom').value;
      var prenom = document.getElementById('prenom').value;
      var club = document.getElementById('club').value;
      var age = document.getElementById('age').value;
      var poste = document.getElementById('poste').value;
  
  
      var id = ids
      var param1 = nom; // Ajout de "var" pour déclarer la variable
      var param2 = prenom; // Ajout de "var" pour déclarer la variable
      var param3 = club; // Ajout de "var" pour déclarer la variable
      var param4 = age; // Ajout de "var" pour déclarer la variable
      var param5 = poste; // Ajout de "var" pour déclarer la variable
      
      var url = "SaveUpdateJoueurSrv";
     
      
      // Ajout de la ligne suivante pour rediriger vers la page avec les paramètres
      window.location.href = url +"?id=" +id+ "&param1=" + param1 + "&param2=" + param2 + "&param3=" + param3 + "&param4=" + param4 + "&param5=" + param5;
    });
  }
});




