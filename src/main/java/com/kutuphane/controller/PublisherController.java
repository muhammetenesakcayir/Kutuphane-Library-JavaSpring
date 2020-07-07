package com.kutuphane.controller;

import com.kutuphane.model.Publisher;
import com.kutuphane.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @RequestMapping("/publisher")
    public String viewPublisher(Model model) {
        List<Publisher> publisherList = publisherService.listAll();
        model.addAttribute("publisherList", publisherList);
        return "publisher/index";
    }

    @GetMapping("/savepublisher")
    public String getPublisher(@ModelAttribute("publisher") Publisher publisher) {
        return "publisher/create";
    }

    @PostMapping("/savepublisher")
    public String savePublisher(Publisher publisher) {
        publisherService.save(publisher);
        return "redirect:/publisher";
    }

    @GetMapping("/updatepublisher/{id}")
    public String updateYayinevi(@PathVariable("id") Long id , Model model) {
        Publisher publisher = publisherService.get(id);
        model.addAttribute("update", publisher);
        return "publisher/edit";
    }

    @GetMapping("/deletepublisher/{id}")
    public String deleteYayinevi(@PathVariable("id") Long id) {
        publisherService.delete(id);
        return "redirect:/publisher";
    }

    @GetMapping(value = "/detailpublisher/{id}")
    public String postDetailYayinevi(@PathVariable("id") Long id, Model model) {
        Publisher publisher = publisherService.get(id);
        model.addAttribute("publisher", publisher);
        return "publisher/detail";
    }
}
