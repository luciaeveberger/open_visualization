package com.open_data_visualization.controller;
import com.open_data_visualization.model.PollenWeeklyData;
import com.open_data_visualization.repository.PollenDataRepository;
import com.open_data_visualization.repository.UVDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.open_data_visualization.model.UVData;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class VisualizationController {
    @Autowired
    private UVDataRepository uvRepository;

    @Autowired
    private PollenDataRepository pollenRepository;

    @Autowired
    @RequestMapping(value="/show_visuals", method = RequestMethod.GET)
    public ModelAndView show_visuals(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_visuals");
        modelAndView.addObject("message", "Baeldung");
        return modelAndView;
    }
    @Autowired
    @RequestMapping(value="/show_pollen", method = RequestMethod.GET)
    public ModelAndView show_pollen(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_pollen");
        return modelAndView;
    }

    @Autowired
    @RequestMapping(value="/about", method = RequestMethod.GET)
    public ModelAndView aboutData(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("about");
        return modelAndView;
    }


    @GetMapping(path="/all_uv_data")
    public @ResponseBody List<UVData> getAllUVData() {
        return uvRepository.findAll();
    }
    @GetMapping(path="/all_pollen_data")
    public @ResponseBody List<PollenWeeklyData> getAllPollenData() {
        return pollenRepository.findAll();
    }

}
