package com.board.mybatisboard.dto;

import com.board.mybatisboard.domain.Board;
import lombok.*;


@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private Integer id;
    private String author;
    private String title;
    private String content;

    public Board Entity() {
        Board boardBuild = Board.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return boardBuild;
    }

    @Builder
    public BoardRequestDto (Integer id , String author , String title , String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;

    }

}
