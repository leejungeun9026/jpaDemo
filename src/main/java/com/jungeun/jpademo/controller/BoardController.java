package com.jungeun.jpademo.controller;

import com.jungeun.jpademo.dto.BoardDTO;
import com.jungeun.jpademo.service.BoardService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
  @Autowired
  private BoardService boardService;

  @GetMapping("/list")
  public void list(Model model) {
    log.info("list......");
    model.addAttribute("boardList", boardService.findAllBoard());
  }

  @GetMapping("/register")
  public void registerGet() {
    log.info("registerGet......");
  }

  @PostMapping("/register")
  public String registerPost(@Valid BoardDTO boardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    log.info("registerPost......");
    if(bindingResult.hasErrors()) {
      log.info("bindingResult.hasErrors");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/board/register";
    }

    Long bno = boardService.insertBoard(boardDTO);
    if (bno != null) {
      log.info("board inserted successfully....");
      return "redirect:/board/list";
    } else {
      return "redirect:/board/register";
    }
  }
}
