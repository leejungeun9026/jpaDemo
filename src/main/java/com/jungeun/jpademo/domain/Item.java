package com.jungeun.jpademo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
  @Id
  @Column(name="item_id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable=false, length=50)
  private String itemNm;

  @Column(nullable=false)
  @ColumnDefault(value="1000")
//  숫자라도 꼭 문자열 형태로 입력해야 함
  private int price;

  @Column(nullable=false)
  @ColumnDefault(value="10")
//  @Column(columnDefinition = "int default 10 not null")
//  위 두개 어노테이션과 같은 역할을 수행
  private int stockNumber;

  @Lob
  @Column(nullable=false)
  private String itemDetail;

  @Enumerated(EnumType.STRING)
//  EnumType.ORDINAL = 0, 1, 2
//  EnumType.STRING = 판매중, 판매완료, 입고대기
  private ItemSellStatus itemSellStatus;

  @CreationTimestamp
  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime regTime;

  @UpdateTimestamp
  @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
  private LocalDateTime updateTime;

  @Transient
  private String memo;

  @Transient
  private String remark;
}
