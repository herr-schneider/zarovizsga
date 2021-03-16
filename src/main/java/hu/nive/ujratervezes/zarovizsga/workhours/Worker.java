package hu.nive.ujratervezes.zarovizsga.workhours;

import java.time.LocalDate;

public class Worker {
    private String name;
    private int workedHours;
    private String workingDay;

    public Worker() {
    }

    public Worker(String name, int workedHours, String workingDay) {
        this.name = name;
        this.workedHours = workedHours;
        this.workingDay = workingDay;
    }

    public String getName() {
        return name;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    @Override
    public String toString() {
        return  name + ": " + workingDay;
    }
}
