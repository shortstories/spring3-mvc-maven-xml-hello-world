package com.mkyong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {

    model.addAttribute("message", "Spring 3 MVC Hello World");
    return "hello";

  }

  @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
  public ModelAndView hello(@PathVariable("name") String name) {
    ModelAndView model = new ModelAndView();
    model.setViewName("hello");
    model.addObject("coreCss", "/spring3/resources/core/css/hello.css");
    model.addObject("bootstrapCss", "/spring3/resources/core/css/bootstrap.min.css");
    model.addObject("coreJs", "/spring3/resources/core/css/hello.js");
    model.addObject("bootstrapJs", "/spring3/resources/core/css/bootstrap.min.js");
    model.addObject("msg", name);
    return model;
  }
}