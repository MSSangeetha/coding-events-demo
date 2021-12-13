package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

       @GetMapping
    public String displayTags(Model model) {

            model.addAttribute("title", "All Tags");
            model.addAttribute("tags", tagRepository.findAll());

        return "tags/index";
    }

    @GetMapping("create")
    public String displayCreateTagForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Tag());
//        model.addAttribute("categories", tagRepository.findAll());
        return "tags/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute @Valid Tag tag,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Tag");
            return "tags/create";
        }

        tagRepository.save(tag);
        return "redirect:";
    }



}
