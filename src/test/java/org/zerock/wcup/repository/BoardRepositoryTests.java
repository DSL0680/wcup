package org.zerock.wcup.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.wcup.domain.Board;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void test1(){
        log.info(boardRepository.getClass().getName());
    }
    //insert save
    @Test
    public void testInsert() {
        Board board = Board.builder()
                .title("테스트제목")
                .content("Test Content")
                .writer("user00")
                .build();
        boardRepository.save(board);
    }

    //select
    @Test
    public void testRead(){
        Long bno = 123L;
        Optional<Board> result = boardRepository.findById(bno);

        result.orElseThrow();


        log.info(result.get());

    }



    @Test
    public void testList(){

        //페이지 번호 0부터 , 사이즈, 정렬
        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<Board> result = boardRepository.findAll(pageable);

        log.info(result);

        log.info(result.getTotalElements());
        log.info(result.getTotalPages());

        result.forEach(board -> log.info(board));
    }

}
