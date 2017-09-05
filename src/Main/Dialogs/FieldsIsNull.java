package Main.Dialogs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static Main.Helpers.ApplicationManager.logWriter;

public class FieldsIsNull extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField NullTextField;


    public FieldsIsNull() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(350, 100);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) throws IOException {
        FieldsIsNull dialog = new FieldsIsNull();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
        logWriter("FieldsIsNull.setVisible");
    }

    public static Window[] getWindows() {

        return new Window[0];
    }

    protected void onOK() throws IOException {
        // add your code here
        dispose();
        logWriter("FieldsIsNull.Ok");
    }
}
