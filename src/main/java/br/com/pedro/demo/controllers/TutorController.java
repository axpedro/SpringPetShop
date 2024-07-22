package br.com.pedro.demo.controllers;


import br.com.pedro.demo.models.Pet;
import br.com.pedro.demo.models.Tutor;
import br.com.pedro.demo.services.PetServices;
import br.com.pedro.demo.services.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    private TutorService tutorService;

    public TutorController (TutorService tutorService){

        this.tutorService = tutorService;
    }

    @PostMapping()
    public void cadastra(@RequestBody Tutor tutor){
        //invocar cadastro do tutor

        tutorService.cadastrar(tutor);
    }

    @GetMapping()
    public List<Tutor> busca(){
        var tutores = tutorService.listar();
        if(tutores.isEmpty()){
            //return 404
            return null;
        }
        else {
            return tutores;
        }


    }
    @GetMapping("/{id}")
    public Tutor busca(@PathVariable int id){

        return tutorService.buscar(id);

    }

    @DeleteMapping("/{id}")
    public String deletaTutor(@PathVariable int id){

        return tutorService.excluir(id) ? "Excluido com sucesso. "
                : String.format("Não foi encontrado o tutor: %d.", id);
    }


    @PutMapping
    public String atualizar(@RequestBody Tutor tutor){

        return tutorService.atualizar(tutor) ? "Atualizado com sucesso"
                : String.format("Não foi encontrado o tutor: %d.", tutor.getId());

    }



}
