package com.board.mybatisboard.service;

import com.board.mybatisboard.domain.Board;
import com.board.mybatisboard.dto.BoardRequestDto;
import com.board.mybatisboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    // 게시글 전체 조회
    @Transactional
    public List<Board> BoardList() {
       return boardRepository.findAllByOrderByUpdatedAtDesc();

    }

    // 게시글 상세 조회
    @Transactional
    public Optional<Board> BoardDetail(Integer id) {
        return boardRepository.findById(id);
    }

    // 게시글 생성
    @Transactional
    public Integer BoardCreate(BoardRequestDto boardCreateDto) {
        return boardRepository.save(boardCreateDto.toEntity()).getId();
    }

    //
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


