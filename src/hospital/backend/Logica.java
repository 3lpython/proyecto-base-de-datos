
package hospital.backend;
import java.sql.*;

public class Logica {

    public static final String url ="jdbc:mysql://localhost:3306/BDhospital";
    public static final String user="root";
    public static final String password="12345";

    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    
    public void insertarDatos(String Nombre, String pass, int IDmedico){
        
        String sql="INSERT INTO USUARIOS (Nombre, pass, ID_medico) VALUES (?, ?, ?)";
        try(Connection conn=getConnection();
                    PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setString(1, Nombre);
            ps.setString(2, Pass);
            ps.setString(3, ID_medico);
            
            ps.executeUpdate();
            System.out.println("Dato insertado");
            
        }catch (SQLException e){
            System.out.println("Errores: " +e);
        }
    }
    
    public void mostrarDatos(){
        
        String sql= "SELECT * FROM platos";
        try(Connection conn =getConnection();
               PreparedStatement ps=conn.prepareStatement(sql);) {
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int id=rs.getInt(1);
                String nombre=rs.getString(2);
                
                System.out.println("ID: "+id+ "Nombre:" +nombre);
                
            }rs.close();
            
        }catch (SQLException e){
            System.out.println("Errores: " +e);
        }
    }

    
}
