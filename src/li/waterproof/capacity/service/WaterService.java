package li.waterproof.capacity.service;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;

import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
public interface WaterService {
    List<Result> get(Search search);
}
