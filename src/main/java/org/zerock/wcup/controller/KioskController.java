package org.zerock.wcup.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.wcup.service.ProductService;

@Controller
@RequestMapping("/kiosk")
@RequiredArgsConstructor
@Log4j2
public class KioskController {

    private final ProductService productService;

    @GetMapping("/{sno}")
    public String getProducts(
            @PathVariable("sno") Long sno, Model model){

        model.addAttribute("menus", productService.listOfStore(sno));

        return "kiosk/menus";
    }


}
