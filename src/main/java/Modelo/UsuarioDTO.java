package Modelo;

public class UsuarioDTO {
	private int cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String pasword;
	private String usuario;
	
	public UsuarioDTO(int cedula_usuario, String email_usuario, String nombre_usuario, String pasword, String usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.pasword = pasword;
		this.usuario = usuario;
	}

	public UsuarioDTO(int cedula_usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
	}

	public int getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(int cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getEmail_usuario() {
		return email_usuario;
	}

	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}	
}
