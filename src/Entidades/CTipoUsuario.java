package Entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CTipoUsuario 
{
    private int idTipoUsuario;
    private String tu_Descripcion;
    
    public static Connection cn = null;
    public static Statement statement;
    
    
    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTu_Descripcion() {
        return tu_Descripcion;
    }

    public void setTu_Descripcion(String tu_Descripcion) {
        this.tu_Descripcion = tu_Descripcion;
    }
}
