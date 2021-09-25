package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class UsuarioDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	UsuarioDTO usu;
	
	public boolean insertarusuario(UsuarioDTO us) {
		int x;
		boolean dat=false;
		try {
			usu=consultarusuario(us);
			if(usu==null) {
				ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
				ps.setInt(1, us.getCedula_usuario());
				ps.setString(2, us.getEmail_usuario());
				ps.setString(3, us.getNombre_usuario());
				ps.setString(4, us.getPasword());
				ps.setString(5, us.getUsuario());
				x=ps.executeUpdate();
				if(x>0) {
					dat=true;
				}
				else {
					JOptionPane.showMessageDialog(null, "El usuario se creo");
				}
			}			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el ususario"+e);
		}
		return dat;
	}
	
	public UsuarioDTO consultarusuario(UsuarioDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, us.getCedula_usuario());
			rs=ps.executeQuery();
			if(rs.next()) {
				usu=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usu;
	}
	
	public int eliminar(UsuarioDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, us.getCedula_usuario());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	
	public boolean actualizar(UsuarioDTO us) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario=?, nombre_usuario=?, pasword=?, usuario=? WHERE cedula_usuario=?");
			ps.setString(1, us.getEmail_usuario());
			ps.setString(2, us.getNombre_usuario());
			ps.setString(3, us.getPasword());
			ps.setString(4, us.getUsuario());
			ps.setInt(5, us.getCedula_usuario());
			x=ps.executeUpdate();
			if(x>0) {
				dat=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return dat;
	}

}
