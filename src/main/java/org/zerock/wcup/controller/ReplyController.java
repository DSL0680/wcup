package org.zerock.wcup.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.zerock.wcup.dto.ReplyDTO;
import org.zerock.wcup.service.ReplyService;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/list/{bno}")
    public java.util.List<ReplyDTO> getReplies( @PathVariable("bno") Long bno ){

        log.info("bno: " + bno);

        return replyService.listOfBoard(bno);
    }

    @GetMapping("/{rno}")
    public ReplyDTO getOne(@PathVariable("rno") Long rno){

        return null;
    }

    @PostMapping("")
    public java.util.Map<String, Long> add(@RequestBody  ReplyDTO replyDTO){

        log.info(replyDTO);

        Long result = replyService.register(replyDTO);

        return java.util.Map.of("result", result);
    }

    @DeleteMapping("/{rno}")
    public java.util.Map<String,String> remove( @PathVariable("rno") Long rno ){

        log.info("rno: " + rno);

        return java.util.Map.of("result","removed");
    }

}
