package magiccards.ui.controllers;

import magiccards.ui.entities.Expansion;
import magiccards.ui.entities.Page;
import magiccards.ui.entities.TablePage;
import magiccards.ui.proxies.ExpansionsFacadeProxy;
import magiccards.services.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpansionsController {

    @Autowired
    private ExpansionsFacadeProxy expansionProxy;
    @Autowired
    private ExpansionService service;

    @RequestMapping(value="/expansions", method = RequestMethod.GET)
    public String list() {

        return "expansions/list";
    }

    @RequestMapping(value="/expansions/data", method = RequestMethod.GET)
    public @ResponseBody TablePage<Expansion> listPaged(@RequestParam("draw")int draw, @RequestParam("start")int start, @RequestParam("length")int length) {

        int pageNumber = (start/length) + 1;
        Page<Expansion> exps = expansionProxy.getExpansions(pageNumber, length);

        TablePage<Expansion> result = new TablePage<Expansion>();
        result.setData(exps.getContent());
        result.setRecordsTotal(exps.getTotalElements());
        result.setRecordsFiltered(exps.getTotalElements());
        result.setDraw(draw);
        return result;
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.GET)
    public String create() {
        return "expansions/create";
    }

    @RequestMapping(value="/expansions/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id")String id, Model model) {
        Expansion exp = expansionProxy.getExpansionByid(id);
        Long millisec = Long.parseLong(exp.getLaunchDate());
        exp.setLaunchDate(service.getFormatedDateString(millisec));
        model.addAttribute("expansion", exp);

        return "expansions/update";
    }

    @RequestMapping(value="/expansions/create", method = RequestMethod.POST)
    public String create(Expansion exp) {

        expansionProxy.create(exp);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/update", method = RequestMethod.POST)
    public String update(Expansion exp) {

        expansionProxy.update(exp);

        return "redirect:/expansions";
    }

    @RequestMapping(value="/expansions/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id")String id) {

        expansionProxy.delete(id);

        return "redirect:/expansions";
    }


}
