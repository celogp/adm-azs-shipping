package com.adm.azs.shipping.application;

import com.adm.azs.shipping.adapters.outbound.persistence.FreightRepositoryAdapter;
import com.adm.azs.shipping.domain.entity.Freight;
import com.adm.azs.shipping.domain.ports.inbound.FreightUseCasePort;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreightUseCase implements FreightUseCasePort {

    private final FreightRepositoryAdapter freightRepositoryAdapter;

    public FreightUseCase(FreightRepositoryAdapter freightRepositoryAdapter) {
        this.freightRepositoryAdapter = freightRepositoryAdapter;
    }

    @Override
    public Freight save(Freight freight) {
        return freightRepositoryAdapter.save(freight);
    }

    @Override
    public Optional<Freight> findById(Long id) {
        return freightRepositoryAdapter.findById(id);
    }

    @Override
    public Page<Freight> findAll(int pageNumber) {
        return freightRepositoryAdapter.findAll(pageNumber);
    }

    @Override
    public Page<Freight> findByParthenerWithPagination(Long id, int pageNumber) {
        return freightRepositoryAdapter.findByParthenerWithPagination(id, pageNumber);
    }

    @Override
    public void deleteById(long id) {
        freightRepositoryAdapter.deleteById(id);
    }

}
