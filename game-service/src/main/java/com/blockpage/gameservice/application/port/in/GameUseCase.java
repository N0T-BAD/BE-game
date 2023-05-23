package com.blockpage.gameservice.application.port.in;

import com.blockpage.gameservice.application.port.out.GameDto;
import javax.servlet.http.HttpSession;
import lombok.Getter;

public interface GameUseCase {

    GameDto getGameQuery(GetQuery getQuery);

    @Getter
    class GetQuery {

        private String memberEmail;

        public GetQuery(HttpSession session) {
//            String memberEmail = (String) session.getAttribute("id");
            String memberEmail = "test@naver.com";
            this.memberEmail = memberEmail;
        }
    }
}