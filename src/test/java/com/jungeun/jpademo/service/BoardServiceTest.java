package com.jungeun.jpademo.service;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.dto.PageRequestDTO;
import com.jungeun.jpademo.dto.PageResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardServiceTest {
  @Autowired
  private BoardService boardService;

//  @Test
//  public void updateReadCountTest(){
//    Long bno = 1L;
//    BoardDTO boardDTO = boardService.findById(bno);
//    log.info("readcount 전 : " + boardDTO.getReadcount());
//    boardService.updateReadCount(bno);
//    boardDTO = boardService.findById(bno);
//    log.info("readcount 후 : " + boardDTO.getReadcount());
//  }

  @Test
  public void getListTest(){
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
    PageResponseDTO<BoardDTO> responseDTO = boardService.getList(pageRequestDTO);
    log.info(responseDTO);
  }
}
