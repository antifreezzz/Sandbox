package Main;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:D:/myfin.db";

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

    public List<Transaction> getAllProducts() {

        // Statement используется для того, чтобы выполнить sql-запрос
        try (Statement statement = this.connection.createStatement()) {
            // В данный список будем загружать наши продукты, полученные из БД
            List<Transaction> transactions = new ArrayList<Transaction>();
            // В resultSet будет храниться результат нашего запроса,
            // который выполняется командой statement.executeQuery()
            ResultSet resultSet = statement.executeQuery("SELECT id, good, price, category_name FROM products");
            // Проходимся по нашему resultSet и заносим данные в products
            while (resultSet.next()) {
                transactions.add(new Transaction(resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Type"),
                        resultSet.getString("Cathegory"),
                        resultSet.getDouble("Sum"),
                        resultSet.getDate("date")));

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
    public void addProduct(Transaction transaction) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Transactions(`NAME`, `TYPE`, `CATHEGORY`, 'SUM', 'DATE') " +
                        "VALUES(?, ?, ?, ?, ?)")) {
            statement.setObject(1, transaction.Name);
            statement.setObject(2, transaction.Type);
            statement.setObject(3, transaction.Cathegory);
            statement.setObject(4, transaction.Sum);
            statement.setObject(5, transaction.date);
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