package age.agecalculator;

import age.agecalculator.view.AgeCalculatorUI;

import javax.swing.*;

/**
 * The main class that contains one method to run the GUI
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class AgeCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculatorUI();
            }
        });
    }
}
