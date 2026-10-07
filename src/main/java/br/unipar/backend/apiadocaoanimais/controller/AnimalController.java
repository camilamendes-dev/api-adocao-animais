package br.unipar.backend.apiadocaoanimais.controller;

import br.unipar.backend.apiadocaoanimais.model.Animal;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
=======
import br.unipar.backend.apiadocaoanimais.repository.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> main
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

<<<<<<< HEAD
    private List<Animal> animais = new ArrayList<>();

    private Long proximoId = 1L;

=======
    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
>>>>>>> main

    // GET - Listar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
<<<<<<< HEAD
        return ResponseEntity.ok(animais);
    }


    // GET - Buscar animal pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {

        for (Animal animal : animais) {

            if (animal.getId().equals(id)) {
                return ResponseEntity.ok(animal);
            }
        }

        return ResponseEntity.notFound().build();
    }


    // POST - Cadastrar novo animal
    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal) {

        animal.setId(proximoId);
        proximoId++;

        animais.add(animal);

        return ResponseEntity.ok(animal);
    }


=======
        return ResponseEntity.ok(animalRepository.findAll());
    }

    // GET - Buscar animal pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable Long id) {
        return animalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Cadastrar novo animal
    // O ID não precisa ser informado: o banco gera automaticamente.
    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal) {
        animal.setId(null);
        Animal animalSalvo = animalRepository.save(animal);
        return ResponseEntity.ok(animalSalvo);
    }

>>>>>>> main
    // PUT - Atualizar animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(
            @PathVariable Long id,
            @RequestBody Animal animalAtualizado) {

<<<<<<< HEAD
        for (Animal animal : animais) {

            if (animal.getId().equals(id)) {

                animal.setNome(animalAtualizado.getNome());
                animal.setEspecie(animalAtualizado.getEspecie());
                animal.setIdade(animalAtualizado.getIdade());
                animal.setPorte(animalAtualizado.getPorte());
                animal.setAdotado(animalAtualizado.getAdotado());

                return ResponseEntity.ok(animal);
            }
        }

        return ResponseEntity.notFound().build();
    }


=======
        return animalRepository.findById(id)
                .map(animal -> {
                    animal.setNome(animalAtualizado.getNome());
                    animal.setEspecie(animalAtualizado.getEspecie());
                    animal.setIdade(animalAtualizado.getIdade());
                    animal.setPorte(animalAtualizado.getPorte());
                    animal.setAdotado(animalAtualizado.getAdotado());

                    return ResponseEntity.ok(animalRepository.save(animal));
                })
                .orElse(ResponseEntity.notFound().build());
    }

>>>>>>> main
    // DELETE - Excluir animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

<<<<<<< HEAD
        for (Animal animal : animais) {

            if (animal.getId().equals(id)) {

                animais.remove(animal);

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }


    // GET - Filtrar animais
=======
        if (!animalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        animalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // GET - Filtrar animais
    // Os três filtros podem ser usados separadamente ou combinados.
>>>>>>> main
    @GetMapping("/filtro")
    public ResponseEntity<List<Animal>> filtrar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String porte,
            @RequestParam(required = false) Boolean adotado) {

<<<<<<< HEAD
        List<Animal> resultado = new ArrayList<>();

        for (Animal animal : animais) {

            boolean corresponde = true;

            if (especie != null &&
                    !animal.getEspecie().equalsIgnoreCase(especie)) {

                corresponde = false;
            }

            if (porte != null &&
                    !animal.getPorte().equalsIgnoreCase(porte)) {

                corresponde = false;
            }

            if (adotado != null &&
                    !animal.getAdotado().equals(adotado)) {

                corresponde = false;
            }

            if (corresponde) {
                resultado.add(animal);
            }
        }

        return ResponseEntity.ok(resultado);
    }
}
=======
        return ResponseEntity.ok(
                animalRepository.filtrar(especie, porte, adotado)
        );
    }
}
>>>>>>> main
