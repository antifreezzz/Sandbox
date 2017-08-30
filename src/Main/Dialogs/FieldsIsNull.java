package Main.Dialogs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldsIsNull extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField NullTextField;


    public FieldsIsNull() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(350,100);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        FieldsIsNull dialog = new FieldsIsNull();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
