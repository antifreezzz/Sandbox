package Main;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    public int ID;
    public String Name;
    public int Type;
    public int Account;
    public int Category;
    public double Sum;
    public Date date;

    public Transaction(int ID, String Name, int Type, int Account, int Category, double Sum, Date date){
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Account = Account;
        this.Category = Category;
        this.Sum = Sum;
        this.date = date;
    }

    public Transaction(String Name,int Type, int Account, int Category, double Sum){
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Account = Account;
        this.Category = Category;
        this.Sum = Sum;
        this.date = date;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Имя: %s | Тип: %s | Счёт: %s | Категория: %s | Сумма: %s | Дата: %s ",
                this.ID, this.Name, this.Type, this.Account, this.Category, this.Sum, this.date);
    }
}
