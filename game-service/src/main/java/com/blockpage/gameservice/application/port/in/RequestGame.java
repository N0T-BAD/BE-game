package com.blockpage.gameservice.application.port.in;

import lombok.Getter;

@Getter
public class RequestGame {

    private String memberEmail;

    private String type;

    private Boolean compensation;
    //블럭 당첨 시 true

}