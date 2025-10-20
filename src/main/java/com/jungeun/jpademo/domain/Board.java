package com.jungeun.jpademo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="jpa_board")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bno;
  private String title;
  private String content;
  private String writer;

  @CreationTimestamp
  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private Date regdate;
  @ColumnDefault(value="0")
  private int readcount;
}
