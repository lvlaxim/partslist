package ru.lastenko.partslist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lastenko.partslist.entities.Part;
import ru.lastenko.partslist.repository.PartRepository;


import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private PartRepository repository;

    @Autowired
    public void setProductRepository(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Part getPartById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void savePart(Part part) {
        repository.save(part);
    }

    @Override
    public void updatePart(Integer id, String name, Boolean necessary, Integer count) {
        Part updated = repository.getOne(id);
        updated.setName(name);
        updated.setNecessary(necessary);
        updated.setCount(count);
        repository.save(updated);
    }

    @Override
    public void deletePart(Integer id) {
        repository.deleteById(id);
    }
/*
    @Override
    public List<Part> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Part> findNecessary() {
        return repository.findAllByNecessaryTrue();
    }

    @Override
    public List<Part> findOptional() {
        return repository.findAllByNecessaryFalse();
    }

    @Override
    public List<Part> findByName(String pattern) {
        return repository.findByNameIsLike(pattern);
    }
*/
    @Override
    public Page<Part> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Part> findNecessaryPaged(Pageable pageable) {
        return repository.findAllByNecessaryTrue(pageable);
    }

    @Override
    public Page<Part> findOptionalPaged(Pageable pageable) {
        return repository.findAllByNecessaryFalse(pageable);
    }

    @Override
    public Page<Part> findByNamePaged(String pattern, Pageable pageable) {
        return repository.findByNameIsLike(pattern, pageable);
    }

    @Override
    public Part findNecessaryPart() {
        return repository.findFirstByNecessaryTrueOrderByCountAsc();
    }
}
