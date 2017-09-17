package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper
{
    public void DateHelper()
    {
        Date d = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("День dd Месяц MM Год yyyy");
        System.out.println(format1.format(d)); // 25.02.2013 09:03
        System.out.println(format2.format(d)); // День 25 Месяц 02 Год 2013 Время 09:03
    }
}
