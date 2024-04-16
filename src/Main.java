import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        try {
            System.out.println("Ingrese el numero de la pelicula de Start Wors: ");
            var numero = Integer.valueOf(leer.next());

            ConsultaPeliculaApi consulta = new ConsultaPeliculaApi();
            Pelicula pelicula = consulta.buscarPelicula(numero);
            GeneradorDeArchivo generarArchivo = new GeneradorDeArchivo();
            generarArchivo.guardarJson(pelicula);
            System.out.println(pelicula);
        }catch (NumberFormatException e){
            System.out.println("No ingreso un mumero "+ e.getMessage());
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la aplicación!");
        }
    }
}