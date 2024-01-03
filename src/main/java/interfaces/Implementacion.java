
package interfaces;

import java.sql.*;
import Conexion.Conexion;
import enfermedades.Enfermedad;
import java.sql.PreparedStatement;
public class Implementacion implements Metodos {
    
    Conexion conexion = Conexion.getInstance();
    @Override
    public void registrar(Enfermedad enfermedad) {
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement insertar = conectar.prepareStatement("insert into enfermedades values(?,?,?,?)");
            insertar.setString(1,enfermedad.getCodigo());
            insertar.setString(2, enfermedad.getEnfermedad());
            insertar.setInt(3, enfermedad.getAnio());
            insertar.setInt(4, enfermedad.getCasos());
            insertar.executeUpdate();
            conexion.cerrarConexion();
    }catch(SQLException e){
            System.out.println(e);
    }
    }

    @Override
    public void eliminar(Enfermedad enfermedad) {
        try{
            Connection conectar = conexion.conectar();
            PreparedStatement eliminar = conectar.prepareStatement("delete from enfermedades where codigo=?");
            eliminar.setString(1, enfermedad.getCodigo());
            eliminar.executeUpdate();
            conexion.cerrarConexion();
    }catch(SQLException e){
            System.out.println(e);
    }
    }

    @Override
    public void buscar(Enfermedad enfermedad) {
       try{
            Connection conectar = conexion.conectar();
            PreparedStatement buscar = conectar.prepareStatement("select * from enfermedades where codigo=?");
            buscar.setString(1, enfermedad.getCodigo());
            ResultSet consulta = buscar.executeQuery();
            if(consulta.next()){
                enfermedad.setCodigo(consulta.getString("codigo"));
                enfermedad.setAnio(consulta.getInt("año"));
                enfermedad.setCasos(consulta.getInt("casos"));
                enfermedad.setEnfermedad(consulta.getString("nombre"));
            }
            conexion.cerrarConexion();
    }catch(SQLException e){
            System.out.println(e);
    } 
    }
    
}
