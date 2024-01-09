package org.zerock.wcup.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/prd")
public class ProductController {

    @GetMapping("/list")
    public void list(Model model){
        log.info("list...............");

        List<String> list = List.of("AAA","BBB","CCC","DDD","EEE");

        model.addAttribute("list",list);


    }

    @GetMapping("/register")
    public void register( ){
        log.info("register...............");

    }

    @PostMapping("/register")
    public String registerPost(){
        log.info("registerPost...............");


        return "redirect:/prd/list";
    }

    @GetMapping("/read/{pno}")
    public String read( @PathVariable("pno") Long pno ){

        log.info("read...............");
        log.info("pno: " + pno);

        return "/prd/read";
    }


}
