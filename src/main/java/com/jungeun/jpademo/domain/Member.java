package com.jungeun.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="jpa_member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String password;
  @Column(unique = true)
  private String email;
  @Column(name="address")
  private String addr;
}
