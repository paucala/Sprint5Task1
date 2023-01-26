package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalDto {
    private int pk_SucursalID;
    private String nomSucursal;
    private String paisSucursal;
    private String tipusPais;
    private static final List<String> UECOUNTRIES =
            new ArrayList<String>(Arrays.asList("Alemania","Austria","Bélgica", "Bulgaria", "Chipre",
            "Croacia", "Dinamarca", "España", "Eslovaquia", "Eslovenia", "Estonia", "Finlandia",
            "Francia", "Grecia", "Hungría", "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo",
            "Malta", "Países Bajo", "Polonia", "Portugal", "República Checa", "Rumania", "Suecia"));

    public void checkPais(){
        if(UECOUNTRIES.contains(this.paisSucursal)){
            this.tipusPais = "UE";
        } else {
            this.tipusPais = "NO UE";
        }
    }
}
