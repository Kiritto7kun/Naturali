package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Modelo.ClienteDAO;
import Modelo.ClienteDTO;

/**
 * Servlet implementation class MenusCliente
 */
@WebServlet("/MenusCliente")
public class MenusCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusCliente() {
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
		String di, c, n, t;
		int d;
		boolean res;
		ClienteDTO cldto;
		ClienteDAO cldao;
		ClienteDTO recdatos;
		
		if(request.getParameter("btncre")!=null) {
			d=Integer.parseInt(request.getParameter("cc"));
			di=request.getParameter("dir");
			c=request.getParameter("corr");
			n=request.getParameter("nom");
			t=request.getParameter("tel");
			
			cldto=new ClienteDTO(d, di, c, n, t);
			cldao=new ClienteDAO();
			res=cldao.insertarusuario(cldto);
			
			if(res) {
				JOptionPane.showMessageDialog(null, "Cliente creado");
				response.sendRedirect("Cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Cliente no creado");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
		
		if(request.getParameter("btncon")!= null) {
			//Accion para consultar
			int doc;
			d=Integer.parseInt(request.getParameter("cc"));
			cldto=new ClienteDTO(d);
			cldao=new ClienteDAO();
			recdatos=cldao.consultarusuario(cldto);
			doc=recdatos.getCedula_cliente();
			di=recdatos.getDireccion_cliente();
			c=recdatos.getEmail_cliente();
			n=recdatos.getNombre_cliente();
			t=recdatos.getTelefono_clinete();
			response.sendRedirect("Cliente.jsp?c="+doc+"&&di="+di+"&&cor="+c+"&&no="+n+"&&te="+t);
		}
		
		
		if(request.getParameter("btnact")!= null) {
			//Accion para consultar usuario
			boolean dat;
			d=Integer.parseInt(request.getParameter("cc"));
			di=request.getParameter("dir");
			c=request.getParameter("corr");
			n=request.getParameter("nom");
			t=request.getParameter("tel");
			cldto=new ClienteDTO(d, di, c, n, t);
			cldao=new ClienteDAO();
			dat=cldao.actualizar(cldto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El cliente se actualizo");
				response.sendRedirect("Cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El cliente no se actualizo");
				response.sendRedirect("MenuPrincipal.jsp");
			}
			
		}
		
		if(request.getParameter("btnbor")!= null) {
			//Accion para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("cc"));
			cldto=new ClienteDTO(d);
			cldao=new ClienteDAO();
			y=cldao.eliminar(cldto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El cliente fue borrado");
				response.sendRedirect("Cliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El cliente no fue borrado");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
	}

}
