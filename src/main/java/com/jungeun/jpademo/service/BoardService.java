package com.jungeun.jpademo.service;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.dto.PageRequestDTO;
import com.jungeun.jpademo.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
  Long insertBoard(BoardDTO boardDTO);
  List<BoardDTO> findAllBoard();
  BoardDTO findById(Long bno, int mode);
//  void updateReadCount(Long bno);
  Long updateBoard(BoardDTO boardDTO);
  int deleteBoard(Long bno);
  PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);

  default Board dtoToEntity(BoardDTO boardDTO){
    Board board = Board.builder()
                  .bno(boardDTO.getBno())
                  .title(boardDTO.getTitle())
                  .content(boardDTO.getContent())
                  .author(boardDTO.getAuthor())
                  .build();
    return board;
  }

  default BoardDTO entityToDTO(Board board){
    BoardDTO boardDTO = BoardDTO.builder()
                        .bno(board.getBno())
                        .title(board.getTitle())
                        .content(board.getContent())
                        .author(board.getAuthor())
                        .readcount(board.getReadcount())
                        .regDate(board.getRegDate())
                        .updateDate(board.getUpdateDate())
                        .build();
    return boardDTO;
  }
}
