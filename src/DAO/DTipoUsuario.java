package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Conexion.*;
import Entidades.*;


public class DTipoUsuario 
{
    public static Connection cn = null;
    public static Statement statement;
    
    
    public DTipoUsuario() throws ClassNotFoundException, SQLException
    {
         cn=ConexionSQL.getConnection();
         statement=cn.createStatement();
    }
    
    public ResultSet ListarTipoUsuario()
    {
      try
      {
        ResultSet rpta=statement.executeQuery("select * from TTipoUsuario");
        return rpta;
      }
      catch(SQLException e)
      {
          JOptionPane.showMessageDialog(null, e.toString(),"Conexión SQL",JOptionPane.INFORMATION_MESSAGE);
          return null;
      }
    }
    public ResultSet Buscar(String termino)
    {
       try
       {
         String vsql="select * from TTipoUsuario where tu_Descripcion like '"+ termino  +"%'";
         ResultSet rpta=statement.executeQuery(vsql);
         return rpta;
       }
       catch (SQLException ex)
       {
          JOptionPane.showMessageDialog(null, ex.toString(),"Conexión SQL",JOptionPane.INFORMATION_MESSAGE);
          return null;
       }
    }
    public void Agregar(CTipoUsuario oTU)
    {
      try
      {
          statement.executeQuery("insert into TTipoUsuario (tu_Descripcion) values ('" + oTU.getTu_Descripcion() + "')");
      }
      catch(SQLException ex)
      {
          JOptionPane.showMessageDialog(null, ex.toString(),"Operación en la BD",JOptionPane.INFORMATION_MESSAGE);
      }
    }   
    
    public void Modificar(CTipoUsuario oTU)
    {
       try
       {
         statement.executeQuery("update TTipoUsuario set tu_Descripcion='" + oTU.getTu_Descripcion() + "' where idTipoUsuario=" + oTU.getIdTipoUsuario());
       }
       catch (SQLException ex)
       {
          JOptionPane.showMessageDialog(null, ex.toString(),"Operación en la BD",JOptionPane.INFORMATION_MESSAGE);
       }
    }
    public void Eliminar(int codigo)
    {
      try
       {
         statement.executeQuery("delete from TTipoUsuario where idTipoUsuario=" + codigo);
       }
       catch (SQLException ex)
       {
          JOptionPane.showMessageDialog(null, ex.toString(),"Operación en la BD",JOptionPane.INFORMATION_MESSAGE);
       }
    }
}
