package com.adm.azs.shipping.adapters.inbound.rest;

import com.adm.azs.shipping.application.FreightUseCase;
import com.adm.azs.shipping.domain.dto.*;
import com.adm.azs.shipping.domain.entity.Freight;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Freights")
public class FreightController {

    @Autowired
    private FreightUseCase freightUseCase;

    @Autowired
    ModelMapper _modelMapper;

    private FreightParthenerResponse doMapperEntityToParthenerRes(Freight freight){
        return _modelMapper.map(freight, FreightParthenerResponse.class);
    }

    private Freight doMapperReqToEntity(FreightRequest freightRequest){
        return _modelMapper.map(freightRequest, Freight.class);
    }

    @PostMapping
    public ResponseEntity<FreightParthenerResponse> create(@RequestBody FreightRequest freightRequest) {
        var freight = doMapperReqToEntity(freightRequest);
        var freightParthenerResponse = doMapperEntityToParthenerRes(freightUseCase.save(freight));
        return ResponseEntity.ok(freightParthenerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Freight> findById(@PathVariable Long id) {
        return freightUseCase.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.ok().build());
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Freight>> findAll(@Param("pageNumber") int pageNumber ) {
        var pagesFreights = freightUseCase.findAll(pageNumber);
        return ResponseEntity.ok(new ApiResponse<>(
                pagesFreights.getContent(),
                PaginationResponse.fromPage(pagesFreights)
        ));
    }

    @GetMapping("/Parthener/{id}")
    public ResponseEntity<ApiResponse<Freight>> findByParthener(@PathVariable Long id, @Param("pageNumber") int pageNumber) {
        var pagesFreights = freightUseCase.findByParthenerWithPagination(id, pageNumber);
        return ResponseEntity.ok(new ApiResponse<>(
                pagesFreights.getContent(),
                PaginationResponse.fromPage(pagesFreights)
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable long id){
        if (Boolean.FALSE.equals(recordExists(id))){
            return ResponseEntity.notFound().build();
        }
        freightUseCase.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateById(@RequestBody FreightRequest freightRequest){
        if (Boolean.FALSE.equals(recordExists(freightRequest.getId()))){
            return ResponseEntity.notFound().build();
        }
        freightUseCase.save(  doMapperReqToEntity(freightRequest) );
        return ResponseEntity.ok().build();
    }

    private Boolean recordExists(Long id){
        var recordExists = Boolean.FALSE;
        if ((id != null) && (id.intValue() != 0)){
            recordExists = freightUseCase.findById(id).isPresent();
        }
        return recordExists;
    }
}
