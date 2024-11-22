package com.adm.azs.shipping.adapters.outbound.persistence;

import com.adm.azs.shipping.domain.entity.Freight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface FreightRepository extends JpaRepository<Freight, Long>, JpaSpecificationExecutor<Freight> {

    @Query("select u from Freight u where u.parthener.id = ?1")
    Page<Freight> findByParthenerWithPagination(Long parthenerId, Pageable page);
}
