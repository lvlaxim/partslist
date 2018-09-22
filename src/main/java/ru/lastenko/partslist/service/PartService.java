package ru.lastenko.partslist.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.lastenko.partslist.entities.Part;

import java.util.List;

public interface PartService {
    Part getPartById(Integer id);
    void savePart(Part part);
    void updatePart(Integer id, String name, Boolean necessary, Integer count);
    void deletePart(Integer id);
    /*
    List<Part> findAll();
    List<Part> findNecessary();
    List<Part> findOptional();
    //List<Part> findByName(String pattern);
    */
    Page<Part> findAllPaged(Pageable pageable);
    Page<Part> findNecessaryPaged(Pageable pageable);
    Page<Part> findOptionalPaged(Pageable pageable);
    Page<Part> findByNamePaged(String pattern, Pageable pageable);
    Part findNecessaryPart();

}
