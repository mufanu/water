package li.waterproof.capacity.service;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import net.sf.jasperreports.engine.JRException;

import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
public interface WaterService {
    List<Result> get(Search search);

    List<Result> getCSV(Search search) throws JRException;
}
