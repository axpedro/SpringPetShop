package br.com.pedro.demo.services;

import br.com.pedro.demo.models.Pet;
import br.com.pedro.demo.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//aqui trata os dados, faz o meio de campo
@Service
public class PetServices {
    private final PetRepository petRepository;

    public PetServices(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void cadastrar(Pet pet) {
        petRepository.addPet(pet);
    }

    public List<Pet> listar() {
        return petRepository.listar();
    }

    public Pet buscar(int id) {

        return petRepository.buscaPet(id);
    }

    public boolean excluir(int id) {
        Pet petExcluir = petRepository.buscaPet(id);
        if(petExcluir != null) {
            petRepository.removePet(petExcluir);
            return true;
        }
        return false;
    }

    public boolean atualizar(Pet pet) {
        var petAtualizar = petRepository.buscaPet(pet.getId());
        if(petAtualizar != null){
            petAtualizar.setNome(pet.getNome());
            petAtualizar.setRaca(pet.getRaca());
            petAtualizar.setAltura(pet.getAltura());
            petAtualizar.setEspecie(pet.getEspecie());
            petAtualizar.setPeso(pet.getPeso());
            petAtualizar.setDataNascimento(pet.getDataNascimento());
            return true;

        }
        return false;

    }
}
