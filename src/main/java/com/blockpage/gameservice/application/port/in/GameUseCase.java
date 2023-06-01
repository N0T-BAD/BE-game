package com.blockpage.gameservice.application.port.in;

import com.blockpage.gameservice.application.port.out.GameDto;
import javax.servlet.http.HttpSession;
import lombok.Builder;
import lombok.Getter;

public interface GameUseCase {

    GameDto getGameQuery(GetQuery getQuery);

    GameDto playGameQuery(PlayQuery playQuery);

    @Getter
    class GetQuery {

        private String memberEmail;

        public GetQuery(String memberEmail) {
            this.memberEmail = memberEmail;
        }
    }

    @Getter
    @Builder
    class PlayQuery {

        private String memberEmail;

        private String type;

        private Boolean compensation;

        public static PlayQuery toQuery(RequestGame requestGame, String memberEmail) {
            return PlayQuery.builder()
                .memberEmail(memberEmail)
                .type(requestGame.getType())
                .compensation(requestGame.getCompensation())
                .build();
        }
    }
}