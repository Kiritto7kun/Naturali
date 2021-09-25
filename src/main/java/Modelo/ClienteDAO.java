package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Controlador.Conexion;

public class ClienteDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ClienteDTO cli;
	
	public boolean insertarusuario(ClienteDTO cl) {
		int x;
		boolean dat=false;
		try {
			cli=consultarusuario(cl);
			if(cli==null) {
				ps=cnn.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
				ps.setInt(1, cl.getCedula_cliente() );
				ps.setString(2, cl.getDireccion_cliente());
				ps.setString(3, cl.getEmail_cliente());
				ps.setString(4, cl.getNombre_cliente());
				ps.setString(5, cl.getTelefono_clinete());
				x=ps.executeUpdate();
				if(x>0) {
					dat=true;
				}
				else {
					JOptionPane.showMessageDialog(null, "El cliente se creo");
				}
			}			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el cliente"+e);
		}
		return dat;
	}
	
	public ClienteDTO consultarusuario(ClienteDTO cl) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cl.getCedula_cliente());
			rs=ps.executeQuery();
			if(rs.next()) {
				cli=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}
	
	public int eliminar(ClienteDTO cl) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cl.getCedula_cliente());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	
	public boolean actualizar(ClienteDTO cl) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_clinete=? WHERE cedula_cliente=?");
			ps.setString(1, cl.getDireccion_cliente());
			ps.setString(2, cl.getEmail_cliente());
			ps.setString(3, cl.getNombre_cliente());
			ps.setString(4, cl.getTelefono_clinete());
			ps.setInt(5, cl.getCedula_cliente());
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
