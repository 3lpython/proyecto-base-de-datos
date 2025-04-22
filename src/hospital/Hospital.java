
package hospital;
import Backend.Logica;

public class Hospital {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logica con = new Conexion();

       String Nombre = sc.newline();
       String Contraseña = sc.newline();
       int ID_medico = sc.newline();

       con.InsertarDatos(Nombre, contraseña, ID_medico);
    }
    
}
