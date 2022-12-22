package com.board.mybatisboard.domain;

import com.board.mybatisboard.dto.BoardRequestDto;
import com.board.mybatisboard.utill.Timestamped;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 방지 및 지정한 생성자를 사용하도록 강제하고 완전한 상태의 객체를 생성할 수 있도록 도움.
@Getter
@Entity
public class Board extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @Column (name = "BOARD_AUTHOR" , length = 10 , nullable = false)
    private String author;

    @Column(name = "BOARD_TITLE" , length = 30 , nullable = false)
    private String title;

    @Column(name = "BOARD_CONTENT" , columnDefinition = "TEXT" , nullable = false)
    private String content;

    @Builder
    public Board(int id , String author , String title , String content ) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void Update(BoardRequestDto boardRequestDto) {
        this.author = boardRequestDto.getAuthor();
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
    }

}
