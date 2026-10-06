package br.unipar.backend.apiadocaoanimais.repository;

import br.unipar.backend.apiadocaoanimais.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("""
            SELECT a FROM Animal a
            WHERE (:especie IS NULL OR LOWER(a.especie) = LOWER(:especie))
              AND (:porte IS NULL OR LOWER(a.porte) = LOWER(:porte))
              AND (:adotado IS NULL OR a.adotado = :adotado)
            """)
    List<Animal> filtrar(
            @Param("especie") String especie,
            @Param("porte") String porte,
            @Param("adotado") Boolean adotado);
}
