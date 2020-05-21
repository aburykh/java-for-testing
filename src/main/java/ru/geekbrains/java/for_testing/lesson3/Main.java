package ru.geekbrains.java.for_testing.lesson3;

/**
 * 1. Создать таблицу с пользователями (users). У пользователя есть следующие поля: id, имя, возраст, email;
 * 2. Написать метод, распечатывающий в консоль всю информацию обо всех пользователях из таблицы;
 * 3. Написать метод вывода в консоль пользователей, возраст которых находится в пределах min-max (public void showUsersByAge(int min, int max));
 * 4. Написать метод удаления пользователя по имени;
 * 5. Написать метод добавления пользователя в таблицу users из строки вида “имя возраст email”. Например, “Bob 32 bob32@gmail.com”.
 */

import java.sql.*;


public class Main {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect("jdbc:sqlite:jdbc.db");
            dropTable("users");
//            clearTable("users");
            createTableEx("users","id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, email VARCHAR");
            prepareStatements("INSERT INTO users (name, age, email) VALUES (?, ?, ?);");
            psInsertEx();
//            fillTableAndTransactionEx();

            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>\nSelect * from users;\n");
            readAll("select * from users;");

            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>\nDelete from users where name like 'bob2';\n");
            deleteUserByName("users","'bob2'");
            System.out.println("User has been deleted successfully\n");

            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>\nSelect * from users where age between 20 and 45;\n");
            showUsersByAge("users",20, 45);

            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>\nInsert into users (name, age, email) values ('bob5000','101','bobmail@123.ru');\n");
            addUser("users","'bob5000','101','bobmail@123.ru'");
            System.out.println("User has been added successfully:");
            readNewUser("users","where id >= 51");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }

    }

    private static int clearTable(String tableName) throws SQLException {
        return statement.executeUpdate("DELETE FROM " + tableName + ";");
    }

    private static void psInsertEx() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 0; i < 50; i++) {
            psInsert.setString(1, "Bob" + (i + 1));
            psInsert.setInt(2, (i * 10) % 100 + 10);
            psInsert.setString(3, ((i + 1) + "mail@123.ru"));
            psInsert.executeUpdate();
        }
        connection.setAutoCommit(true);
    }

    // * 1. Создать таблицу с пользователями (users). У пользователя есть следующие поля: id, имя, возраст, email;
    private static void createTableEx(String tableName, String parametersOfTable) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " (" + parametersOfTable + ");");
    }

    public static void prepareStatements(String insertQuery) throws SQLException {
        psInsert = connection.prepareStatement(insertQuery);
    }

    private static void fillTableAndTransactionEx() throws SQLException {
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 0; i < 50; i++) {
            statement.executeUpdate(String.format("INSERT INTO users (name, age, email) VALUES ('%s', %d, '%s');",
                    "Bob" + (i + 1),
                    (i * 10) % 100 + 10,
                    ((i + 1) + "mail@123.ru")));
        }
        connection.setAutoCommit(true);
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS " + tableName + ";");
    }


    private static void getMetaAndPrint(String query) throws SQLException {
        try (ResultSet rs = statement.executeQuery(query)) {
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            System.out.printf(resultSetMetaData.getColumnName(1)
                    + "\t" + resultSetMetaData.getColumnName(2)
                    + "\t" + resultSetMetaData.getColumnName(3)
                    + "\t" + resultSetMetaData.getColumnName(4) + "\n");

            while (rs.next()) {
                System.out.println(rs.getInt(1)
                        + "\t" + rs.getString("name")
                        + "\t" + rs.getInt(3)
                        + "\t" + rs.getString("email"));
            }
        }
    }

    // * 2. Написать метод, распечатывающий в консоль всю информацию обо всех пользователях из таблицы;
    private static void readAll(String query) throws SQLException {
        getMetaAndPrint(query);
    }

    // * 3. Написать метод вывода в консоль пользователей, возраст которых находится в пределах min-max (public void showUsersByAge(int min, int max));
    public static void showUsersByAge(String tableName, int min, int max) throws SQLException {
        getMetaAndPrint("select * from " + tableName + " where age between " + min + " and " + max + ";");
    }

    // * 4. Написать метод удаления пользователя по имени;
    private static void
    deleteUserByName(String tableName, String name) throws SQLException {
        statement.executeUpdate("delete from " + tableName + " where name like " + name + ";");
    }

    // * 5. Написать метод добавления пользователя в таблицу users из строки вида “имя возраст email”. Например, “Bob 32 bob32@gmail.com”.
    private static void addUser(String tableName, String parameters) throws SQLException {
        statement.executeUpdate("insert into " + tableName + " (name, age, email) values (" + parameters + ");");
    }

    private static void readNewUser(String tableName, String conditions) throws SQLException {
        getMetaAndPrint("select * from " + tableName + " " + conditions + ";");
    }


    public static void connect(String dbUrl) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(dbUrl);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Connect is failed");
        }
    }

    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (psInsert != null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}