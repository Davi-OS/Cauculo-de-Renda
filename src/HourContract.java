import java.text.DateFormat;
import java.util.Date;

public class HourContract {
    Date date;
    Double valuePerHour;
    int hours;

    public HourContract(Date date, Double valuePerHour, int h) {
        this.hours = h;
        this.date = date;
        this.valuePerHour = valuePerHour;
    }

    public double totalValue() {
        return valuePerHour * hours;
    }

    public Date getDate() {
        return date;
    }
}
