import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EndPointsMovies {

    @SneakyThrows
    private String montarRequest(String categoria) {

        String url = "https://api.themoviedb.org/3/movie/" + categoria + "?api_key=" + PegaChave.chaveFilmes() + "&language=en-US&page=1";
        URI endereco = URI.create(url);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String topRated() {
        return montarRequest("top_rated");
    }

    public String popular() {
        return montarRequest("popular");
    }

}
