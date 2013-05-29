package DAO;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Xavier TALANDIER
 */
public class DAO<T> extends DAOTable {
	public String tb_name;
	public String tb_primaire;
	private Connection conn;
	private Statement  stat;
	private boolean isConnected = false;
	
	public DAO() {
		initDB();
	}
	public DAO(int id) {
		initDB();
		initWithID(id);
	}

	/**
	 * Initialise la connection à la base de données
	 */
	public final void initDB(){
		// Récupération des champs de la CLASSE
		Field[] f = this.getClass().getDeclaredFields();
		for(int i = 0 ; i < f.length ; i++ ){
			if(f[i].getName().substring(0 , 3).equals("ch_")){
				lesChamps.add(f[i].getName().toString().substring(3));
			}
		}
	}
	
	public void connect(){
		if(!isConnected){
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection("jdbc:mysql:///gl12?"
                                        + "user=root");
				stat = conn.createStatement();
				stat.executeUpdate("use gl12");
				System.out.println("Connexion: OK");
			} catch (SQLException e) {
				System.out.println("sql exception");
				while (e != null) {
					System.out.println(e.getErrorCode());
					System.out.println(e.getMessage());
					System.out.println(e.getSQLState());
					e.printStackTrace();
					e = e.getNextException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			isConnected = true;
		}
	}
	
	public void close(){
		try {
			conn.close();
			isConnected = false;
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	/**
	 * Initialise l'objet avec les données
	 * d'un ligne
	 * @param id 
	 */	
	public final void initWithID(int id){
		String query = "SELECT * FROM " + getTableName() + " WHERE " + getPrimaryKey() + "='" + id + "'";
		try {
			ResultSet rs = this.executeS(query);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int nCols = rsMetaData.getColumnCount();
			String nomCol;
			String typCol;
			while (rs.next()) {
				for(int i = 1 ; i < nCols + 1 ; i++){
                                        rsMetaData = rs.getMetaData();
					nomCol = rsMetaData.getColumnName(i);
					typCol = rsMetaData.getColumnTypeName(i);
					// Si c'est un entier, alors on récupere via getInt
					if(typCol.indexOf("INT") > -1){
						setValueOf(nomCol, rs.getInt(nomCol));
					}else if(typCol.indexOf("FLOAT") > -1){
						setValueOf(nomCol, rs.getFloat(nomCol));
					}else if(typCol.indexOf("DATETIME") > -1){
						setValueOf(nomCol, rs.getTimestamp(nomCol).toString());
					// Sinon, on récupere via getString
					}else{
						setValueOf(nomCol, rs.getString(nomCol));
					}
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		close();
	}

	/**
	 * Affecte une valeur à un champ
	 * @param key Nom du champ
	 * @param val Valeur du champ
	 */
	public void setValueOf(String key , Object val){
		Field[] f = this.getClass().getDeclaredFields();
		int n = f.length;
		key = "ch_" + key;
		for(int i = 0 ; i < n ; i++){
			if(f[i].getName().equals(key)){
				try {
					f[i].set(this, val);
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
	}
	public Object getValueOf(int key){
		return getValueOf(lesChamps.get(key));
	}

	/**
	 * Récupère la valeur d'un champ
	 * @param key Nom du champ
	 * @return Object
	 */
	public Object getValueOf(String key){
		if(!key.substring(0 , 3).equals("tb_")){
			key = "ch_" + key;
		}
		Object tbNom = null;
		Field[] f = this.getClass().getDeclaredFields();		
		for(int i = 0 ; i < f.length ; i++){
			if(f[i].getName().equals(key)){
				try {
					tbNom = f[i].get(this);
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		return tbNom;
	}
	
	/**
	 * Retourne le nom de la table
	 * @return String
	 */
	public String getTableName(){
		return getValueOf("tb_name").toString();
	}
	
	/**
	 * Retourne le nom du champ de la clé primaire
	 * @return String
	 */
	public String getPrimaryKey(){
		return getValueOf("tb_primaire").toString();
	}
	
	/**
	 * Retourne l'identifiant de l'objet
	 * @return int
	 */
	public int getID(){
		System.out.println("getID() = " +  getValueOf(getValueOf("tb_primaire").toString()).toString());
		String id = (String) getValueOf(getValueOf("tb_primaire").toString()).toString();
		return Integer.parseInt(id);
	}
	
	/**
	 * Enregistre l'objet courant
	 */
	public void save(){
		String query = "";
		Field[] f = this.getClass().getDeclaredFields();
		/*
		 * Si l'ID est null (0), alors, l'objet
		 * n'est pas encore enregistré; donc, on
		 * fait un INSERT. Sinin, un UPDATE
		 */
		if(getID() == 0){
			String query2 = "(";
			for(int i = 0 ; i < f.length ; i++){
				if(f[i].getName().substring(0 , 3).equals("ch_") && !f[i].getName().equals("ch_" + getPrimaryKey())){
					try {
						query += f[i].getName().substring(3);
						query2+= "'" + f[i].get(this) + "'";
					} catch (IllegalArgumentException ex) {
						Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
					}
					if(i < f.length - 1){
						query += ",";
						query2+= ",";
					}
				}
			}
			query = "INSERT INTO " + getTableName() + " (" + query + ") VALUES " +  query2 + ");";
			execute(query);
			
			ResultSet rs = executeS("SELECT LAST_INSERT_ID() as id;");
			try {
				while(rs.next()){
					System.out.println("ID=" + rs.getInt("id"));
					setValueOf(getPrimaryKey(), rs.getInt("id"));
				}
			} catch (SQLException ex) {
				Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
			}
		}else{
			query = "UPDATE " + getTableName() + " SET ";
			for(int i = 0 ; i < f.length ; i++){
				if(f[i].getName().substring(0 , 3).equals("ch_") && !f[i].getName().equals("ch_" + getPrimaryKey())){
					try {
						query+= f[i].getName().substring(3) + "='" + f[i].get(this) + "' ";
					} catch (IllegalArgumentException ex) {
						Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
					}
					if(i < f.length - 1){
						query+= ", ";
					}
				}
			}
			query+= " WHERE " + getPrimaryKey() + "=" + getID() + ";";
			execute(query);
		}
		close();
		System.out.println("Query : " + query);
	}

	/**
	 * Exécute une requete SQL avec retour (ex: SELECT)
	 * @param query Requete SQL
	 * @return ResultSet
	 */
	public ResultSet executeS(String query){
		ResultSet ret = null;
		connect();
		try {
			ret = stat.executeQuery(query);
		} catch (SQLException ex) {
			ret = null;
		}
		return ret;
	}
	
	/**
	 * Execute une requete SQL sans retour (ex: INSERT)
	 * @param query Requete SQL
	 */
	public void execute(String query){
		connect();
		try {
			stat.execute(query);
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	@Override
	public String toString(){
		String leObj = "";
		Field[] f = this.getClass().getDeclaredFields();
		for(int i = 0 ; i < f.length ; i++){
			if(f[i].getName().substring(0, 3).equals("ch_")){
				try {
					leObj += f[i].getName().substring(3) + "=" + f[i].get(this) + ";";
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}
		System.out.println();
		return leObj;
	}

	public void chargerData(String where){
		//this.addTableModelListener(this);
		String query = "SELECT " + getPrimaryKey() + " FROM " + getTableName();
		if(!where.equals("")){
			query += " WHERE " + where;
		}
		data.clear();
		ResultSet rs = executeS(query);
		try {
			System.out.println(this.getClass().getName());
			while(rs.next()){
				try {
					try {
						//.initWithID(rs.getInt(getPrimaryKey()))
						DAO oo = (DAO) Class.forName(this.getClass().getName()).newInstance();
						oo.initWithID(rs.getInt(getPrimaryKey()));
						data.add(oo);
						//data.add(Class.forName(this.getClass().getName()).newInstance());
					} catch (ClassNotFoundException ex) {
						Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
					}
				} catch (InstantiationException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalAccessException ex) {
					Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		close();
	}
	
}
