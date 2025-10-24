package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Board;
import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardSearch {
  @Query("select b from Board b where b.title like concat('%', :keyword, '%') or b.content like concat('%', :keyword, '%') order by b.bno desc")
  Page<Board> findKeyword(String keyword, Pageable pageable);

//  List<Board> findByTitleAndContent(String title, String content);
//  @Query("select b from Board b where b.title like concat('%', :keyword, '%') or b.content like concat('%', :keyword, '%') order by b.bno desc")
//  List<Board> findByKeyword(String keyword);
}
