/**
package ru.geekbrains.java.for_testing.lesson2;

import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriter extends AppData {

    private String[] header;
    private int[][] data;

    public CsvWriter(String fileName) {
        super(fileName);
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


    /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////

//    static void csvWriter() {
//        try (PrintWriter out = new PrintWriter("testNameAndSurname.csv")) {
//            out.println("id;Name;Patronymic;Surname;date of birth");
//            out.println("1;Ivan;Ivanovich;Ivanov;01.02.1980");
//            out.println("2;Petr;Petrovich;Petrov;31.05.1999");
//            out.println("3;Oleg;Olegovich;Olegov;22.02.1995");
//            //out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    static void testCsvWriter() {
        try (PrintWriter out = new PrintWriter("test.csv")) {
            out.println("id;Value 1;Value 2;Value 3;Value 4");
            out.println("1;100;200;300;400");
            out.println("2;999;888;777;666");
            out.println("3;123;456;789;159");
            //out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static List<User> readUsersFromFile(String filename) {
//        List<User> users = new ArrayList<>();
//        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
//            String str = in.readLine();
//            while ((str = in.readLine()) != null) {
//                String[] tokens = str.split(";");
//                users.add(new User(Long.parseLong(tokens[0]), tokens[1], tokens[2]));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }


//        //private static void csvWriter() {
//
//        try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
//
//            StringBuilder sb = new StringBuilder();
//            sb.append("id");
//            sb.append(';');
//            sb.append("Name");
//            sb.append(';');
//            sb.append("Surname");
//            sb.append(';');
//            sb.append("Patronymic");
//            sb.append("date of birth");
//            sb.append('\n');
//
//            sb.append("1");
//            sb.append(';');
//            sb.append("Ivan");
//            sb.append(';');
//            sb.append("Ivanovich");
//            sb.append(';');
//            sb.append("Ivanov");
//            sb.append(';');
//            sb.append("01.02.1980");
//            sb.append('\n');
//
//            sb.append("2");
//            sb.append(';');
//            sb.append("Petr");
//            sb.append(';');
//            sb.append("Petrovich");
//            sb.append(';');
//            sb.append("Petrov");
//            sb.append(';');
//            sb.append("31.05.1999");
//            sb.append('\n');
//
//            sb.append("3");
//            sb.append(';');
//            sb.append("Oleg");
//            sb.append(';');
//            sb.append("Olegovich");
//            sb.append(';');
//            sb.append("Olegov");
//            sb.append(';');
//            sb.append("22.02.1995");
//            sb.append('\n');
//
//            writer.write(sb.toString());
//
//            System.out.println("done!");
//
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//      }

}
*/
