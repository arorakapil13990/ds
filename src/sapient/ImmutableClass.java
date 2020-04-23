package sapient;

import java.util.Date;

public final class ImmutableClass {

    private String name;
    private Date date;

    public Date getDate() {
        return new Date(date.getTime());
    }

    public String getName() {
        return name;
    }
}
