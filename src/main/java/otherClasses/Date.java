package otherClasses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Date {
    protected int year;
    protected int month;
    protected int day;

    public void setYear(int year) {
        if(year>2021)
            this.year=2021;
        else this.year = Math.max(year, 1800);
    }

    public void setMonth(int month) {
        if(month>12)
            this.month=12;
        else this.month = Math.max(month, 1);
    }

    public void setDay(int day) {
        if(day>31)
            this.day=31;
        else this.day = Math.max(day, 1);
    }
}
