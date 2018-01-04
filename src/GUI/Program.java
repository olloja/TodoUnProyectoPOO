package GUI;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.*;
import DAO.*;
import java.util.Scanner;
public class Program
{
   public static void main(String[] args) throws ClassNotFoundException, SQLException
   {
       Scanner lector = new Scanner(System.in);
       String opcion="";
       ResultSet rs;
       System.out.println("PROGRAMA!!!!!!!!!!!!!");
       CTipoUsuario oTipoUsuario = new CTipoUsuario();
       DTipoUsuario DAO_Tu = new DTipoUsuario();
       Menus.MenuGral();
       opcion=lector.next();
       while(opcion!="8")
       {
           switch (opcion)
           {
               case "1"://Listar
               {
                  rs=DAO_Tu.ListarTipoUsuario();
                  try
                  {
                     while(rs.next())
                     {
                        System.out.println(rs.getInt(1)+ " " + rs.getString(2));
                     }
                  }
                  catch(SQLException ex)
                  {}
                  break;
               }
               case "2"://Buscar
               {
                  System.out.println("Ingrese un tipo de usuario a buscar:"); 
                  String tuBuscar=lector.next();
                  rs=DAO_Tu.Buscar(tuBuscar);
                  try
                  {
                      while (rs.next())
                      {
                         System.out.println(rs.getInt(1) + " " + rs.getString(2));
                      }
                  }
                  catch(SQLException ex)
                  {}
                  break;
               }
                       
               case "3"://Agregar
               {
                  System.out.println("Ingrese un tipo de usuario:"); 
                  oTipoUsuario.setTu_Descripcion(lector.next());
                  DAO_Tu.Agregar(oTipoUsuario);
                  break;
               }
               case "4"://Modificar
               {
                  System.out.println("Ingrese el Id de tipo usuario a modificar:"); 
                  oTipoUsuario.setIdTipoUsuario(lector.nextInt());
                  System.out.println("Ingrese la descripción del tipo de usuario:"); 
                  oTipoUsuario.setTu_Descripcion(lector.next());
                  DAO_Tu.Modificar(oTipoUsuario);
                  break;
               }
               case "5"://Eliminar
               {
                  System.out.println("Ingrese el Id de tipo usuario a eliminar:"); 
                  oTipoUsuario.setIdTipoUsuario(lector.nextInt());
                  DAO_Tu.Eliminar(oTipoUsuario.getIdTipoUsuario());
                  break;
               
               }
               case "6"://Buscar
               {
                  break;
               }    
               case "7"://Salir
               {
                  opcion="8";
               }
           }
           Menus.MenuGral();
           opcion=lector.next();
       }
   }
}
