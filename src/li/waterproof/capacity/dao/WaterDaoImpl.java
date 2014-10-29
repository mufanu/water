package li.waterproof.capacity.dao;

import li.waterproof.capacity.model.Result;
import li.waterproof.capacity.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

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

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Result> get(Search search) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("dateTimeFrom", search.getDateTimeFrom())
                .addValue("dateTimeTo", search.getDateTimeTo());

        List<Map<String, Object>> maps = getNamedParameterJdbcTemplate().queryForList("SELECT *\n" +
                        "FROM employee e\n" +
                        "  JOIN schedule s ON e.employee_id = s.employee_id\n" +
                        "  where s.startdatetime >= :dateTimeFrom and s.enddatetime <= :dateTimeTo",
                parameterSource);
        maps.size();
        return null;
    }
}
