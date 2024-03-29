package com.hanbal.hanbalSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    /* MVC와 템플릿 엔진 */
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    /* API */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam ("name") String name){
        return "hello" + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        /*
            (기본)Jackson, Gson : 객체를 Json으로 바꿔주는 라이브러리
        */
        Hello hello = new Hello();
        hello.SetName(name);
        return hello;
    }
    
    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void SetName(String name){
            this.name = name;
        }
    }
}
