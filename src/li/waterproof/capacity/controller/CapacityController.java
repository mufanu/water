package li.waterproof.capacity.controller;

import li.waterproof.capacity.Search;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

/**
 * @author Fail Mukhametdinov
 */
@Controller
@SessionAttributes("search")
public class CapacityController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
     public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject(new Search());
        return modelAndView;
    }

    @RequestMapping(value = "preview", method = RequestMethod.POST)
    public ModelAndView preview(@ModelAttribute Search search, BindingResult result) {
        // Временно устанавливаем дату вручную
        setDateTime(search);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", search.getDateTimeFrom());
        return modelAndView;
    }

    /**
     * todo - удалить!!!
     * @param search
     */
    private void setDateTime(Search search) {
        search.setDateTimeFrom(new Timestamp(1199145600000L));
        search.setDateTimeTo(new Timestamp(1230768000000L));
    }

}
