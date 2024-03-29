import entities.enums.WorkLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Worker {
    String name;
    WorkLevel level;
    Double baseSalary;
    List<HourContract> contractList;

    Departament departament;

    public Worker(String name, WorkLevel level, Double baseSalary, Departament departament) {
        contractList = new ArrayList<>();
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
    }

    public void addControct(HourContract contract) {
        contractList.add(contract);
    }

    public void removeControct(HourContract contract) {
        contractList.remove(contract);
    }

    public double income(int year, int month) {
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contractList) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (c_month == month && c_year == year) {
                sum += c.totalValue();
            }
        }
        return sum;
    }


}
