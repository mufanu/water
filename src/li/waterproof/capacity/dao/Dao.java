package li.waterproof.capacity.dao;

import li.waterproof.capacity.Result;
import li.waterproof.capacity.Search;

/**
 * @author Fail Mukhametdinov
 */
public interface Dao {
    Result get(Search search);
}
