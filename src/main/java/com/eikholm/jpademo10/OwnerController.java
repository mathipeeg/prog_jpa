package com.eikholm.jpademo10;

import com.eikholm.jpademo10.model.Owner;
import com.eikholm.jpademo10.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class OwnerController {

    private OwnerService ownerService; // Spring vil selv komme med objektet hertil

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners/","/owners", "/", "owners/index"})
    public String getOwners(Model model){
        System.out.print("Owners, size: ");
        Set<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        System.out.println(owners.size());
        return "owners/index";
    }

    @RequestMapping(value = "/owners/create", method = GET)
    public String getCreateOwner() {
        return "owners/createOwners";
    }

    @RequestMapping(value = "/owners/create", method = POST)
    public String createOwner(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/delete", method = POST)
    public String deleteOwner(@ModelAttribute Owner owner) {
        ownerService.delete(owner);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owners/edit", method = GET)
    public String editOwner(@RequestParam long id, Model model){
        model.addAttribute("id", id);
        return "owners/edit";
    }

    @RequestMapping(value = "/owners/edit", method = POST)
    public String editOwner(@ModelAttribute Owner owner){
        ownerService.save(owner);
        return "redirect:/owners";
    }
}
