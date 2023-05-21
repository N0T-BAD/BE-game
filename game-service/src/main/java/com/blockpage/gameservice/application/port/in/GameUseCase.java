package com.blockpage.gameservice.application.port.in;

import com.blockpage.gameservice.application.port.out.GameDto;
import lombok.Getter;

public interface GameUseCase {

    void postGameQuery(PostQuery postQuery);

    GameDto getGameQuery(GetQuery getQuery);

    @Getter
    class PostQuery {

        private Long memberId;

        public PostQuery(Long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    class GetQuery {

        private Long memberId;

        public GetQuery(Long memberId) {
            this.memberId = memberId;
        }
    }
}