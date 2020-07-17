package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    public ArrayList<GuestPost> guestBook = new ArrayList<>();

    @GetMapping("/add")
    public String addGuestPost(Model model){
        model.addAttribute("guestPost", new GuestPost());
        return "addPost";
    }

    @PostMapping("/add")
    public String listGuestBook(@ModelAttribute GuestPost guestPost, Model model){
        model.addAttribute("guestPost", guestPost);
        guestBook.add(guestPost);
        return "redirect:/home";

    }

    @GetMapping("/home")
    public String showGuestBook(@ModelAttribute GuestPost guestPost, Model model){
        model.addAttribute("guestBook", guestBook);
        return "guestBook";
    }

    @RequestMapping("/view/{postNumber}")
    public String viewGuestBookPost(@PathVariable("postNumber") int postNumber, Model model){
        GuestPost guestPost = new GuestPost();
        for (GuestPost one : guestBook) {
            if (one.getPostNumber() == postNumber) {
                guestPost = one;
                break;
            }
        }
        model.addAttribute("guestPost", guestPost);
        model.addAttribute("message", "Sign our Guestbook!");
        return "viewPost";
    }


    @RequestMapping("/update/{postNumber}")
    public String updateGuestBookPost(@PathVariable("postNumber") int postNumber, Model model) {
        GuestPost guestPost = new GuestPost();
        for (GuestPost one : guestBook) {
            if (one.getPostNumber() == postNumber) {
                guestPost = one;
                guestBook.remove(one);
                break;
            }
        }
        model.addAttribute("guestPost", guestPost);
        model.addAttribute("message", "Update Post");
        return "addPost";
    }

    @RequestMapping("/delete/{postNumber}")
    public String deleteGuestBookPost(@PathVariable("postNumber") int postNumber, Model model){
        for (GuestPost guestPost : guestBook){
            if (guestPost.getPostNumber() == postNumber){
                guestBook.remove(guestPost);
                break;
            }
        }
        return "redirect:/home";
    }

}
