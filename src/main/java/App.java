import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        EndPointsMovies endPointsMovies = new EndPointsMovies();
        String corpoJson = endPointsMovies.topRated();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode resultsNode = objectMapper.readTree(corpoJson).get("results");

        List<Filmes> filmes = new ArrayList<>();

        filmes = CriarListaFilmes.criarLista(corpoJson);

        for (Filmes film : filmes) {
            System.out.println(film.getId() + " : " + film.getTitle() + " : " + film.getVote() + " : " + film.getPath());
        }

        ChamarGeradorFigurinhas.chamarFilmes(filmes);

    }
}
