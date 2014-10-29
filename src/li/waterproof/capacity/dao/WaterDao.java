package li.waterproof.capacity.dao;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;

import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
public interface WaterDao {
    List<Result> get(Search search);
}
