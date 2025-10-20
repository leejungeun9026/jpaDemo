package com.jungeun.jpademo.service;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardRepository boardRepository;

  @Override
  public Long insertBoard(BoardDTO boardDTO) {
    Board board = dtoToEntity(boardDTO);
    Long bno = boardRepository.save(board).getBno();
    return bno;
  }

  @Override
  public List<BoardDTO> findAllBoard() {
    List<Board> boards = boardRepository.findAllByOrderByBnoDesc();
    List<BoardDTO> dtos = new ArrayList<>();
    for (Board board : boards) {
      dtos.add(entityToDTO(board));
    }
    return dtos;
  }
}
