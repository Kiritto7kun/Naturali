package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	Connection cnn;
	
	public Connection conexiondb(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				cnn=DriverManager.getConnection("jdbc:mysql://localhost/naturali","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		return cnn;
	}

}
