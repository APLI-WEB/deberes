/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;


import java.sql.*;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class cabdatos {
 
 public static Connection dbCon()
 {
  Connection con=null;
  String driver="org.postgresql.Driver";
  String url="jdbc:postgresql://localhost:5432/gym";
  String user="postgres";
  String pass="WILLIAM1997";
  try {
   Class.forName(driver);
   con=DriverManager.getConnection(url,user,pass);
  }
  catch(ClassNotFoundException|SQLException e)
  {
   e.printStackTrace();
  }
  return con;
 }

}
