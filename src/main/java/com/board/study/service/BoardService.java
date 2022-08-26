package com.board.study.service;

import com.board.study.dto.board.BoardRequestDto;
import com.board.study.dto.board.BoardResponseDto;
import com.board.study.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public Long save(BoardRequestDto boardRequestDto) {
        return boardRepository.save(boardRequestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll() {
        return boardRepository.findAll().stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    public BoardResponseDto findById(Long id) {
        return new BoardResponseDto(boardRepository.findById(id).get());
    }

    public int updateBoard(BoardRequestDto boardRequestDto) {
        return boardRepository.updateBoard(boardRequestDto);
    }

    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
