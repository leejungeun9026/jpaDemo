package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.repository.search.BoardSearch;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {
  @Autowired
  private BoardRepository boardRepository;

  @Test
  public void search1Test(){
    Pageable pageable = PageRequest.of(0, 5, Sort.by("bno").descending());
    Page<Board> result = boardRepository.search1(pageable);
    List<Board> boardList = result.getContent();
    for (Board board : boardList){
      log.info(board);
    }
    log.info(result.stream().count());
    log.info(result.getSize());
  }

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
