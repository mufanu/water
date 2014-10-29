package li.waterproof.capacity.service;

import li.waterproof.capacity.dao.WaterDao;
import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
@org.springframework.stereotype.Service
public class WaterServiceImpl implements WaterService {

    @Autowired
    WaterDao waterDao;

    @Override
    public List<Result> get(Search search) {
        List<Result> result = waterDao.get(search);
        return null;
    }
}
