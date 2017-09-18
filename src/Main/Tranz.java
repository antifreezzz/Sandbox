package Main;

import java.sql.SQLException;
import java.util.List;

public class Tranz {
    public static void tranz(String name, int type, int account, int category, double sum) {
        try {
            // Создаем экземпляр по работе с БД
            DbHandler dbHandler = DbHandler.getInstance();
            // Добавляем запись
            dbHandler.addTransaction(new Transaction(name, type, account, category, sum));
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
    public static void trans(){
        try{
            DbHandler dbHandler = DbHandler.getInstance();
            List<Transaction> transactions = dbHandler.getAllTransactions();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}