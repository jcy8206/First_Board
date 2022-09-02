package com.board.study;

import com.board.study.entity.Board;
import com.board.study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final BoardRepository boardRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
//        boardRepository.save(new Board("타이틀1", "내용1", 0,"작성자1"));
//        boardRepository.save(new Board("타이틀2", "내용2", 0,"작성자2"));
    }
}
