package Main.Dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

import static Main.Helpers.ApplicationManager.logWriter;

public class CancelWithResult extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField CancelTextField;


    CancelWithResult() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(200, 200);


        buttonOK.addActionListener(e -> {
            try {
                onOK();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        buttonCancel.addActionListener(e -> {
            try {
                onCancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    onCancel();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> {
            try {
                onCancel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public static void main(String[] args) {
        JDialog dialog = new CancelWithResult();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);


    }

    private void onOK() throws IOException {
        // add your code here

        dispose();
        System.exit(0);
        logWriter("CancelWithResult.Ok");


    }

    private void onCancel() throws IOException {
        // add your code here if necessary
        dispose();
        logWriter("CancelWithResult.Cancel");
    }
}
