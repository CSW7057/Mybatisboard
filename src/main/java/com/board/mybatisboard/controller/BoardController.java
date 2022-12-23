package com.board.mybatisboard.controller;


import com.board.mybatisboard.domain.Board;
import com.board.mybatisboard.dto.BoardRequestDto;
import com.board.mybatisboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public List <Board> BoardList () {
        return boardService.BoardList();
    }

    @GetMapping("/{id}")
    public Optional <Board> BoardDetail (@PathVariable Integer id) {
        return boardService.BoardDetail(id);
    }

    @PostMapping("/")
    public Object BoardCreate (@RequestBody BoardRequestDto boardCreateDto) {
        boardService.BoardCreate(boardCreateDto);
        return boardCreateDto;
    }

    @PutMapping("/{id}")
    public Integer BoardUpdate (@PathVariable Integer id ,
                                @RequestBody BoardRequestDto boardUpdateDto) {
        boardService.BoardUpdate(id , boardUpdateDto);
        return id;
    }

    @DeleteMapping("/{id}")
    public Integer BoardDelete (@PathVariable Integer id) {
        boardService.BoardDelete(id);
        return id;
    }

}
