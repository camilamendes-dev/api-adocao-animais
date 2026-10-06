package br.unipar.backend.apiadocaoanimais.controller;

import br.unipar.backend.apiadocaoanimais.model.Animal;
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

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    // GET - Listar todos os animais
    @GetMapping
    public ResponseEntity<List<Animal>> listarTodos() {
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

    // PUT - Atualizar animal
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(
            @PathVariable Long id,
            @RequestBody Animal animalAtualizado) {

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

    // DELETE - Excluir animal
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!animalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        animalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // GET - Filtrar animais
    // Os três filtros podem ser usados separadamente ou combinados.
    @GetMapping("/filtro")
    public ResponseEntity<List<Animal>> filtrar(
            @RequestParam(required = false) String especie,
            @RequestParam(required = false) String porte,
            @RequestParam(required = false) Boolean adotado) {

        return ResponseEntity.ok(
                animalRepository.filtrar(especie, porte, adotado)
        );
    }
}
