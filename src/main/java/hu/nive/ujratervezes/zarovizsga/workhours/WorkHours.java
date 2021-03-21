package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {
    private List<Worker> workers = new ArrayList<>();

    public String minWork(String file) {
        initDB(file);
        return proccess();
    }

    public String minWork2(String file) {
        initDBDate(file);
        return proccess();
    }

    private String proccess() {
        Worker result = new Worker();
        int max = 10; // Integer.MAX_VALUE
        for (Worker worker : workers) {
            if (worker.getWorkedHours() < max) {
                max = worker.getWorkedHours();
                result = worker;
            }
        }
        return result.toString();
    }

    private void initDB(String file) {
        Path filename = Path.of(file);
        try (BufferedReader bf = Files.newBufferedReader(filename)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] temp = line.split(",");
                String name = temp[0];
                int workedHours = Integer.parseInt(temp[1]);
                String date = temp[2];
                workers.add(new Worker(name, workedHours, date));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
    }

    private void initDBDate(String file) {
        Path filename = Path.of(file);
        try (BufferedReader bf = Files.newBufferedReader(filename)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] temp = line.split(",");
                String name = temp[0];
                int workedHours = Integer.parseInt(temp[1]);
                String[] dateStr = temp[2].split("-");
                LocalDate date = LocalDate.of(
                        Integer.parseInt(dateStr[0]),
                        Integer.parseInt(dateStr[1]),
                        Integer.parseInt(dateStr[2]));
                workers.add(new Worker(name, workedHours, date));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("File not found", ioe);
        }
    }
}
