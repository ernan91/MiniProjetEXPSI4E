/**
 * 
 */

 
 /**
 * des fonctions JS pour utiliser les restaurants
 */
	function Matchs(){
		url="MatchsSrv"
		window.document.location=url 
	}
	
	
	function Joueurs(){
			url="JoueursSrv"
		window.document.location=url 
	}
	
	function supprimerClub(id)
	{
		var answer = confirm("Voulez vous supprimer ce club ?")
	    if (answer){
	   	var url="RemoveClubSrv"
		window.document.location=url+"?id="+id
	}
	

	}
	function chercher()
	{
		var url="ClubsSrv"	
		window.document.location=url	
	}
	
	
	function modifierClub(id) {	
    var url = "UpdateClubSrv?id=" + id 
    window.location.href = url;
	}
	
	
	
	function SaveUpdateClub(id){
			var nom=document.getElementById('nomClub').value;
			var ville=document.getElementById('villeClub').value;
			var classement=document.getElementById('classementClub').value;
			var titres=document.getElementById('titres').value;
			
			param1=nom;
			param2=ville;
			param3=classement;
			param4=titres;
				
			var url="SaveUpdateClubSrv"
			
			window.document.location=url+"?id="+id+"&param1="+param1+"&param2="+param2+"&param3="+param3+"&param4="+param4
}
		function ajouterClub() {
			var nom=document.getElementById('nomClub').value;
			var ville=document.getElementById('villeClub').value;
			var classement=document.getElementById('classementClub').value;
			var titres=document.getElementById('titresClub').value;
			
			param1=nom;
			param2=ville;
			param3=classement;
			param4=titres;
				
			var url="AddClubSrv"
			
			window.document.location=url+"?param1="+param1+"&param2="+param2+"&param3="+param3+"&param4="+param4	
		}


	//cela évite de trop soliciter la BDD avec des requetes
	function SearchClub() {
	  // Declare variables
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("SearchClub");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("table_club");
	  tr = table.getElementsByTagName("tr");
	
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[0];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}
	
	
	$(document).ready(function() {
  // Désactiver le bouton "Ajouter" au départ
  $('#ajouterClubModal button[type="submit"]').prop('disabled', true);

  // Vérifier si tous les champs sont remplis
  $('#ajouterClubForm input').on('keyup', function() {
    var vide = false;
    $('#ajouterClubForm input').each(function() {
      if ($(this).val() == '') {
        vide = true;
      }
    });

    // Activer ou désactiver le bouton "Ajouter" selon le contenu des champs
    if (vide) {
      $('#ajouterClubModal button[type="submit"]').prop('disabled', true);
    } else {
      $('#ajouterClubModal button[type="submit"]').prop('disabled', false);
    }
  });
});
