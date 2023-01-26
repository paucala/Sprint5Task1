package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.repository;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.domain.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepo extends JpaRepository<Flower, Integer> {
}
