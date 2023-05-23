package com.blockpage.gameservice.adaptor.infrastructure.external.block.requestbody;

import lombok.Getter;

@Getter
public class RequestBlock {

    private Integer blockQuantity;

    public RequestBlock(String email) {
        this.blockQuantity = 2;
    }
}