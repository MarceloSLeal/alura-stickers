import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ChamarGeradorFigurinhas {

    public static void chamarFilmes(List<Filmes> lista) throws IOException {

        GeradorFigurinhas geradorFigurinhas = new GeradorFigurinhas();

        for (Filmes filmes : lista) {

            String urlImagem = "https://image.tmdb.org/t/p/w500" + filmes.getPath();
            InputStream inputStream = new URL(urlImagem).openStream();
            String pathSaida = "src/main/resources/imagens/saida/" + filmes.getTitle() + ".png";
            String title = filmes.getTitle();

            geradorFigurinhas.criar(inputStream, title, pathSaida);

        }
    }

    public static void chamarNasa(List<Nasa> lista) throws IOException {

        GeradorFigurinhas geradorFigurinhas = new GeradorFigurinhas();

        for (Nasa nasa : lista) {

            String urlImagem = nasa.getUrl();
            InputStream inputStream = new URL(urlImagem).openStream();
            String pathSaida = "src/main/resources/imagens/saida/" + nasa.getTitle() + ".png";
            String title = nasa.getTitle();

            geradorFigurinhas.criar(inputStream, title, pathSaida);

        }
    }

}
