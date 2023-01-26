package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sucursals")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_SucursalID;

    //@Column(name = "nom")
    private String nomSucursal;

    //@Column(name = "país")
    private String paisSucursal;





}
