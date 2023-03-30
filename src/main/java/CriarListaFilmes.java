import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CriarListaFilmes {

    public static List<Filmes> criarLista(String corpo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode resultsNode = objectMapper.readTree(corpo).get("results");

        List<Filmes> filmes = new ArrayList<>();

        for (JsonNode movieNode : resultsNode) {
            Integer id = movieNode.get("id").asInt();
            String title = movieNode.get("title").asText();
            Double vote = movieNode.get("vote_average").asDouble();
            String path = movieNode.get("backdrop_path").asText();

            filmes.add(new Filmes(id, title, vote, path));
        }

        return filmes;
    }
}
