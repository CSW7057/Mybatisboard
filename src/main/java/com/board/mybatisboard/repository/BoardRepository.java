package com.board.mybatisboard.repository;

import com.board.mybatisboard.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board , Integer> {

    List<Board> findAllByOrderByUpdatedAtDesc();


}
