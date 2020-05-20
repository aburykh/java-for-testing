/**
package ru.geekbrains.java.for_testing.lesson2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private String[] header;
    private int[][] data;

//    public CsvReader(String fileName) {
//        super(fileName);
//    }

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
                data[j][i] = Integer.parseInt(dataArrList.get(j)[i].trim());
                System.out.print(data[j][i] + "\t");
            }
            System.out.println();
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

    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

//    static void testCsvReader(String fileName) {
//        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
//            String str = null;
//            while ((str = in.readLine()) != null)
//                System.out.println(str);
////            {
////                //String[] values = str.split(";");
////                System.out.println(str);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
*/
