package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Member findByName(String name);
//  Member findByUsername(String username);
}
