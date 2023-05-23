package com.blockpage.gameservice.adaptor.infrastructure.external.block.controller;

import com.blockpage.gameservice.adaptor.infrastructure.external.block.requestbody.RequestBlock;
import com.blockpage.gameservice.application.port.out.BlockPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlockServiceController implements BlockPort {

    private final BlockServiceOpenFeign blockServiceOpenFeign;

    @Override
    public ResponseEntity postBlock(RequestBlock requestBlock) {
        String type = "game";
        blockServiceOpenFeign.postBlock(type, requestBlock);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}