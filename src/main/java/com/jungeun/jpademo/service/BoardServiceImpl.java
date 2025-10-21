package com.jungeun.jpademo.service;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.dto.PageRequestDTO;
import com.jungeun.jpademo.dto.PageResponseDTO;
import com.jungeun.jpademo.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    List<Board> boards = boardRepository.findAll();
    List<BoardDTO> dtos = new ArrayList<>();
    for (Board board : boards) {
      dtos.add(entityToDTO(board));
    }
    return dtos;
  }

  @Override
  public BoardDTO findById(Long bno, int mode) {
    Board board = boardRepository.findById(bno).orElse(null);
    if(mode == 1) {
      board.updateReadCount();
      boardRepository.save(board);
    }
    return entityToDTO(board);
  }

//  @Override
//  public void updateReadCount(Long bno) {
//    Board board = boardRepository.findById(bno).orElse(null);
//    board.setReadcount(board.getReadcount() + 1);
//    boardRepository.save(board);
//  }

  @Override
  public Long updateBoard(BoardDTO boardDTO) {
    Board board = boardRepository.findById(boardDTO.getBno()).orElse(null);
    board.change(boardDTO.getTitle(), boardDTO.getContent());
    Long bno = boardRepository.save(board).getBno();
    return bno;
  }

  @Override
  public int deleteBoard(Long bno) {
    boardRepository.deleteById(bno);
    Optional<Board> board = boardRepository.findById(bno);
    if (board.isEmpty()) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
    Pageable pageable = pageRequestDTO.getPageable("bno");
//    Page<Board> result = boardRepository.findAll(pageable);
    Page<Board> result = boardRepository.findKeyword(pageRequestDTO.getKeyword(), pageable);
    List<BoardDTO> dtoList = result.getContent().stream().map(board->entityToDTO(board)).collect(Collectors.toList());
    int total = (int)result.getTotalElements();

    PageResponseDTO<BoardDTO> responseDTO = PageResponseDTO.<BoardDTO>withAll().pageRequestDTO(pageRequestDTO).dtoList(dtoList).total(total).build();
    return responseDTO;
  }
}
