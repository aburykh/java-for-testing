package ru.geekbrains.java.for_testing.lesson2;

import java.io.*;
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
            // String[] header
            String str = in.readLine();
            this.header = str.split(";");

            while ((str = in.readLine()) != null) {
                dataArrList.add(str.split(";"));
            }
            for (String title : header) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // int[][] data
        this.data = new int[dataArrList.size()][header.length];
        for (int j = 0; j < dataArrList.size(); j++) {
            for (int i = 0; i < header.length; i++) {
                data[j][i] = Integer.parseInt(dataArrList.get(j)[i].trim());
            }
        }
    }

    public void printData() {
        for (String title : header) {
            System.out.print(title + "\t");
        }
        System.out.println();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < header.length; j++) {
                System.out.print(data[i][j] + "\t");
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
        try (PrintWriter out = new PrintWriter(new FileOutputStream(fileName), true)) {

            // String[] header
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < header.length - 1; ++i) {
                sb.append(header[i]).append(";");
            }
            sb.append(header[header.length - 1]).append("\n");
            out.print(sb.toString());

            // int[][] data
            for (int[] dataArray : data) {
                sb.setLength(0);
                for (int i = 0; i < dataArray.length - 1; ++i) {
                    sb.append(dataArray[i]).append(";");
                }
                sb.append(dataArray[dataArray.length - 1]).append("\n");
                out.print(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
