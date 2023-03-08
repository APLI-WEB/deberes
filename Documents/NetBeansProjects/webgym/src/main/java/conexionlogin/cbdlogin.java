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
import javax.servlet.http.HttpSession;

import clientes.clientesbd;
import DAO.clisql;


public class cbdlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clientesbd e = new clientesbd();
		 clisql usql=new clisql();
		 String[] data=null;
		 HttpSession session=request.getSession();
		 e.setusuario(request.getParameter("usuario"));
		 e.setclave(request.getParameter("clave"));
		 
		 try
		 {
		 if(usql.userLogin(e))
		 {
			 data=usql.singleView(e);
			 e.setnombre(data[1]);
			 session.setAttribute("nombre",e.getnombre());
			 session.setAttribute("usuario", e.getusuario());
			 session.setAttribute("clave", e.getclave());
			 RequestDispatcher rd=request.getRequestDispatcher("inicio.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 response.sendRedirect("Acceso.jsp");
			 session.setAttribute("ErrorMessage","Login Failed");
		 }
	}catch(SQLException|ClassNotFoundException ex)
		 {
			ex.printStackTrace();
		 }
		 }

}
