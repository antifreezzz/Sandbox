package Tests;

import Main.Dialogs.CancelWithResult;
import Main.Dialogs.Dialog1;
import Main.Dialogs.FieldsIsNull;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.TestNGAntTask.Mode.testng;

/**
 * Created by Klementyev on 30.08.2017.
 */
public class Testo extends Dialog1 {
    @Test
    public void Test1(){
        onClear();
        textField1.setText("10");
        textField2.setText("15");
        onAdd();
        assertEquals(textField3.getText(),"25.0");

    }
    @Test
    public void Test2() throws Throwable {
        onClear();
        textField1.setText("15");
        onAdd();
        assertEquals(textField3.getText(),"");
        FieldsIsNull.W(setVisible(false));
        FieldsIsNull.

    }
}
