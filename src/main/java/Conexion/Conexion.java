
package Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {
    
    private Conexion(){
       
    }
    //Creamos la variable de estado de conecxion de la BD
    private static Connection conexion;
    //Creamos una variable para crear una sola instancia
    private static Conexion instancia;
    //Variables para conectarnos a la BD
    private static final String server = "jdbc:mysql://localhost/bd_registros";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //Metodo para conectarnos a la BD
    public Connection conectar(){ 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection(server,USERNAME,PASSWORD);
        }catch(Exception e){
            System.out.println(e);
        }
        return conexion;
    }
    
    //Metodo para cerrar
    public void cerrarConexion() throws SQLException{
        try{
            conexion.close();
        }catch(Exception e){
            System.out.println(e);
            conexion.close();
        }finally{
            conexion.close();
        }
    }
    
    public static Conexion getInstance(){
        if(instancia==null){
            instancia=new Conexion();
        }
        return instancia;
    }
}
