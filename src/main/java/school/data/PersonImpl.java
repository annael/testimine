package school.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class PersonImpl implements Person {

    private String name;
    private ZonedDateTime dateOfBirth;

    public String getName() {
        return this.name;
    }

    public ZonedDateTime getDateOfBirth() {
        return this.dateOfBirth;
    }

    public Long getAge() {



        return ChronoUnit.YEARS.between(this.dateOfBirth, ZonedDateTime.now());
    }


}
