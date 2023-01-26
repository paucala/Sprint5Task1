package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "flowers")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_FlorID;
    @NotNull
    private String flowerName;

    private String flowerCountry;


}
