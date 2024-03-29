import entities.enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner ler = new Scanner(System.in);
        String dpName;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        int nContracts;
        System.out.println("Enter department's name:");
        dpName = ler.next();
        Departament dp = new Departament(dpName);

        System.out.println("Enter Worker Data:");
        System.out.println("Worker's name:");
        String wName = ler.next();
        System.out.println("Worker's level:");
        String teste = ler.next();
        WorkLevel level = WorkLevel.valueOf(teste);
        System.out.println("Worker's base Salary:");
        Double bSalary = ler.nextDouble();
        Worker w = new Worker(wName, level, bSalary, dp);

        System.out.println("How many contracts to this worker?");
        nContracts = ler.nextInt();

        for (int i = 0; i < nContracts; i++) {
            System.out.println("Enter contract #" + i);
            System.out.printf("Date(DD/MM/YYYY): ");
            d = sdf.parse(ler.next());

            System.out.printf("Value per hour:");
            double vph = ler.nextDouble();
            System.out.printf("Duration (hours):");
            int HH = ler.nextInt();
            w.addControct(new HourContract(d, vph, HH));

        }

        System.out.println("Enter month and year to calculate income (mm/yyyy):");
        String monthAndYear = ler.next();
        int income_month = Integer.parseInt(monthAndYear.substring(2));
        int income_year = Integer.parseInt(monthAndYear.substring(2, 6));

        System.out.println("Name: " + w.name);
        System.out.println("Departament: " + w.departament);
        System.out.println("Income for " + monthAndYear + ":" + String.format("%.2f", w.income(income_year, income_month)));

    }
}