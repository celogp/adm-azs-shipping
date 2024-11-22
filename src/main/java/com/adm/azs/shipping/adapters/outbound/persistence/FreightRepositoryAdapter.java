package com.adm.azs.shipping.adapters.outbound.persistence;

import com.adm.azs.shipping.domain.entity.Freight;
import com.adm.azs.shipping.domain.ports.outbound.FreightPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FreightRepositoryAdapter implements FreightPersistencePort {
    private final int PAGE_SIZE = 5;

    @Autowired
    private FreightRepository freightRepository;

    public FreightRepositoryAdapter(FreightRepository freightRepository) {
    }

    @Override
    public Freight save(Freight freight) {
        return freightRepository.save(freight);
    }

    @Override
    public Optional<Freight> findById(Long id) {
        return freightRepository.findById(id);
    }

    @Override
    public Page<Freight> findAll(int pageNumber) {
        return freightRepository.findAll(PageRequest.of(pageNumber, PAGE_SIZE));
    }

    @Override
    public Page<Freight> findByParthenerWithPagination(Long id, int pageNumber) {
        return freightRepository.findByParthenerWithPagination(id, PageRequest.of(pageNumber, PAGE_SIZE));
    }

    @Override
    public void deleteById(long id) {
        freightRepository.deleteById(id);
    }

}
