package com.open_data_visualization.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisualizationController {

    @Autowired
    @RequestMapping(value="/show_visuals", method = RequestMethod.GET)
    public ModelAndView show_visuals(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_visuals");
        return modelAndView;
    }



}
