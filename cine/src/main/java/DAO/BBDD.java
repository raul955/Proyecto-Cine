package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cine.pelicula;

public class BBDD {

		pelicula pel;
		Connection con;
		PreparedStatement pst;
		Statement st;
		ResultSet rs;
		int result;
		String forName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.14.203:1521:xe";
		String user = "cine";
		String pass = "cine";
	
		public pelicula mostrarTodoDirector(String director) throws ClassNotFoundException, SQLException {
			
		
			pelicula pel = null;
			
			Class.forName("forName");
			
			con = DriverManager.getConnection(url,user,pass);
			
			pst = con.prepareStatement("SELECT * FROM cine WHERE director = ?");
			
			pst.setString(1, director);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				pel = new pelicula(rs.getString("nombre"),rs.getString("director"),rs.getInt("id"));
				
			}
			
				
			return pel;
		
		}
		
		public List<pelicula> mostrarTablaPeliculas(String director) throws ClassNotFoundException, SQLException {
			
			ArrayList<pelicula> lista = new ArrayList<pelicula>();
				
			Class.forName("oracle.jdbc.driver.OracleDriver");
				
				con = DriverManager.getConnection(url,user,pass);
				
				st = con.createStatement();
				
				rs = st.executeQuery("select * from cine where director like('"+director+"')");
				
				while(rs.next()) {
					
					lista.add(new pelicula(rs.getString("nombre"),rs.getString("director"),rs.getInt("id")));
					
				}
				
				return lista;
			
		}
		
}
