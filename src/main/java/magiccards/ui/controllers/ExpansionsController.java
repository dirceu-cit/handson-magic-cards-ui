package magiccards.ui.controllers;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionsFacadeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpansionsController {

    @Autowired
    private ExpansionsFacadeProxy expansionsProxy;

    @GetMapping(value="/expansions")
    public String list() {
        return "expansions/list";
    }

    @GetMapping(value="/expansions/data")
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start,@RequestParam("length")int length) {
        int pageNumber = (start/length);
        Page<Expansion> expansions = expansionsProxy.getExpansions(pageNumber, length);
        TablePage<Expansion> result = new TablePage<Expansion>();
        result.setData(expansions.getContent());
        result.setRecordsTotal(expansions.getTotalElements());
        result.setRecordsFiltered(expansions.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @GetMapping(value="/expansions/create")
    public String create() {
        return "expansions/create";
    }

    @GetMapping(value="/expansions/update/{id}")
    public String update(@PathVariable("id")int id, Model model) {
        Expansion expansion = expansionsProxy.getExpansionById(id);
        model.addAttribute("expansion", expansion);
        return "expansions/update";
    }

    @PostMapping(value="/expansions/create")
    public String create(Expansion expansion) {
        expansionsProxy.create(expansion);
        return "redirect:/expansions";
    }

    @PostMapping(value="/expansions/update")
    public String update(Expansion expansion) {
        expansionsProxy.update(expansion);
        return "redirect:/expansions";
    }

    @GetMapping(value="/expansions/delete/{id}")
    public String delete(@PathVariable("id")int id) {
        expansionsProxy.delete(id);
        return "redirect:/expansions";
    }


}
