package com.lambdaschool.javabookstore.controller;

import com.lambdaschool.javabookstore.model.Section;
import com.lambdaschool.javabookstore.repository.Sectionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/sections", produces = MediaType.APPLICATION_JSON_VALUE)
public class SectionController {
    @Autowired
    Sectionrepository sectionrepos;

    @GetMapping("/")
    public List<Section> listAllSections(){
        return sectionrepos.findAll();
    }

}
