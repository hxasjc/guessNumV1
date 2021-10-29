import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class guessNumV1 extends javax.swing.JFrame {

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton guessButton;
    static JTextField entryField;
    static JLabel resultLabel;

    static int chosenNum;
    static int maxNum = 100;
    static int minNum = 1;

    private void initUI() {
        Dimension minimumSize = new Dimension(214, 131);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guess the Number");
        setMinimumSize(minimumSize);

        jLabel1 = new JLabel("Guess the number below:");

        jLabel2 = new JLabel("Number is between 1 and 100 inclusive.");

        entryField = new JTextField("Enter a number");

        guessButton = new JButton("Guess!");
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                guessButtonClicked(evt);
            }
        });

        resultLabel = new JLabel("");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(entryField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessButton)
                    .addComponent(resultLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(entryField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(guessButton)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(resultLabel)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public guessNumV1() {
        initUI();
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.-]+");
    }

    private static void guessButtonClicked(ActionEvent evt) {
        String input = entryField.getText();
        boolean isNumeric = isNumeric(input);
        if (isNumeric) {
            int inputNum = Integer.parseInt(input);
            if (inputNum < minNum || inputNum > maxNum) {
                resultLabel.setText("Out of bounds: number is between 1 and 100");
            } else if (inputNum > chosenNum) {
                resultLabel.setText("Chosen number is lower than inputted number");
            } else if (inputNum < chosenNum) {
                resultLabel.setText("Chosen number is higher than inputted number");
            } else if (inputNum == chosenNum) {
                resultLabel.setText("Correct number guessed! The number was " + chosenNum);
            }
        } else {
            resultLabel.setText("Not a number");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        chosenNum = rand.nextInt(100) + 1;
        System.out.println(chosenNum);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guessNumV1().setVisible(true);
            }
        });
    }
}