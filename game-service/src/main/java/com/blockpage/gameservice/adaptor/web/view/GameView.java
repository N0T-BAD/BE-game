package com.blockpage.gameservice.adaptor.web.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameView {

    private Integer rulletDayCount;

    private Integer lottoDayCount;

    private Boolean attendance;

    public GameView(Integer rulletDayCount, Integer lottoDayCount, Boolean attendance) {
        this.rulletDayCount = rulletDayCount;
        this.lottoDayCount = lottoDayCount;
        this.attendance = attendance;
    }
}
