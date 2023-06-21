/**
 * 
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
/**
 * @author ernan
 *
 */
public class JoueursModel {
	// attrs ;

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String club;
	private String poste;
	
	//getter + setter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	//
	// rechercher un joueur
	//
	public static ArrayList<JoueursModel> Joueur(int id) throws SQLException {
	    String ReqJoueur = "SELECT j.*, c.nom AS nom_club FROM joueur j JOIN club c ON j.club = c.id where j.id=" + id + "";
	    System.out.println(ReqJoueur);
	    try {
	        ResultSet resFiche = ParametresBD.executeRequeteSQL(ReqJoueur);
	        ArrayList<JoueursModel> joueurFound = new ArrayList<JoueursModel>();

	        if (resFiche != null && resFiche.next()) { // Vérifier si resFiche n'est pas null et s'il y a des résultats
	            JoueursModel j = new JoueursModel();
	            j.setId(resFiche.getInt("id"));
	            j.setNom(resFiche.getString("nom"));
	            j.setPrenom(resFiche.getString("prenom"));
	            j.setAge(resFiche.getInt("age"));
	            j.setPoste(resFiche.getString("poste"));
	            j.setClub(resFiche.getString("nom_club"));
	            joueurFound.add(j);
	        }

	        return joueurFound;
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.out.println("PB DANS CLASSE joueurModel");
	        return null;
	    }
	}

	
	
	public static ArrayList<JoueursModel> listeJoueurs() throws SQLException {
	    String ReqJoueurs = "SELECT j.*, c.nom AS nom_club FROM joueur j JOIN club c ON j.club = c.id";
	    System.out.println(ReqJoueurs);
	    try {
	        ResultSet resRechercheJ = ParametresBD.executeRequeteSQL(ReqJoueurs);
	        ArrayList<JoueursModel> joueursFound = new ArrayList<JoueursModel>();

	        while (resRechercheJ.next()) {
	            JoueursModel j = new JoueursModel();
	            j.setId(resRechercheJ.getInt("id"));
	            j.setNom(resRechercheJ.getString("nom"));
	            j.setPrenom(resRechercheJ.getString("prenom"));
	            j.setAge(resRechercheJ.getInt("age"));
	            j.setClub(resRechercheJ.getString("nom_club"));
	            joueursFound.add(j);
	        }

	        return joueursFound;

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.out.println("PB RECHERCHER DANS CLASSE joueurModel");
	        return null;
	    }
	}
	
    public static boolean supprimerJoueur(int id) throws SQLException 
    {
    	
    	String reqSupprimer="DELETE FROM joueur WHERE id="+id; // Construction de la requête 
    	System.out.println("Requête SQL : " + reqSupprimer); // ajout de l'affichage de la requête SQL
    	
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqSupprimer)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la suppression d'un nouveau club dans la classe JoueurModel");
            return false;
        }
    	
    }
    
    public static boolean ajouterJoueur(String param1 , String param2, int param3 , int param4, String param5) throws SQLException {
        String reqAjout = "INSERT INTO joueur(Nom, Prenom, Club, age, poste) VALUES ('"+param1+"','"+param2+"',"+param3+","+param4+",'"+param5+"')";
        System.out.println("Requête SQL : " + reqAjout); // ajout de l'affichage de la requête SQL
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqAjout)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'ajout d'un nouveau club dans la classe JoueurModel");
            return false;
        }
    }
    
    public static boolean modifierJoueur(int id, String nom, String prenom,int club, int age, String poste) throws SQLException {
        String reqModifier = "UPDATE joueur "
                + "SET nom='" + nom + "', prenom='" + prenom + "', club=" + club + ", age=" + age + ", poste='" + poste + "' "
                + "WHERE id=" + id + ";";

        System.out.println("Requête SQL : " + reqModifier);

        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqModifier)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la modification d'un joueur dans la classe JoueursModel");
            return false;
        }
    }


}
