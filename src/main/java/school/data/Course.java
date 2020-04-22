package school.data;

import school.services.PublicHolidayService;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Course {

    private String name;
    private Teacher teacher;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    private PublicHolidayService publicHolidayService = new PublicHolidayService();

    public Course(ZonedDateTime startDate, ZonedDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public long getWorkingDays() {
        if (endDate.isAfter(startDate)) {

            final int startW = startDate.getDayOfWeek().getValue();
            final int endW = endDate.getDayOfWeek().getValue();

            final long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
            long result = days - 2*(days/7); //remove weekends

            if (days % 7 != 0) { //deal with the rest days
                if (startW == 7) {
                    result -= 1;
                } else if (endW == 7) {  //they can't both be Sunday, otherwise rest would be zero
                    result -= 1;
                } else if (endW < startW) { //another weekend is included
                    result -= 2;
                }
            }

            publicHolidayService.getPublicHolidays("2019");

            return result;
        } else {
            throw new IllegalArgumentException("wtf");
        }
    }


}
