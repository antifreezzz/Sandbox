package Main;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Tranz {
    public static void main(String[] args) {
        try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();
            // Добавляем запись
            dbHandler.addTransaction(new Transaction("Name",1,1,2,10000.00));
            // Получаем все записи и выводим их на консоль
            List<Transaction> transactions = dbHandler.getAllTransactions();
            for (Transaction transaction : transactions) {
                System.out.println(transaction.toString());
            }
            // Удаление записи с id = 8
            //dbHandler.deleteProduct(8);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}