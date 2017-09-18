package Main;

import org.sqlite.JDBC;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class DbHandler {


    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:src/Main/Data/dbcoins.s3db";

    // Используем шаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws SQLException {
        // Регистрируем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public List<Transaction> getAllTransactions() {


        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Transaction> transactions = new ArrayList<Transaction>();

            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT ID, NAME, TYPE, ACCOUNT, CATEGORY, SUM, DATE FROM Transactions");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                transactions.add(new Transaction(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getInt("Type"),
                        resultSet.getInt("Account"),
                        resultSet.getInt("Category"),
                        resultSet.getDouble("Sum"),
                        resultSet.getDate("Date")));

            }
            // Возвращаем наш список
            return transactions;

        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }

    // Добавление продукта в БД
    public void addTransaction(Transaction transaction) {
        Date date = new Date();
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Transactions('NAME', 'TYPE','ACCOUNT', 'CATEGORY', 'SUM', 'DATE') " +
                        "VALUES(?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, transaction.Name);
            statement.setObject(2, transaction.Type);
            statement.setObject(3, transaction.Account);
            statement.setObject(4, transaction.Category);
            statement.setObject(5, transaction.Sum);
            statement.setObject(6, date);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Удаление продукта по id
    public void deleteTransaction(int id) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Transactions WHERE id = ?")) {
            statement.setObject(1, id);
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}