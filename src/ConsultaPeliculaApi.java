import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPeliculaApi {
    public Pelicula buscarPelicula(int numero){
        URI direccion = URI.create("https://swapi.dev/api/films/"+numero+"/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {

            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);

        } catch (Exception e) {
            throw new RuntimeException("no encontre esta pelicula!");
        }




    }
}
