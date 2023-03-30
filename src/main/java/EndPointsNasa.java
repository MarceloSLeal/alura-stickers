import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EndPointsNasa {

    public String montarRequest(String start, String end) throws IOException, InterruptedException {

        String url = "https://api.nasa.gov/planetary/apod?api_key=" + PegaChave.chaveNasa() +
                "&start_date=" + start.toString() + "&end_date=" + end.toString();
        URI endereco = URI.create(url);
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
