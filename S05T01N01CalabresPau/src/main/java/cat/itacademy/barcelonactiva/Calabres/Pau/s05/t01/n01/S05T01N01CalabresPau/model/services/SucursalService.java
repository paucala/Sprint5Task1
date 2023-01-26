package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.services;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.repository.SucursalRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepo sucursalRepo;


    public Sucursal createSucursal(Sucursal sucursal){

        return sucursalRepo.save(sucursal);
    }
    public void deleteSucursal(int id){
        sucursalRepo.deleteById(id);
    }
    public Sucursal getSucursalById(int id) {
        Optional<Sucursal> optionalSucursal = sucursalRepo.findById(id);
        Sucursal sucursal = null;
        if(optionalSucursal.isPresent()){
            sucursal = optionalSucursal.get();
        }else {
            throw new RuntimeException(" Sucursal no trobada per la id: " + id);
        }
        return sucursal;
    }
    public List<Sucursal> getAllSucursals(){
        return sucursalRepo.findAll();
    }

}
