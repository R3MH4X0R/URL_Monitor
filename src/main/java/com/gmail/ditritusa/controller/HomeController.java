package com.gmail.ditritusa.controller;

import com.gmail.ditritusa.model.UrlInfo;
import com.gmail.ditritusa.repository.UrlInfoRepository;
import com.gmail.ditritusa.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class HomeController {

    private final UrlInfoRepository urlInfoRepository;

    private final UrlUtil urlUtil;

    @Autowired
    public HomeController(UrlInfoRepository urlInfoRepository, UrlUtil urlUtil) {
        this.urlInfoRepository = urlInfoRepository;
        this.urlUtil = urlUtil;
    }

    @RequestMapping(value = {"/"})
    public String index(Model model) {
        model.addAttribute("urls", this.urlInfoRepository.findAll(Sort.by("url")));
        return "index";
    }


    @PostMapping(value = {"/save"})
    public String add(UrlInfo urlInfo) {
        try {
            urlUtil.getStatus(urlInfo.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        this.urlInfoRepository.delete(urlInfoRepository.getOne(id));

        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id) {
        urlUtil.getStatus(id);

        return "redirect:/";
    }

    @RequestMapping(value = {"/refresh"})
    public String refresh() {
        urlUtil.refreshAll();

        return "redirect:/";
    }


}
