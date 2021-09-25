package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class ProveedoresDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ProveedoresDTO pro;
	
	public boolean insertarusuario(ProveedoresDTO pr) {
		int x;
		boolean dat=false;
		try {
			pro=consultarusuario(pr);
			if(pro==null) {
				ps=cnn.prepareStatement("INSERT INTO proveedores VALUES(?,?,?,?,?)");
				ps.setInt(1, pr.getNitproveedor());
				ps.setString(2, pr.getCiudad_proveedor());
				ps.setString(3, pr.getDireccion_proveedor());
				ps.setString(4, pr.getNombre_proveedor());
				ps.setString(5, pr.getTelefono_proveedor());
				x=ps.executeUpdate();
				if(x>0) {
					dat=true;
				}
				else {
					JOptionPane.showMessageDialog(null, "El proveedor se creo");
				}
			}			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el proveedor"+e);
		}
		return dat;
	}
	
	public ProveedoresDTO consultarusuario(ProveedoresDTO pr) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, pr.getNitproveedor());
			rs=ps.executeQuery();
			if(rs.next()) {
				pro=new ProveedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public int eliminar(ProveedoresDTO pr) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, pr.getNitproveedor());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	
	public boolean actualizar(ProveedoresDTO pr) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=? WHERE nitproveedor=?");
			ps.setString(1, pr.getCiudad_proveedor());
			ps.setString(2, pr.getDireccion_proveedor());
			ps.setString(3, pr.getNombre_proveedor());
			ps.setString(4, pr.getTelefono_proveedor());
			ps.setInt(5, pr.getNitproveedor());
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
