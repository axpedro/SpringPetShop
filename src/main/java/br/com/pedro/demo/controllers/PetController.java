package br.com.pedro.demo.controllers;

import br.com.pedro.demo.models.Pet;
import br.com.pedro.demo.services.PetServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;



@RestController
@RequestMapping("/pets")
public class PetController {

    private PetServices petService;

    public PetController (PetServices petService){

        this.petService = petService;
    }

    @PostMapping()
    public void cadastra(@RequestBody Pet pet){
        //invocar cadastro pet
        petService.cadastrar(pet);
    }

    @GetMapping()
    public List<Pet> busca(){
        var pets = petService.listar();
       if(pets.isEmpty()){
           //return 404
           return null;
       }
       else {
           return pets;
       }
       //return petService.listar();

    }
    @GetMapping("/{id}")
    public Pet busca(@PathVariable int id){

        return petService.buscar(id);

    }

    @DeleteMapping("/{id}")
    public String deletaPet(@PathVariable int id){

       return petService.excluir(id) ? "Excluido com sucesso. "
               : String.format("Não foi encontrado o pet: %d.", id);
    }


    @PutMapping
    public String atualizar(@RequestBody Pet pet){

            return petService.atualizar(pet) ? "Atualizado com sucesso"
                    : String.format("Não foi encontrado o pet: %d.", pet.getId());

    }
}
