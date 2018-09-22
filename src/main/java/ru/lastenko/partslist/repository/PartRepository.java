package ru.lastenko.partslist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.lastenko.partslist.entities.Part;

import java.util.List;


public interface PartRepository extends JpaRepository<Part, Integer> {

    Page<Part> findByNameIsLike (String name, Pageable pageable);
    Page<Part> findAllByNecessaryTrue(Pageable pageable);
    Page<Part> findAllByNecessaryFalse(Pageable pageable);
    Part findFirstByNecessaryTrueOrderByCountAsc();

}
