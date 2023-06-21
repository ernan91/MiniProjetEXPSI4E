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
public class ClubsModel {
    private int id;
    private String nom;
    private String ville;
    private int positionClassement;
    private String dateCreation;
    private int titres;


	public ClubsModel(String nom2, String ville2, int classement, int titreS) {
		// TODO Auto-generated constructor stub
	}
	
	public ClubsModel() {
		// TODO Auto-generated constructor stub
	}

	// Getters et setters
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getPositionClassement() {
        return positionClassement;
    }

    public void setPositionClassement(int positionClassement) {
        this.positionClassement = positionClassement;
    }
    public int getTitres() {
        return titres;
    }

    public void setTitres(int titres) {
        this.titres = titres;
    }
    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    // Recherche d'un club par son ID
    public static ArrayList<ClubsModel> ficheClub(int id) throws SQLException {
        ArrayList<ClubsModel> ficheFound = new ArrayList<ClubsModel>();
        String reqFiche = "SELECT * FROM club WHERE id = ?";
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqFiche)) {
            ps.setInt(1, id);
            ResultSet resFiche = ps.executeQuery();
            
            if (resFiche.next()) {
            	ClubsModel ff = new ClubsModel();
                ff.setId(resFiche.getInt("id"));
                ff.setNom(resFiche.getString("nom"));
                ff.setVille(resFiche.getString("ville"));
                ff.setDateCreation(resFiche.getString("dateCreation"));
                ff.setTitres(resFiche.getInt("titres"));
                ff.setPositionClassement(resFiche.getInt("positionClassement"));
              
                ficheFound.add(ff);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la recherche de fiche club dans la classe ClubModel");
        }
        
        return ficheFound;
    }

    // Recherche de la liste de tous les clubs
    public static ArrayList<ClubsModel> listeClub() throws SQLException {
        ArrayList<ClubsModel> clubsFound = new ArrayList<ClubsModel>();
        String reqClub = "SELECT * FROM club ORDER BY position_classement ASC";
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqClub)) {
            ResultSet resRecherche = ps.executeQuery();
            
            while (resRecherche.next()) {
            	ClubsModel rt = new ClubsModel();
                rt.setId(resRecherche.getInt("id"));
                rt.setNom(resRecherche.getString("nom"));
                rt.setVille(resRecherche.getString("Ville"));
                clubsFound.add(rt);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la recherche de la liste des clubs dans la classe ClubModel");
        }
        
        return clubsFound;
    }
    
 
    //Recherche de la liste de tous les clubs
    public static ArrayList<ClubsModel> listeNomClub() throws SQLException {
        ArrayList<ClubsModel> clubsFound = new ArrayList<ClubsModel>();
        String reqClub = "SELECT id,nom FROM club";
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqClub)) {
            ResultSet resRecherche = ps.executeQuery();
            
            while (resRecherche.next()) {
            	ClubsModel rt = new ClubsModel();
            	 rt.setId(resRecherche.getInt("id"));
                rt.setNom(resRecherche.getString("nom"));
                clubsFound.add(rt);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la recherche de la liste des clubs dans la classe ClubModel");
        }
        
        return clubsFound;
    }
    
    
    public static boolean ajouterClub(String param1 , String param2, int param3 , int param4) throws SQLException {
        String reqAjout = "INSERT INTO club(nom, Ville, titres, position_classement) VALUES ('"+param1+"','"+param2+"',"+param3+","+param4+")";
        System.out.println("Requête SQL : " + reqAjout); // ajout de l'affichage de la requête SQL
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqAjout)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'ajout d'un nouveau club dans la classe ClubModel");
            return false;
        }
    }
    
    public static boolean supprimerClub(int id) throws SQLException 
    {
    	
    	String reqSupprimer="DELETE FROM club WHERE id="+id; // Construction de la requête 
    	System.out.println("Requête SQL : " + reqSupprimer); // ajout de l'affichage de la requête SQL
    	
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqSupprimer)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la suppression d'un nouveau club dans la classe ClubModel");
            return false;
        }
    	
    }
    
    
    public static ArrayList<ClubsModel> getClubInfo(int id) throws SQLException {
    	String reqInfo = "SELECT * FROM club WHERE id="+id+"";
    	System.out.println("Requête SQL : " + reqInfo);
    	ArrayList<ClubsModel> clubInfo = new ArrayList<ClubsModel>();
    	
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqInfo)) {
            ResultSet resRecherche = ps.executeQuery();
            
            while (resRecherche.next()) {
            	ClubsModel rt = new ClubsModel();
            	 rt.setId(resRecherche.getInt("id"));
                rt.setNom(resRecherche.getString("nom"));
                rt.setVille(resRecherche.getString("ville"));
                rt.setTitres(resRecherche.getInt("titres"));
                rt.setPositionClassement(resRecherche.getInt("position_classement"));
                clubInfo.add(rt);
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors du chargment des infos du club dans la classe ClubModel");
        }
        return clubInfo;
    }
    
    public static boolean modifierClub(int id, String param1 , String param2, int param3 , int param4) throws SQLException {
    	String reqModifier = "UPDATE club "
    			+ "SET nom = '"+param1+"', ville ='"+param2+"' , titres="+param3+", position_classement="+param4+""
    			+ "WHERE id="+id+";";
    	
        System.out.println("Requête SQL : " + reqModifier); // ajout de l'affichage de la requête SQL
        
    	try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqModifier)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la modification d'un nouveau club dans la classe ClubModel");
            return false;
        }
    	
    }

}
