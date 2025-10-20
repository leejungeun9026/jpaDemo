package com.jungeun.jpademo.service;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;

import java.util.List;

public interface BoardService {
  Long insertBoard(BoardDTO board);
  List<BoardDTO> findAllBoard();

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
