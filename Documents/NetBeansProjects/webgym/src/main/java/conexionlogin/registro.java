/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionlogin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientes.clientesbd;
import DAO.clisql;

public class registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		clisql usql = new clisql();
		clientesbd e = new clientesbd();
		int result = 0;

		e.setnombre(request.getParameter("nombre"));
		e.setapellido(request.getParameter("apellido"));
                e.setedad(request.getParameter("edad"));
		e.setemail(request.getParameter("email"));
		e.setusuario(request.getParameter("usuario"));
                e.setclave(request.getParameter("clave"));

		try {
			if (usql.checkUser(e)) {
				result = usql.insertData(e);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		if (result != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("Acceso.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("inicio.jsp");
		}
	}
}
