
package hospital;
import java.sql.*;
import hospital.backend.Logica;
import java.util.Scanner;

public class Hospital {

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logica Lo = new Logica();

       // Insertar dato
       System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la password: ");
        String Pass = sc.nextLine();

        System.out.print("Ingrese el ID del medico: ");
        int IDmedico = sc.nextInt();
        sc.nextLine();

       Lo.insertarDatos(nombre, Pass, IDmedico);

       // Actualizar Dato
       System.out.println("Digite el nuevo nombre de usuario: ");
       String NuevoNombre = sc.nextLine();
       
       System.out.println("Digite la nueva password: ");
       String Nuevopass = sc.nextLine();
       
       System.out.println("Digite el nuevo ID del medico: ");
       int NuevoIDmedico = Integer.parseInt(sc.nextLine());
       
       System.out.println("Digite el ID del usuario: ");
       int ActualizarIDusuario = Integer.parseInt(sc.nextLine());

       Lo.actualizarDatos(NuevoNombre, Nuevopass, NuevoIDmedico, ActualizarIDusuario);

       // Borrar dato
       System.out.println("Digite el ID del usuario a borrar: ");
       int BorrarIDusuario = Integer.parseInt(sc.nextLine());

       Lo.borrarDatos(BorrarIDusuario);
       //Mostrar dato
       Lo.mostrarDatos();

       
    }
    
}
