/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clientes.clientesbd;
import conexion.cabdatos;

public class clisql {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public int insertData(clientesbd e) throws SQLException {
		int result = 0;
		String insertData = "insert into clientes values(?,?,?,?,?,?)";
		con = cabdatos.dbCon();

		ps = con.prepareStatement(insertData);
		ps.setString(1, e.getnombre());
		ps.setString(2, e.getapellido());
                ps.setString(3, e.getedad());
		ps.setString(4, e.getemail());
                ps.setString(5, e.getusuario());
		ps.setString(6, e.getclave());

		result = ps.executeUpdate();

		con.close();
		return result;
	}

	public boolean userLogin(clientesbd e) throws SQLException {
		String checkData = "Select * from clientes where usuario=? and clave=?";
		con = cabdatos.dbCon();

		ps = con.prepareStatement(checkData);
		ps.setString(1, e.getusuario());
		ps.setString(2, e.getclave());

		rs = ps.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public boolean checkUser(clientesbd e) throws SQLException {
		String checkData = "Select * from clientes where nombre=? and email=?";
		con = cabdatos.dbCon();

		ps = con.prepareStatement(checkData);
		ps.setString(1, e.getnombre());
		ps.setString(2, e.getemail());

		rs = ps.executeQuery();

		if (!rs.next()) {
			return true;
		}
		return false;
	}
	public String[] singleView(clientesbd e) throws ClassNotFoundException, SQLException {
		String data[] = null;
		int count = 0;

		con = cabdatos.dbCon();

		String sql = "select * from clientes where usuario=? and clave=?";

		ps = con.prepareStatement(sql);
		ps.setString(1, e.getusuario());
		ps.setString(2, e.getclave());

		rs = ps.executeQuery();
		count = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			data = new String[count];
			for (int i = 0; i < count; i++) {
				data[i] = rs.getString(i + 1);
			}
		}
		con.close();
		return data;
	}
	public int updateData(clientesbd e) throws SQLException {
		int result = 0;
		String updateData = "update clientes set nombre=?,apellido=?,edad=?,email=?,usuario=? ,clave=? where username=?";
		con = cabdatos.dbCon();

		ps = con.prepareStatement(updateData);
		ps.setString(1, e.getnombre());
                ps.setString(2, e.getapellido());
                ps.setString(3, e.getedad());
		ps.setString(4, e.getemail());
                ps.setString(5, e.getusuario());
		ps.setString(6, e.getclave());
		

		result = ps.executeUpdate();

		con.close();
		return result;
	}

}