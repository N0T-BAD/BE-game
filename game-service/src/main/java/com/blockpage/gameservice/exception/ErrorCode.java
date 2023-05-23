package com.blockpage.gameservice.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    //block-service
    BLOCK_SERVER_BAD_REQUEST("블럭 서비스에 잘못된 요청을 보냈습니다.", HttpStatus.NO_CONTENT),
    BLOCK_SERVER_UNAVAILABLE("블럭 서비스 이용이 불가능합니다.", HttpStatus.NO_CONTENT),

    //game-server
    GAME_UNAVAILABLE("당일 횟수 초과로 이용할 수 없습니다.",HttpStatus.NO_CONTENT),
    GAME_BAD_REQUEST("잘못된 요청입니다.",HttpStatus.NO_CONTENT),

    //global
    UNKNOWN_ERROR("알수 없는 에러가 발생했습니다.", HttpStatus.NO_CONTENT);
    ;
    private final String message;
    private final HttpStatus httpStatus;
}