
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
        
        String sql= "SELECT p.Tipo_documento AS "Tipo de documento",
    p.Nro_documento AS "Número de documento",
    p.Nombre_completo AS "Nombre del paciente",
    p.Edad AS "Edad del paciente",
    p.Genero AS "Género del paciente",
    d.Fecha AS "Fecha del diagnóstico",
    d.Hora AS "Hora del diagnóstico",
    d.Observaciones AS "Observaciones",
    m.Nombre AS "Nombre del médico"
FROM DIAGNOSTICOS AS d
INNER JOIN PACIENTE AS p ON p.ID_paciente = d.ID_paciente
INNER JOIN MEDICOS AS m ON m.ID_medico = d.ID_medico";
        try(Connection conn =getConnection();
               PreparedStatement ps=conn.prepareStatement(sql);) {
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                int nro_documento=rs.getInt(1);
            
                
                System.out.println("ID: "+Nro_documento);
                
            }rs.close();
            
        }catch (SQLException e){
            System.out.println("Errores: " +e);
        }
    }

    
}
