
package hospital.backend;
import java.sql.*;

public class Logica {

    public static final String url ="jdbc:mysql://localhost:3306/BDhospital";
    public static final String user="root";
    public static final String password="12345";

    public Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
    
    public void insertarDato(String nombre){
        
        String sql=" INSERT INTO platos(nombre) VALUES(?)";
        try(Connection conn=getConnection();
                    PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setString(1,nombre);
            ps.executeUpdate();
            System.out.println("Dato insertado");
            ps.close();
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
