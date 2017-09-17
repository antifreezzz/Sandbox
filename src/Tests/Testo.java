package Tests;

import Main.Dialogs.Dialog1;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Klementyev on 30.08.2017.
 */
public class Testo extends Dialog1 {
    @Test
    public void Test1() throws IOException {
        try {
            onClear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textField1.setText("10");
        textField2.setText("15");
        onAdd();
        assertEquals(textField3.getText(), "25.0");

    }

    @Test(enabled = false)
    public void Test2() throws Throwable {
        onClear();
        textField1.setText("15");
        onAdd();
        assertEquals(textField3.getText(), "");
/*        FieldsIsNull.W(setVisible(false));
        FieldsIsNull.*/

    }
}
