package models;

import java.sql.*;

public class ParametresBD {
	/*		
	 * 		========================
	 * 		param�tres Serveur Mysql
	 * 		========================
	 */
		// d�finir les params de la BD Mysql  : 
		private static final String urlMY = "jdbc:mysql://localhost/mini_projet4";
		private static final String userMY = "root";
		private static final String passwordMY = "";
		private static final String driverJMY = "com.mysql.jdbc.Driver";
		/*
		 * 		==============================
		 *  	getteurs (pas de setteurs ici)
		 *  	==============================
		 */
		public static String getDriverJ() {
				return driverJMY;
		}
		public static String getUrl() {	
					return urlMY;
		}
		public static String getUser() {
					return userMY;
		}
		public static String getPassword() {
				return passwordMY;
		}
		// une m�thode qui permet d'interroger la bd : on lui passe une requete
		public static ResultSet executeRequeteSQL(String requete) 
						throws ClassNotFoundException{
			try {
				// je r�cup�re params BD
				String drv=getDriverJ();
				String url=getUrl();
				String usr=getUser();
				String pwd=getPassword();
				// je charge le driver jdbc
				Class.forName(drv);
				// je me connecte la BD
				Connection connexion = DriverManager.getConnection(url
						,usr,pwd);
				// je fabrique une demande SQL
				Statement instruction = connexion.createStatement();
				// j'envoie la demande SQL � la BD et je r�cup�re le r�sultat
				ResultSet resultatTemp = instruction.executeQuery(requete);
				// je renvoie les lignes de la table au code appelant
				return resultatTemp;
				} 
			catch (Exception e) {
				return null;
				}
			}

	public static int executeUpdateSQL(String requete) throws ClassNotFoundException{
	try {
		Class.forName(getDriverJ());
		Connection connexion = DriverManager.getConnection(getUrl(),getUser(),getPassword());
		Statement instruction = connexion.createStatement();
		int resultatTemp = instruction.executeUpdate(requete);
		return resultatTemp;
		} 
	catch (Exception e) 
	{
		return -1;
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
	    // R�cup�ration des param�tres de la base de donn�es
	    String driver = getDriverJ();
	    String url = getUrl();
	    String user = getUser();
	    String password = getPassword();
	    // Chargement du driver JDBC
	    Class.forName(driver);
	    // Ouverture de la connexion � la base de donn�es
	    Connection connection = DriverManager.getConnection(url, user, password);
	    return connection;
	}
	
	public static void TestConnection()
	{
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mini_projet4", "root", "");
	    System.out.println("Connecter");
	} catch (Exception e){
	    e.printStackTrace();
	    System.out.println("Erreur");
	    System.exit(0);
	}
	}
	
}