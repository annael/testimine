package school.data;

import org.junit.Test;

import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    @Test
    public void gets_length() {
        //given
        ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2021-01-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);

        //when
        long result = course.getWorkingDays();

        //then
        assertEquals(263L, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_exception_on_invalid_dates() {
        //given
        ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2019-02-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);

        //when
        course.getWorkingDays();
    }

    @Test
    public void gets_working_days() {
        //given
        ZonedDateTime startDate = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        ZonedDateTime endDate = ZonedDateTime.parse("2021-02-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(startDate, endDate);

        //when
        long result = course.getWorkingDays();

        //then
        assertEquals(284, result);
    }

}
