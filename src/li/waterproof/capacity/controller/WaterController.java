package li.waterproof.capacity.controller;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import li.waterproof.capacity.service.WaterService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
@Controller
@SessionAttributes("search")
public class WaterController {

    @Autowired
    WaterService waterService;

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

        List<Result> result1 = waterService.get(search);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", result1);
        return modelAndView;
    }

    @RequestMapping(value = "csv", method = RequestMethod.POST)
    public ModelAndView csv(@ModelAttribute Search search, BindingResult result) throws JRException {
        // Временно устанавливаем дату вручную
        setDateTime(search);

        List<Result> result1 = waterService.getCSV(search);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", result1);
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
