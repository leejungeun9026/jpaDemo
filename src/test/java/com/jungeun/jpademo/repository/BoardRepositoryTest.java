package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Board;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void insertBoardTest(){
    Board board = Board.builder()
        .title("제목에만 1 넣어봄")
        .content("내용")
        .author("김길동")
        .build();
    boardRepository.save(board);
  }

//  @Test
//  public void findByKeywordTest(){
//    List<Board> boards = boardRepository.findByKeyword("1");
//    for (Board board : boards) {
//      log.info(board);
//    }
//  }


}
