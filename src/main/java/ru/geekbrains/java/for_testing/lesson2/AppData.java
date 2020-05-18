package ru.geekbrains.java.for_testing.lesson2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String fileName) {
        this.csvReader(fileName);
    }

    public void csvReader(String fileName) {
        List<String[]> dataArrList = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str = in.readLine();
            this.header = str.split(";");
            while ((str = in.readLine()) != null) {
                dataArrList.add(str.split(";"));
            }
            for (String title : header) {
                System.out.print(title + "\t");
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println("тело");
        this.data = new int[dataArrList.size()][header.length];
        for (int j = 0; j < dataArrList.size(); j++) {
            for (int i = 0; i < header.length; i++) {
                data[j][i] = Integer.parseInt(dataArrList.get(j)[i]);
                System.out.print(data[j][i] + "\t");
            }
            System.out.println();
        }
    }

    public void testCsvReader(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str = null;
            while ((str = in.readLine()) != null)
                System.out.println(str);
//            {
//                String[] values = str.split(";");
//                System.out.println(str);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void csvWriter(String fileName) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            String dataHeader = this.header[0];
            // String[] header
            for (int i = 1; i < this.header.length; i++) {
                dataHeader += ";" + this.header[i];
            }
            out.println(dataHeader);
            // int[][] data
            for (int i = 0; i < this.data.length; i++) {
                String data = String.valueOf(this.data[i][0]);
                for (int j = 1; j < this.header.length; j++) {
                    data += ";" + this.data[i][j];
                }
                out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
