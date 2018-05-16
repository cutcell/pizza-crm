package com.pizza.crm.controller.admin;

import com.pizza.crm.model.Validity;
import com.pizza.crm.model.ValiditySchedule;
import com.pizza.crm.repository.ValidityRepository;
import com.pizza.crm.service.ValidityScheduleService;
import com.pizza.crm.service.ValidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
public class ValidityController {

    private final ValidityScheduleService validityScheduleService;
    private final ValidityService validityService;

    @Autowired
    public ValidityController(ValidityScheduleService validityScheduleService, ValidityService validityService) {
        this.validityScheduleService = validityScheduleService;
        this.validityService = validityService;
    }

    @RequestMapping("/validity")
    public String validity(Model model) {
        model.addAttribute("validity", validityService.getAll());
        return "admin/validity";
    }

    /*@PostMapping("/schedule/save")
    public String save(@RequestBody ValiditySchedule validitySchedule) {
        validityScheduleService.save(validitySchedule);
        return "redirect:/validity";
    }*/

    @PostMapping("/schedule/save")
    public String addSchedule(
            @RequestParam String validityName,
            @RequestParam LocalTime beginTime,
            @RequestParam LocalTime endTime,
            @RequestParam Boolean monday,
            @RequestParam Boolean tuesday,
            @RequestParam Boolean wednesday,
            @RequestParam Boolean thursday,
            @RequestParam Boolean friday,
            @RequestParam Boolean saturday,
            @RequestParam Boolean sunday){
        ValiditySchedule validitySchedule = new ValiditySchedule(beginTime, endTime, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
        Validity validity = validityService.findByNameValidity(validityName);
        validity.getValidityScheduleList().add(validitySchedule);
        validityService.save(validity);
        return "redirect:/validity";
    }

  /*  @PostMapping("/validity/delete")
    public String delete(@RequestParam String name) {

        validityScheduleService.deleteByName(name);
        return "redirect:/validity";
    }*/

    @PostMapping("/validity/addValidity")
    public String saveValidity (@RequestParam String name){
        validityService.save(new Validity(name));
        return "redirect:/validity";
    }

}
