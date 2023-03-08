/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientes;


import java.io.Serializable;

public class clientesbd implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String edad;
	private String email;
        private String usuario;
        private String clave;

	public clientesbd() {
		this.nombre = "";
		this.apellido= "";
                this.edad= "";
		this.email = "";
                this.usuario = "";
		this.clave = "";
	}

	public clientesbd(String nombre, String apellido, String edad, String email, String usuario, String clave) {

		this.nombre = nombre;
                this.apellido= apellido;
		this.edad= edad;
		this.email= email;
                this.usuario = usuario;
		this.clave = clave;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre= nombre;
	}

	public String getapellido() {
		return apellido;
	}

	public void setapellido(String apellido) {
		this.apellido = apellido;
	}

	public String getedad() {
		return edad;
	}

	public void setedad(String edad) {
		this.edad = edad;
	}

        public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
        public String getusuario() {
		return usuario;
	}

	public void setusuario(String usuario) {
		this.usuario= usuario;
	}
	public String getclave() {
		return clave;
	}

	public void setclave(String clave) {
		this.clave = clave;
	}
}
