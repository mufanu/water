package li.waterproof.capacity.dao;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Fail Mukhametdinov
 */
@Repository
public class WaterDaoImpl implements WaterDao {

    @Autowired
    DataSource dataSource;

    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Override
    public List<Result> get(Search search) {

        return getJdbcTemplate().query("SELECT employee_key, employee_id FROM employee",
                new RowMapper<Result>() {
                    @Override
                    public Result mapRow(ResultSet resultSet, int i) throws SQLException {
                        Result result = new Result();
                        result.setEmployeeKey(resultSet.getString("employee_key"));
                        result.setCapacity(resultSet.getInt("employee_id"));
                        return result;
                    }
                }
        );
    }
}
