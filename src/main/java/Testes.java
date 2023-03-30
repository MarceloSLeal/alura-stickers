import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Testes {

    public static void main(String[] args) throws IOException {

        EndPointsNasa endPointsNasa = new EndPointsNasa();


        String start = "2020-10-15";
        String end = "2020-10-25";
        String corpoJson = "";

        try {
            corpoJson = endPointsNasa.montarRequest(start, end);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<Nasa> lista = objectMapper.readValue(corpoJson, new TypeReference<List<Nasa>>() {});

        for (Nasa nasa : lista) {
            System.out.println(nasa.getTitle() + " " + nasa.getUrl());
        }

//        ChamarGeradorFigurinhas.chamarNasa(lista);


    }
}
