package Modelo;

public class ClienteDTO {
	private int cedula_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private String telefono_clinete;
	
	public ClienteDTO(int cedula_cliente, String direccion_cliente, String email_cliente, String nombre_cliente,
			String telefono_clinete) {
		this.cedula_cliente = cedula_cliente;
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.nombre_cliente = nombre_cliente;
		this.telefono_clinete = telefono_clinete;
	}

	public ClienteDTO(int cedula_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
	}

	public int getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTelefono_clinete() {
		return telefono_clinete;
	}

	public void setTelefono_clinete(String telefono_clinete) {
		this.telefono_clinete = telefono_clinete;
	}
	
}
