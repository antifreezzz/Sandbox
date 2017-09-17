package Main;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.Date;

public class Transaction {
    public int ID;
    public String Name;
    public String Type;
    public String Cathegory;
    public double Sum;
    public DateHelper date;

    public Transaction(String Name, String Type, String Cathegory, double Sum){
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Cathegory = Cathegory;
        this.Sum = Sum;
        this.date = date;
    }

    @Override
    public String toString(){
        return String.format("ID: %s | Имя: %s | Тип: %s | Категория: %s | Сумма: %s | Дата: %s ",
                this.ID, this.Name, this.Type, this.Cathegory, this.Sum, this.date);
    }
}
