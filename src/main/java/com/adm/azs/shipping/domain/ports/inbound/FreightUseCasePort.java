package com.adm.azs.shipping.domain.ports.inbound;

import com.adm.azs.shipping.domain.entity.Freight;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface FreightUseCasePort {
    Freight save(Freight freight);
    Optional<Freight> findById(Long id);
    Page<Freight> findAll(int pageNumber);
    Page<Freight> findByParthenerWithPagination(Long id, int pageNumber);
    void deleteById(long id);
}
