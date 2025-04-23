
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
    
     public void mostrarDatos() {
    String sql = "SELECT p.Tipo_documento AS \"Tipo de documento\", "
            + "p.Nro_documento AS \"Número de documento\", "
            + "p.Nombre_completo AS \"Nombre del paciente\", "
            + "p.Edad AS \"Edad del paciente\", "
            + "p.Genero AS \"Género del paciente\", "
            + "d.Fecha AS \"Fecha del diagnóstico\", "
            + "d.Hora AS \"Hora del diagnóstico\", "
            + "d.Observaciones AS \"Observaciones\", "
            + "m.Nombre AS \"Nombre del médico\" "
            + "FROM DIAGNOSTICOS AS d "
            + "INNER JOIN PACIENTE AS p ON p.ID_paciente = d.ID_paciente "
            + "INNER JOIN MEDICOS AS m ON m.ID_medico = d.ID_medico";

    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            String tipoDocumento = rs.getString(1);
            int nroDocumento = rs.getInt(2);
            String nombrePaciente = rs.getString(3);
            int edadPaciente = rs.getInt(4);
            String generoPaciente = rs.getString(5);
            Date fechaDiagnostico = rs.getDate(6);
            Time horaDiagnostico = rs.getTime(7);
            String observaciones = rs.getString(8);
            String nombreMedico = rs.getString(9);

            System.out.println("\n--- Registro ---");
            System.out.println("Tipo documento: " + tipoDocumento);
            System.out.println("Numero documento: " + nroDocumento);
            System.out.println("Nombre paciente: " + nombrePaciente);
            System.out.println("Edad: " + edadPaciente);
            System.out.println("Genero: " + generoPaciente);
            System.out.println("Fecha diagnostico: " + fechaDiagnostico);
            System.out.println("Hora diagnostico: " + horaDiagnostico);
            System.out.println("Observaciones: " + observaciones);
            System.out.println("Medico: " + nombreMedico);
        }

    } catch (SQLException e) {
        System.out.println("Error al mostrar datos:" +e);
    }

    }

    public void actualizarDatos(String Nombre, String pass, int IDmedico, int IDusuario){
        String sql ="UPDATE USUARIOS set Nombre =?, pass=?, ID_medico=? WHERE id=?";
        
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setString(1, Nombre);
            ps.setString(2, Pass);
            ps.setInt(3, ID_medico);
            ps.setInt(4, ID_usuario);
            ps.executeUpdate();
            System.out.println("Dato actualizado.");
            ps.close();
            
        }catch (SQLException e){
            System.out.println("Errores: " +e);
        }
            
            
    }   

    public void borrarDatos(int IDusuario){
        String sql ="DELETE FROM USUARIOS WHERE id=?";
        
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);){
            ps.setInt(1, IDusuario);
            ps.executeUpdate();
            System.out.println("Registro Borrado.");
            ps.close();

        }catch (SQLException e){
            System.out.println("Errores: " +e);
        }
            
            
    }
}
