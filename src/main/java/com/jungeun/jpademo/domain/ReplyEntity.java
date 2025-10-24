package com.jungeun.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="jpa_reply")
public class ReplyEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rno;
  private Long bno;
  private String content;
  private String writer;
  @Transient
  private String memo;
}