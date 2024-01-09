package org.zerock.wcup.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/prd")
public class ProductController {

    @GetMapping("/list")
    public void list( ){
        log.info("list...............");

    }

    @GetMapping("/register")
    public void register( ){
        log.info("register...............");

    }

    @PostMapping("/register")
    public String registerPost(RedirectAttributes rttr){
        log.info("registerPost...............");

        //주소에 포함
        rttr.addAttribute("msg", "ABCDE");
        //눈에 보이지 않으나 한번만 전달
        rttr.addFlashAttribute("result", "success");

        return "redirect:/prd/list";
    }

    @GetMapping("/read/{pno}")
    public String read( @PathVariable("pno") Long pno ){

        log.info("read...............");
        log.info("pno: " + pno);

        return "/prd/read";
    }


}
