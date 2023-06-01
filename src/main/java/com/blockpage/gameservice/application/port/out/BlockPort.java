package com.blockpage.gameservice.application.port.out;

import com.blockpage.gameservice.adaptor.infrastructure.external.block.requestbody.RequestBlock;
import org.springframework.http.ResponseEntity;

public interface BlockPort {
    ResponseEntity postBlock(String memberId ,RequestBlock requestBlock);
}