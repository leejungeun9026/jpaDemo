package com.jungeun.jpademo.dto;

import com.jungeun.jpademo.domain.Member;
import com.jungeun.jpademo.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Log4j2
public class PageRequestTest {
  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void pageListTest(){
    Page<Member> memberPage = memberRepository.findAll(PageRequest.of(0,3, Sort.by("id").descending()));
    List<Member> members = memberPage.getContent();
    int totalPage = memberPage.getTotalPages();
    log.info("totalPage:{}", totalPage);
    for(Member member : members){
      log.info(member);
    }
  }
}
