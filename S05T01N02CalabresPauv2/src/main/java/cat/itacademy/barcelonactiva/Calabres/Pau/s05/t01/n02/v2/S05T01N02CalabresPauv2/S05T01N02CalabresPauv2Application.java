package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n02.v2.S05T01N02CalabresPauv2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class S05T01N02CalabresPauv2Application {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(S05T01N02CalabresPauv2Application.class, args);
	}

}
