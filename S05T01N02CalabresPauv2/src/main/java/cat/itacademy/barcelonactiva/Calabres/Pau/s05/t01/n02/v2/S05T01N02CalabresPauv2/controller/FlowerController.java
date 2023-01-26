package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.controller;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.domain.Flower;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.dto.FlowerDto;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2.model.services.FlowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FlowerService flowerService;

    @PostMapping("/add")
    public ResponseEntity<FlowerDto> createFruit(@RequestBody FlowerDto flowerDto){
        try {
            flowerService.createFlower(modelMapper.map(flowerDto, Flower.class));
            return new ResponseEntity<>(flowerDto, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<FlowerDto> updateFruit(@PathVariable("id") int id, @RequestBody FlowerDto flowerDto) {
        if (flowerService.existsById(modelMapper.map(flowerDto, Flower.class).getPk_FlorID())){
            flowerService.updateFlower(modelMapper.map(flowerDto, Flower.class));
            return new ResponseEntity<>(flowerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") int id) {
        try{
            if (flowerService.existsById(id)){
                flowerService.deleteFlower(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getOne/{id}")
    public  ResponseEntity<FlowerDto> getFruitbyId(@PathVariable("id") int id) {

        if(flowerService.existsById(id)) {
            FlowerDto flowerDto = modelMapper.map(flowerService.getFlowerById(id), FlowerDto.class);
            flowerDto.checkPais();
            return new ResponseEntity<>(flowerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<FlowerDto>> getAllFruits() {
        try {
            List<FlowerDto> flowers = flowerService.getAllFlowers().stream().map
                    (flower -> modelMapper.map(flower, FlowerDto.class)).collect(Collectors.toList());
            //flowers.forEach(f -> f.checkPais());
            if (flowers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(flowers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}