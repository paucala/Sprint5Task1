package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.services;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.domain.Flower;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.repository.FlowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepo flowerRepo;


    public Flower createFlower(Flower flower){

        return flowerRepo.save(flower);
    }
    public void deleteFlower(int id){
        flowerRepo.deleteById(id);
    }
    public Flower getFlowerById(int id) {
        Optional<Flower> optionalFlower = flowerRepo.findById(id);
        Flower flower = null;
        if(optionalFlower.isPresent()){
            flower = optionalFlower.get();
        }else {
            throw new RuntimeException(" Couldn't find flower on id: " + id);
        }
        return flower;
    }
    public List<Flower> getAllFlowers(){
        return flowerRepo.findAll();
    }
    public boolean existsById (int id){
        return flowerRepo.existsById(id);
    }
    public Flower updateFlower(Flower flower){
        Flower newFlower = flowerRepo.findById(flower.getPk_FlorID()).get();
        newFlower.setFlowerName(flower.getFlowerName());
        newFlower.setFlowerCountry(flower.getFlowerCountry());
        flowerRepo.save(newFlower);
        return newFlower;

    }
}