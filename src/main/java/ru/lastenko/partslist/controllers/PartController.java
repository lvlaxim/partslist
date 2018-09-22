package ru.lastenko.partslist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lastenko.partslist.entities.Part;
import ru.lastenko.partslist.service.PartService;
//import ru.lastenko.partslist.repository.PartRepository;



import java.util.List;

@Controller
public class PartController {

    private PartService service;
    private String filterType = "ALL";

    @Autowired
    public void setPartService(PartService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String list(@PageableDefault(size = 10) Pageable pageable,
                       Model model) {
        Page<Part> page = filterAndSort(pageable);
        Integer fullSetCount = findFullSetCount();
        model.addAttribute("page", page);
        model.addAttribute("sort", filterType);
        model.addAttribute("fullSetCount", fullSetCount);
        return "index";
        /*
        List<Part> parts = filterAndSort();
        model.addAttribute("parts", parts);
        model.addAttribute("sort", filterType);
        return "index";
        */
    }

    @GetMapping("/sort/{sortDate}")
    public String sortChoose(@PathVariable String sortDate) {
        filterType = sortDate;
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Part part = service.getPartById(id);
        model.addAttribute("part", part);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String saveNote(@RequestParam Integer id,
                           @RequestParam String name,
                           @RequestParam(value = "necessary", required = false) boolean necessary,
                           @RequestParam String count) {
        /*
        String further = "/edit/{"+ id + "}";
        if (name != null && !name.isEmpty() &&
            count.)
        */
        System.out.println("========= " + name + " ========= " + count);
        try {
            if (name == "" || name.isEmpty() || name == null) throw new IllegalArgumentException("Name is missed!");
            if (count == "" || count.isEmpty() || count == null) throw new IllegalArgumentException("Count is missed!");
            service.updatePart(id, name, necessary, Integer.parseInt(count));
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "redirect:/edit/" + id;
        }

        return "redirect:/";
    }

    @GetMapping("/new")
    public String newPart() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String updatePart(@RequestParam String name,
                             @RequestParam(value = "necessary", required = false) boolean necessary,
                             @RequestParam String count) {
        System.out.println("========= " + name + " ========= " + count);
        try {
            if (name == "" || name.isEmpty() || name == null) throw new IllegalArgumentException("Name is missed!");
            if (count == "" || count.isEmpty() || count == null) throw new IllegalArgumentException("Count is missed!");
            service.savePart(new Part(name, necessary, Integer.parseInt(count)));
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return "redirect:/new";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePart(id);
        return "redirect:/";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String find(@RequestParam String pattern, Model model) {
        filterType = "%" + pattern + "%";
        return "redirect:/";
    }

    private Page<Part> filterAndSort(Pageable pageable) {
        Page<Part> parts = null;
        switch (filterType) {
            case "ALL":
                parts = service.findAllPaged(pageable);
                break;
            case "NECESSARY":
                parts = service.findNecessaryPaged(pageable);
                break;
            case "OPTIONAL":
                parts = service.findOptionalPaged(pageable);
                break;
            default:
                parts = service.findByNamePaged(filterType, pageable);
                break;
        }
        return parts;
    }

    private Integer findFullSetCount(){
        return service.findNecessaryPart().getCount();
    }

}
