package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ProveedoresDAO;
import Modelo.ProveedoresDTO;

/**
 * Servlet implementation class MenusProveedores
 */
@WebServlet("/MenusProveedores")
public class MenusProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c, d, n, t ;
		int ni;
		boolean res;
		ProveedoresDTO prdto;
		ProveedoresDAO prdao;
		ProveedoresDTO recdatos;
		
		if(request.getParameter("btncre")!=null) {
			ni=Integer.parseInt(request.getParameter(""));
			c=request.getParameter("");
			d=request.getParameter("dir");
			n=request.getParameter("nom");
			t=request.getParameter("tel");
			
			prdto=new ProveedoresDTO(ni, c, d, n, t);
			prdao=new ProveedoresDAO();
			res=prdao.insertarusuario(prdto);
			
			if(res) {
				JOptionPane.showMessageDialog(null, "Proveedor creado");
				response.sendRedirect("Proveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Proveedor no creado");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
		
		if(request.getParameter("btncon")!= null) {
			//Accion para consultar
			int nit;
			ni=Integer.parseInt(request.getParameter(""));
			prdto=new ProveedoresDTO(ni);
			prdao=new ProveedoresDAO();
			recdatos=prdao.consultarusuario(prdto);
			nit=recdatos.getNitproveedor();
			c=recdatos.getCiudad_proveedor();
			d=recdatos.getDireccion_proveedor();
			n=recdatos.getNombre_proveedor();
			t=recdatos.getTelefono_proveedor();
			response.sendRedirect("Proveedores.jsp?ni="+nit+"&&ci="+c+"&&di="+d+"&&no="+n+"&&te="+t);
		}
		
		
		if(request.getParameter("btnact")!= null) {
			//Accion para consultar usuario
			boolean dat;
			ni=Integer.parseInt(request.getParameter(""));
			c=request.getParameter("");
			d=request.getParameter("dir");
			n=request.getParameter("nom");
			t=request.getParameter("tel");
			prdto=new ProveedoresDTO(ni,c,d,n,t);
			prdao=new ProveedoresDAO();
			dat=prdao.actualizar(prdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El proveedor se actualizo");
				response.sendRedirect("Proveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El proveedor no se actualizo");
				response.sendRedirect("MenuPrincipal.jsp");
			}
			
		}
		
		if(request.getParameter("btnbor")!= null) {
			//Accion para eliminar
			int y;
			ni=Integer.parseInt(request.getParameter(""));
			prdto=new ProveedoresDTO(ni);
			prdao=new ProveedoresDAO();
			y=prdao.eliminar(prdto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El proveedor fue borrado");
				response.sendRedirect("Proveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El proveedor no fue borrado");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
	}

}
