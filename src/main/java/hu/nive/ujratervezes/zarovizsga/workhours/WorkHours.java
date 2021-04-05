package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            ioe.printStackTrace();
            throw new IllegalArgumentException("File not found", ioe);
        }
    }

    private void initDBDate2(String file) {
        Scanner scanner = new Scanner(System.in);
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Path filename = Path.of(file);

        try (BufferedReader bf = Files.newBufferedReader(filename)) {
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            String dateLine = bf.readLine();
            LocalDate localDate_1 = LocalDate.parse(dateLine, formatter);
        }catch (IOException ioe){
            throw new IllegalStateException();
        }
    }
}
