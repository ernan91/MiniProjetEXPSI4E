package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.PreparedStatement;

public class MatchsModel {
	private int id;
    private int ClubDom;
    private int ClubExt;
    private String ClubDomNom;
    private String ClubExtNom;
    private Date DateMatch;
    private String resultat;

    public void setClubDomNom(String ClubDomNom ) {
    	this.ClubDomNom = ClubDomNom;
    }
    public String getClubDomNom() {
    	return ClubDomNom;
    }
    public void setClubExtNom(String ClubExtNom ) {
    	this.ClubExtNom = ClubExtNom;
    }
    public String getClubExtNom() {
    	return ClubExtNom;
    }
    public void setId(int id) {
    	this.id = id;
    }
    public int getId() {
    	return id;
    }
    
    public int getClubDom() {
        return ClubDom;
    }

    public void setClubDom(int clubDom) {
        ClubDom = clubDom;
    }

    public int getClubExt() {
        return ClubExt;
    }

    public void setClubExt(int clubExt) {
        ClubExt = clubExt;
    }

    public Date getDateMatch() {
        return DateMatch;
    }

    public void setDateMatch(Date dateMatch) {
        DateMatch = dateMatch;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    public static boolean supprimerMatch(int id) throws SQLException 
    {
    	
    	String reqSupprimer="DELETE FROM matchs WHERE id="+id; // Construction de la requête 
    	System.out.println("Requête SQL : " + reqSupprimer); // ajout de l'affichage de la requête SQL
    	
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqSupprimer)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la suppression d'un match dans la classe MatchsModel");
            return false;
        }
    	
    }
    
    public static boolean ajouterMatch (int param1 , int param2, Date param3 , String param4) throws SQLException {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String dateFormatted = dateFormat.format(param3);

        String reqAjout = "INSERT INTO matchs (club_dom, club_ext, date, resultat) VALUES ("+param1+","+param2+",'"+dateFormatted+"','"+param4+"')";
        System.out.println("Requête SQL : " + reqAjout); // ajout de l'affichage de la requête SQL
        
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqAjout)) {
            int result = ps.executeUpdate();
            return result > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de l'ajout d'un nouveau match dans la classe matchmodel");
            return false;
        }
    }
    
    // Recherche de la liste de tous les clubs
    public static ArrayList<MatchsModel> listeMatchs() throws SQLException {
        ArrayList<MatchsModel> matchsFound = new ArrayList<MatchsModel>();
        String reqMatchs = "SELECT matchs.id, c1.nom as club_dom, c2.nom as club_ext, matchs.date, matchs.resultat FROM matchs JOIN club c1 ON matchs.club_dom = c1.id JOIN club c2 ON matchs.club_ext = c2.id ORDER BY matchs.date ASC";
        System.out.println(reqMatchs);
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqMatchs)) {
            ResultSet resRecherche = ps.executeQuery();
            
            while (resRecherche.next()) {
            	MatchsModel rt = new MatchsModel();
            	rt.setId(resRecherche.getInt("id"));;
                rt.setClubDomNom(resRecherche.getString("club_dom"));
                rt.setClubExtNom(resRecherche.getString("club_ext"));
                rt.setDateMatch(resRecherche.getDate("date"));
                rt.setResultat(resRecherche.getString("resultat"));
                matchsFound.add(rt);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la recherche de la liste des matchs dans la classe MatchsModel");
        }
        
        return matchsFound;
    }
    
    // Recherche de la liste de tous les clubs
    public static ArrayList<MatchsModel> Match(int id) throws SQLException {
        ArrayList<MatchsModel> matchsFound = new ArrayList<MatchsModel>();
        String reqMatchs = "SELECT matchs.id, c1.nom as club_dom, c2.nom as club_ext, matchs.club_dom as club_dom_id ,matchs.club_ext as club_ext_id ,  matchs.date, matchs.resultat FROM matchs JOIN club c1 ON matchs.club_dom = c1.id JOIN club c2 ON matchs.club_ext = c2.id WHERE matchs.id="+id+" ORDER BY matchs.date ASC ";
        System.out.println(reqMatchs);
        try (PreparedStatement ps = (PreparedStatement) ParametresBD.getConnection().prepareStatement(reqMatchs)) {
            ResultSet resRecherche = ps.executeQuery();
            
            while (resRecherche.next()) {
            	MatchsModel rt = new MatchsModel();
            	rt.setId(resRecherche.getInt("id"));
            	rt.setClubDom(resRecherche.getInt("club_dom_id"));
                rt.setClubExt(resRecherche.getInt("club_ext_id"));
                rt.setClubDomNom(resRecherche.getString("club_dom"));
                rt.setClubExtNom(resRecherche.getString("club_ext"));
                rt.setDateMatch(resRecherche.getDate("date"));
                rt.setResultat(resRecherche.getString("resultat"));
                matchsFound.add(rt);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problème lors de la recherche de la liste des matchs dans la classe MatchsModel");
        }
        
        return matchsFound;
    }
    
}
