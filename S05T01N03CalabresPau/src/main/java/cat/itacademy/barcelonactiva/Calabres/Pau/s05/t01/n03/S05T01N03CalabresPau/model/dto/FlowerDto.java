package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n03.S05T01N03CalabresPau.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDto {
    private int pk_FlorID;

    private String flowerName;

    private String flowerCountry;
    private String flowerType;
    private static final List<String> UECOUNTRIES =
            new ArrayList<String>(Arrays.asList("Alemania","Austria","Bélgica", "Bulgaria", "Chipre",
                    "Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia", "Finlandia",
                    "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
                    "Malta", "Países Bajo", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public void checkPais(){
        if(UECOUNTRIES.contains(this.flowerCountry)){
            this.flowerType = "UE";
        } else {
            this.flowerType = "NO UE";
        }
    }
}