
package hospital;
import hospital.Backend.Logica;
import java.ulti.Scanner;

public class Hospital {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logica Lo = new Logica();

       String Nombre = sc.newline();
       String Pass = sc.newline();
       int IDmedico = sc.newline();

       con.InsertarDatos(Nombre, Pass, IDmedico);

       // Actualizar Dato
       System.out.println("Digite el nuevo nombre de usuario: ");
       String nombre = sc.next();
       System.out.println("Digite la nueva password: ");
       String pass = sc.next();
       System.out.println("Digite el nuevo IDmedico: ");
       int IDmedico = sc.next();
       System.out.println("Digite el ID del usuario: ");
       int IDusuario = sc.next();

       con.actualizarDato(nombre,pass,IDmedico,IDusuario);

       // Borrar dato
       System.out.println("Digite el ID del usuario a borrar: ");
       int IDusuario = sc.next();

       con.borrarDato(IDusuario);

       
    }
    
}
