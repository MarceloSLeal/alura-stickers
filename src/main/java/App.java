import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {


        EndPointsMovies endPointsMovies = new EndPointsMovies();
        String corpoJson = endPointsMovies.topRated();

        ObjectMapper objectMapper = new ObjectMapper();


        JsonNode resultsNode = objectMapper.readTree(corpoJson).get("results");

        List<Filmes> filmes = new ArrayList<>();

        GeradorFigurinhas geradorFigurinhas = new GeradorFigurinhas();
        for (JsonNode movieNode : resultsNode) {
            Integer id = movieNode.get("id").asInt();
            String title = movieNode.get("title").asText();
            Double vote = movieNode.get("vote_average").asDouble();
            String path = movieNode.get("backdrop_path").asText();

            filmes.add(new Filmes(id, title, vote, path));

            String urlImagem = "https://image.tmdb.org/t/p/w500" + path;
            InputStream inputStream = new URL(urlImagem).openStream();
            String pathSaida = "src/main/resources/imagens/saida/" + title + ".png";

            geradorFigurinhas.criar(inputStream, title, pathSaida);

            System.out.println(title);

        }

//        for (Filmes film : filmes) {
//            System.out.println(film.getId() + " : " + film.getTitle() + " : " + film.getVote() + " : " + film.getPath());
//        }

    }
}
