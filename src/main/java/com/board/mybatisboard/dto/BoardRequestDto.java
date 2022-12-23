package com.board.mybatisboard.dto;

import com.board.mybatisboard.domain.Board;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class BoardRequestDto {

    private Integer id;
    private String author;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }

}
