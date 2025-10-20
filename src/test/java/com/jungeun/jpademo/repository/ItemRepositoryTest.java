package com.jungeun.jpademo.repository;

import com.jungeun.jpademo.domain.Item;
import com.jungeun.jpademo.domain.ItemSellStatus;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class ItemRepositoryTest {
  @Autowired
  private ItemRepository itemRepository;

  @Test
  public void insertItemTest() throws  Exception {
    Item item = Item.builder()
                .itemNm("연필")
                .itemDetail("4B연필")
                .price(1000)
                .stockNumber(10)
                .itemSellStatus(ItemSellStatus.판매중)
                .build();
    itemRepository.save(item);
  }

  @Test
  public void findAllTest(){
    try {
      List<Item> items = itemRepository.findAll();
      for (Item item : items) {
        log.info(item);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void findByIdTest() throws Exception{
    Optional<Item> item = itemRepository.findById(1L);
    log.info(item);
  }

  @Test
  public void updateItemTest() throws Exception{
    Optional<Item> optionalItem = itemRepository.findById(1L);
    Item item = optionalItem.orElseThrow(()->new IllegalArgumentException("해당 ID의 상품이 없습니다."));
    item.setPrice(2000);
    itemRepository.save(item);
  }

  @Test
  public void  deleteItemTest() throws Exception{
    itemRepository.deleteById(1L);
  }
}
