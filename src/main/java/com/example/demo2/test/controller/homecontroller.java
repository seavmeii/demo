package com.example.demo2.test.controller;

import com.example.demo2.test.domain.Member;
import com.example.demo2.test.service.Memberservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class homecontroller {
    private final Memberservice memberService;

    public homecontroller(Memberservice memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/form2")
    public String form2() {
        // test
        return "MemberAddform";
    }

    @GetMapping("/form")
    public String form() {
        return "MemberAddform";
    }

    @PostMapping("/form")
    public String memberAddForm(
//        @RequestParam String name;
        MemberAddForm memberAddForm

    ){
//        String name = "";
//        System.out.println ("name:" + name);
                System.out.println("memberAddform: "+ memberAddForm.getName());
                Member member = new Member();
                member .setName(memberAddForm.getName());
                memberService.join(member);
                return "memberAddForm";

    }
    @GetMapping("/list2")
    public String list2(Model model) {
        //test
        //test

        return "";
    }


    @GetMapping("/list")
    public String list(Model model) {
        List<Member> list = memberService.findMembers();
        model.addAttribute("list", list);
        return "memberList";
    }


}


