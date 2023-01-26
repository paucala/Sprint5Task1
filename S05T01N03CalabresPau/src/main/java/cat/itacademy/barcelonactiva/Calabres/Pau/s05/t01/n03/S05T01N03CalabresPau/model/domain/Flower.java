package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n03.S05T01N03CalabresPau.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {


    private int pk_FlorID;

    private String flowerName;

    private String flowerCountry;


}
