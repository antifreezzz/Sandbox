package Main.Helpers;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Klementyev on 30.08.2017.
 */
public class ApplicationManager {
    public static void bufferedWriter(String fileName, JTextField textField3) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        DateFormat df = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = String.valueOf(df.format(today));

        sendToFile(bufferedWriter, String.valueOf(reportDate + "   " + Float.parseFloat(textField3.getText())) + "\n");
    }

    private static void sendToFile(BufferedWriter bufferedWriter, String str) throws IOException {
        bufferedWriter.write(str);

        bufferedWriter.close();
    }

    public static void logWriter(String action) throws IOException {
        String fileName = "src/Main/Data/log.txt";
        FileWriter writer = new FileWriter(fileName, true);
        BufferedWriter logWriter = new BufferedWriter(writer);
        DateFormat df = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd");
        Date today = Calendar.getInstance().getTime();
        String reportDate = String.valueOf(df.format(today));
        sendToFile(logWriter, reportDate + "    " + action + "\n");
    }
}
