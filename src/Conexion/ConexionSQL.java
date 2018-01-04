
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionSQL 
{
    public static String servidor="localhost";
    public static String puerto="1433";
    public static String usuario="sa";
    public static String pwd="omar";
    public static String baseDatos="Biblioteca2";
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection cn = null;
    public static Connection getConnection() throws ClassNotFoundException
    {
       try
       {
          Class.forName(driver);
          String cadena="jdbc:sqlserver://"+servidor+":"+puerto+";"+"databaseName="+baseDatos+";user="+usuario+";password="+pwd+";";
          cn =DriverManager.getConnection(cadena);
          JOptionPane.showMessageDialog(null, "Conexión correcta a SQL Server 2014.","Conexión SQL",JOptionPane.INFORMATION_MESSAGE);
       }
       catch(SQLException e)
       {
         JOptionPane.showMessageDialog(null, e.toString(),"Conexión SQL",JOptionPane.INFORMATION_MESSAGE);
       }
       return cn;
    }     
}
