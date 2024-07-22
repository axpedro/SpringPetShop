package br.com.pedro.demo.repositories;

import br.com.pedro.demo.models.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PetRepository {
    private PetRepository petRepository;
    private static List<Pet> ListaDePets = new ArrayList<>();
    private static int ultimoId;

    public List<Pet> listar() {
        return ListaDePets;
    }
    public  void addPet(Pet pet) {
        pet.setId(++ultimoId);
        ListaDePets.add(pet);
    }
    public void removePet(Pet pet){
        ListaDePets.remove(pet);
    }
    public Pet buscaPet(int id){

        return ListaDePets.stream().filter(pet -> id == pet.getId()).findFirst().orElse(null);
    }

}
