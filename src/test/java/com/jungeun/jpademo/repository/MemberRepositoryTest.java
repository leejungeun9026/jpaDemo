package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest {
  @Autowired
  private DataSource dataSource;
  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void DBConnTest() throws SQLException {
    Connection conn = dataSource.getConnection();
    log.info("con....... "+conn);
  }

  @Test
  public void insertMemberTest() {
    Member member = Member.builder()
                    .name("최길동")
                    .password("1234")
                    .email("aabbcc22@naver.com")
                    .addr("부산진구")
                    .build();
    memberRepository.save(member);
  }

  @Test
  public void findAllTest(){
    List<Member> members = memberRepository.findAll();
    for(Member member : members){
      log.info(member);
    }
  }

  @Test
  public void findByIdTest(){
//    Optional<Member> member = memberRepository.findById(1L);
    Member member1 = memberRepository.findById(1L).get();
    Member member2 = memberRepository.findById(1L).orElse(null);
    log.info("member1 = " + member1);
    log.info("member2 = " + member2);
  }

  @Test
  public void updateMemberTest(){
    Member member1 = memberRepository.findById(1L).get();
    member1.setPassword("5678");
    memberRepository.save(member1);
  }

  @Test
  public void deleteMemberTest(){
    memberRepository.deleteById(1L);
  }

  @Test
  public void findByNameTest(){
    Member member = memberRepository.findByName("홍길동");
    log.info(member);
  }
}
