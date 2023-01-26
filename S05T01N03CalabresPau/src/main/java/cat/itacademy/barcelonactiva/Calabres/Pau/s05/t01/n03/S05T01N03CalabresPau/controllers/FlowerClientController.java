package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n03.S05T01N03CalabresPau.controllers;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n03.S05T01N03CalabresPau.model.domain.Flower;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n03.S05T01N03CalabresPau.model.dto.FlowerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FlowerClientController {


    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:9001/flowers")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

    @GetMapping("/getAll")
    public ResponseEntity<Flux<Flower>> getAll()
    {
        Flux<FlowerDto> flowerFlux = webClient.get()
                .uri("/getAll")
                .retrieve()
                .bodyToFlux(FlowerDto.class);
        return  new ResponseEntity(flowerFlux, HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<Flower>> getPost(@PathVariable int id) {

        Mono<Flower> postMono = webClient.get()
                .uri("/getOne/" + id)
                .retrieve()
                .bodyToMono(Flower.class);

        return new ResponseEntity(postMono, HttpStatus.OK);
    }

    @PostMapping(path="/add", consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public Mono<Flower> createPost(@RequestBody Flower flower) {

        return webClient.post()
                .uri("/add")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(flower))
                .retrieve()
                .bodyToMono(Flower.class);
    }

    @PutMapping(path="/update/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public Mono<Flower> updatePost(@RequestBody Flower flower, @PathVariable int id) {

        return webClient.put()
                .uri("/update/" + id)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BodyInserters.fromValue(flower))
                .retrieve()
                .bodyToMono(Flower.class);
    }

    @DeleteMapping(path="/v1/post/{id}")
    public Mono<Flower> deletePost(@PathVariable int id) {

        return webClient.delete()
                .uri("/delete/" + id)
                .retrieve()
                .bodyToMono(Flower.class);
    }
}
