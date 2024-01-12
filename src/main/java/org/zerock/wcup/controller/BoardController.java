package org.zerock.wcup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.wcup.dto.BoardDTO;
import org.zerock.wcup.dto.PageRequestDTO;
import org.zerock.wcup.dto.PageResponseDTO;
import org.zerock.wcup.service.BoardService;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list...............");
        log.info(pageRequestDTO);

        PageResponseDTO<BoardDTO> result =
            boardService.list(pageRequestDTO);
        model.addAttribute("result",result);
    }

    @GetMapping("/{bno}")
    public String get(@PathVariable("bno") Long bno, Model model){

        BoardDTO boardDTO = boardService.get(bno);

        model.addAttribute("board", boardDTO);

        return "board/get";
    }

}
