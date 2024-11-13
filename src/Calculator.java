
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addButton, subbButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, perButton, sqrtButton;
    JPanel panel;

    Font myfont = new Font("Serif", Font.BOLD, 20);

    double num1 = 0, num2 = 0, num3 = 100, result = 0;
    char operators;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 480);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 200, 50);

        textField.setFont(myfont);
        textField.setEditable(true);

        addButton = new JButton("+");
        subbButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("←");
        clrButton = new JButton("C");
        perButton = new JButton("%");
        sqrtButton = new JButton("√");

        functionButtons[0] = addButton;
        functionButtons[1] = subbButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = perButton;
        functionButtons[9] = sqrtButton;

        for (int i = 0; i < 10; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(25, 100, 250, 300);
        panel.setLayout(new GridLayout(5, 4, 10, 10));

        panel.add(clrButton);
        panel.add(perButton);
        panel.add(sqrtButton);
        panel.add(divButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subbButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(delButton);
        panel.add(equButton);

        // Menu bar
        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("View");
        MenuItem mi = new MenuItem("We Are");
        m1.add(mi);

        Menu m2 = new Menu("Help");
        MenuItem mi2 = new MenuItem("Update");
        MenuItem mi3 = new MenuItem("Whats New");

        m2.add(mi2);
        m2.add(mi3);

        mb.add(m1);
        mb.add(m2);

        frame.setMenuBar(mb);

      //  frame.setVisible(true);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat(String.valueOf(".")));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operators = '+';
            textField.setText("");
        }
        if (e.getSource() == subbButton) {
            num1 = Double.parseDouble(textField.getText());
            operators = '-';
            textField.setText("");

        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operators = '*';
            textField.setText("");
        }
        if (e.getSource() == perButton) {
            num1 = Double.parseDouble(textField.getText());
            operators = '%';
            textField.setText(String.valueOf(num1 / 100));
        }

        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText(String.valueOf(Math.sqrt(num1)));
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operators = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operators) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;

            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText() + string.charAt(i));

            }
        }
    }
}
