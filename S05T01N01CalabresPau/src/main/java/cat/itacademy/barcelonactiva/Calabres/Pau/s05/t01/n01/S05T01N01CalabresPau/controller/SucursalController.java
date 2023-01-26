package cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.controller;

import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.Calabres.Pau.s05.t01.n01.S05T01N01CalabresPau.model.services.SucursalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    public String viewHomePage(Model model) {
        model.addAttribute("listSucursals",
                sucursalService.getAllSucursals().stream().map(sucursal -> modelMapper.map(sucursal, SucursalDto.class))
                        .collect(Collectors.toList()));
        return "index";
    }
    @GetMapping("/getOne/{id}")
    public String viewOnlyONe(Model model, @PathVariable(value = "id") int id) {
        SucursalDto sucursalDto = modelMapper.map(sucursalService.getSucursalById(id), SucursalDto.class);
        sucursalDto.checkPais();
        model.addAttribute("sucursal", sucursalDto);
        return "unaSucursal";
    }
    @GetMapping("/ShowNewSucursalForm")
    public String showNewSucursalForm(Model model) {
        // create model attribute to bind form data
        SucursalDto sucursalRequested = new SucursalDto();
        model.addAttribute("sucursal", sucursalRequested);
        return "new_sucursal";
    }
    @PostMapping("/add")
    public String createSucursal(@ModelAttribute("sucursal") SucursalDto sucursalDto) {
        // save sucursal to database
        Sucursal sucursalRequested = modelMapper.map(sucursalDto, Sucursal.class);
        sucursalService.createSucursal(sucursalRequested);
        return "redirect:/getAll";
    }
    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get sucursal from the service
        SucursalDto sucursalRequested = modelMapper.map(sucursalService.getSucursalById(id), SucursalDto.class);

        // set sucursal as a model attribute to pre-populate the form
        model.addAttribute("sucursal", sucursalRequested);
        return "update_employee";
    }
    @GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable(value = "id") int id) {

        // call delete sucursal method
        this.sucursalService.deleteSucursal(id);
        return "redirect:/getAll";
    }
}

