package li.waterproof.capacity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Fail Mukhametdinov
 */
public class Search implements Serializable {
    private Date dateTimeFrom;
    private Date dateTimeTo;

    public Date getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(Timestamp dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public Date getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(Timestamp dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }
}
