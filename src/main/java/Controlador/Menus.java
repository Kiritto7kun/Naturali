package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import Modelo.UsuarioDAO;
import Modelo.UsuarioDTO;

/**
 * Servlet implementation class Menus
 */
@WebServlet("/Menus")
public class Menus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menus() {
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
		String u,n,c,e;
		int d;
		boolean res;
		UsuarioDTO usdto;
		UsuarioDAO usdao;
		UsuarioDTO recdatos;
		
		if(request.getParameter("btncre")!=null) {
			d=Integer.parseInt(request.getParameter("cc"));
			e=request.getParameter("corr");
			n=request.getParameter("nom");
			c=request.getParameter("con");
			u=request.getParameter("usu");
			
			usdto=new UsuarioDTO(d, e, n, c, u);
			usdao=new UsuarioDAO();
			res=usdao.insertarusuario(usdto);
			
			if(res) {
				JOptionPane.showMessageDialog(null, "Usuario se creo");
				response.sendRedirect("Usuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuario no se creo");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
		
		if(request.getParameter("btncon")!= null) {
			//Accion para consultar
			int doc;
			d=Integer.parseInt(request.getParameter("cc"));
			usdto=new UsuarioDTO(d);
			usdao=new UsuarioDAO();
			recdatos=usdao.consultarusuario(usdto);
			doc=recdatos.getCedula_usuario();
			e=recdatos.getEmail_usuario();
			n=recdatos.getNombre_usuario();
			c=recdatos.getPasword();
			u=recdatos.getUsuario();
			response.sendRedirect("Usuario.jsp?c="+doc+"&&cor="+e+"&&no="+n+"&&co="+c+"&&us="+u);
		}
		
		
		if(request.getParameter("btnact")!= null) {
			//Accion para consultar usuario
			boolean dat;
			d=Integer.parseInt(request.getParameter("cc"));
			e=request.getParameter("corr");
			n=request.getParameter("nom");
			c=request.getParameter("con");
			u=request.getParameter("usu");
			usdto=new UsuarioDTO(d, e, n, c, u);
			usdao=new UsuarioDAO();
			dat=usdao.actualizar(usdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El usuario se actualizo");
				response.sendRedirect("Usuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
				response.sendRedirect("MenuPrincipal.jsp");
			}
			
		}
		
		if(request.getParameter("btnbor")!= null) {
			//Accion para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("cc"));
			usdto=new UsuarioDTO(d);
			usdao=new UsuarioDAO();
			y=usdao.eliminar(usdto);
			if(y>0){
				JOptionPane.showMessageDialog(null, "El usuario fue borrado");
				response.sendRedirect("Usuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no fue borrado");
				response.sendRedirect("MenuPrincipal.jsp");
			}
		}
	}

}
