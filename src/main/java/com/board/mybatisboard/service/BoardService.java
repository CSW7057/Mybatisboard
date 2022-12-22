package com.board.mybatisboard.service;

import com.board.mybatisboard.domain.Board;
import com.board.mybatisboard.dto.BoardRequestDto;
import com.board.mybatisboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {


    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardRequestDto> BoardList() {
        List<Board> boardList = boardRepository.findAllByOrderByUpdatedAtDesc();
        List<BoardRequestDto> boardRequestDtoList = new ArrayList<>();
        for ( Board board : boardList) {
            BoardRequestDto boardDto = BoardRequestDto.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();
            boardRequestDtoList.add(boardDto);
        }
        return boardRequestDtoList;
    }

    @Transactional
    public BoardRequestDto BoardDetail(Integer id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않은 글입니다."));
        BoardRequestDto boardRequestDto = BoardRequestDto.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getContent())
                .build();
        return boardRequestDto;
    }

    @Transactional
    public Integer BoardCreate(BoardRequestDto boardRequestDto) {
        return boardRepository.save(boardRequestDto.Entity()).getId();
    }

    @Transactional
    public Integer BoardUpdate(Integer id , BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않은 글입니다."));
        board.Update(boardRequestDto);
        return board.getId();
    }

    @Transactional
    public void BoardDelete (Integer id) {
        boardRepository.deleteById(id);
    }

}


