package com.open_data_visualization.controller;
import com.open_data_visualization.model.User;
import com.open_data_visualization.repository.CartRepository;
import java.security.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.open_data_visualization.model.Cart;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
public class CartController {
    @Autowired
    private CartRepository cartRepo;

    @Autowired
    @RequestMapping(value="/show_cart", method = RequestMethod.GET)
    public ModelAndView show_cart(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("show_cart");
        return modelAndView;
    }

    @RequestMapping(value = "/add_to_cart", method = RequestMethod.POST)
    public ModelAndView  getAllCartData(@RequestBody String cart_body) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Cart newItem = new Cart(auth.getName(),cart_body,"");
        cartRepo.save(newItem);
        return new ModelAndView("redirect:/show_cart");
    }

    @RequestMapping(value = "/add_custom_request", method = RequestMethod.POST)
    public ModelAndView  addCustomRequest(@RequestBody String string_request) {
        System.out.println(string_request);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Cart newItem = new Cart(auth.getName(),"",string_request);
        cartRepo.save(newItem);
        return new ModelAndView("redirect:/show_cart");
    }

//    @Autowired
    @RequestMapping(value = "/get_all_cart", method = RequestMethod.GET)
    public @ResponseBody List<Cart>  getFromCart() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return  cartRepo.findByUsername(auth.getName());
    }


}
