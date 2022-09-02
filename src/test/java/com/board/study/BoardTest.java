package com.board.study;

import com.board.study.dto.board.BoardRequestDto;
import com.board.study.dto.board.BoardResponseDto;
import com.board.study.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class BoardTest {

    @Autowired
    private BoardService boardService;

    @Test
    void save() {
        BoardRequestDto boardSaveDto = new BoardRequestDto();

        boardSaveDto.setTitle("제목입니다.");
        boardSaveDto.setContent("내용입니다.");
        boardSaveDto.setRegisterId("작성자");

        Long result = boardService.save(boardSaveDto);

        if (result > 0) {
            log.info("Success save()");
//            boardService.findAll();
//            boardService.findById(result);
        } else {
            log.info("Fail save()");
        }
    }

    @Test
    void findAll() {
        List<BoardResponseDto> result = boardService.findAll();

        if (result != null) {
            log.info("Success findAll()={}", result.toString());
        } else {
            log.info("Fail findAll()");
        }
    }

    @Test
    void findById(Long id) {
        BoardResponseDto result = boardService.findById(id);

        if (result != null) {
            log.info("Success findById() = {}", result.toString());
        } else {
            log.info("Fail findByiD");
        }
    }

    @Test
    void update(Long id) {
        BoardRequestDto boardRequestDto = new BoardRequestDto();

        boardRequestDto.setId(id);
        boardRequestDto.setTitle("업데이트 제목");
        boardRequestDto.setContent("업데이트 내용");
        boardRequestDto.setRegisterId("작성자");

        int result = boardService.updateBoard(boardRequestDto);

        if (result > 0) {
            log.info("Success updateBoard()");
        } else {
            log.info("Fail updateBoard()");

        }
    }

}