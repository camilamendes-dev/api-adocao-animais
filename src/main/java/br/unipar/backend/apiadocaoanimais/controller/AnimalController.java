package br.unipar.backend.apiadocaoanimais.controller;

import br.unipar.backend.apiadocaoanimais.model.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private List<Animal> animais = new ArrayList<>();

    private Long proximoId = 1L;


    // GET - Listar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
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


    // PUT - Atualizar animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(
            @PathVariable Long id,
            @RequestBody Animal animalAtualizado) {

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


    // DELETE - Excluir animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        for (Animal animal : animais) {

            if (animal.getId().equals(id)) {

                animais.remove(animal);

                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }


    // GET - Filtrar animais
    @GetMapping("/filtro")
    public ResponseEntity<List<Animal>> filtrar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String porte,
            @RequestParam(required = false) Boolean adotado) {

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