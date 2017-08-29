package Dialogs;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Dialog1 extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addButton;
    private JButton clearButton;
    private int Field3Flag = 0;
    public int CWR;


    public Dialog1() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300, 300);


        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAdd();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClear();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onClear() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");

    }

    private void onAdd() {
        if (Objects.equals(textField1.getText(), "") || Objects.equals(textField2.getText(), "")){
            FieldsIsNull fieldsIsNull = new FieldsIsNull();
            fieldsIsNull.setVisible(true);
        } else {
        float num1, num2, result;
        num1 = Float.parseFloat(textField1.getText());
        num2 = Float.parseFloat(textField2.getText());
        result = num1 + num2;
        textField3.setText(String.valueOf(result));

        }
    }

    private void onOK() {

        try  {
            if (! Objects.equals(textField3.getText(), ""))
{

            FileWriter writer = new FileWriter("src/Data/results.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(String.valueOf(Float.parseFloat(textField3.getText())) + "\n");

            bufferedWriter.close();
            dispose();}
            else dispose();

        } catch (IOException ex) {

            dispose();
        }

    }

    private void onCancel() {

        if (! Objects.equals(textField3.getText(), "")) {
            CancelWithResult cancelWithResult = new CancelWithResult();
            cancelWithResult.setVisible(true);
        } else dispose();


    }

    public static void main(String[] args) {
        Dialog1 dialog = new Dialog1();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
