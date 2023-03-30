import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Filmes {

    private Integer id;
    private String title;

    @JsonSetter("vote_average")
    private Double vote;

    @JsonSetter("poster_path")
    private String path;

}
