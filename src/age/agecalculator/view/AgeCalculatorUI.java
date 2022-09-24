package age.agecalculator.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * A class that displays the GUI for the Age Calculator using java swing
 *
 * @author Daven Chohan, ID: 301401324, Email: dca120@sfu.ca
 */

public class AgeCalculatorUI implements ActionListener{
    JFrame applicationFrame;
    JPanel mainPanel;
    JButton ageButton;
    JPanel agePanel;
    JLabel ageLabel;
    JPanel bottomPanel;
    DatePicker datePicker;
    DatePickerSettings datePickerSettings;

    public AgeCalculatorUI() {
        applicationFrame = new JFrame("Age Calculator");
        applicationFrame.setSize(new Dimension(450, 200));

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        agePanel = new JPanel();
        agePanel.setPreferredSize(new Dimension(agePanel.getPreferredSize().width, 100));
        agePanel.setMaximumSize(new Dimension(450, 100));
        ageLabel = new JLabel("Enter your date of birth and press the \"Check Age\" button.");
        Border borderTasks = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20,20,20,20), BorderFactory.createTitledBorder("Your age as of today"));
        agePanel.setBorder(borderTasks);
        ageLabel.setBorder(BorderFactory.createEmptyBorder(3,0,0,0));
        agePanel.add(ageLabel);
        mainPanel.add(agePanel);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        datePickerSettings = new DatePickerSettings();
        LocalDate currentTime = LocalDate.now();
        datePicker = new DatePicker(datePickerSettings);
        datePickerSettings.setDateRangeLimits(null, currentTime);
        datePicker.setMaximumSize(new Dimension(155, datePicker.getPreferredSize().height));
        bottomPanel.add(datePicker);
        ageButton = new JButton("Check Age");
        ageButton.addActionListener(this);
        bottomPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        bottomPanel.add(ageButton);
        mainPanel.add(bottomPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        applicationFrame.add(mainPanel);
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String date = datePicker.getDateStringOrEmptyString();
        if (date.isBlank()){
            JOptionPane.showMessageDialog(applicationFrame, "Please provide a date.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        else {
            int birthMonth = Integer.parseInt(date.substring(5, 7));
            int birthDay = Integer.parseInt(date.substring(8, 10));
            LocalDate currentTime = LocalDate.now();
            LocalDate birthDate = datePicker.getDate();
            int age = birthDate.until(currentTime).getYears();
            String outputText = "You are " + age + " years old!";
            if (birthMonth == currentTime.getMonthValue() && birthDay == currentTime.getDayOfMonth()) {
                if (age > 0){
                    outputText = "You have just turned " + age + " years old! Happy Birthday!!";
                }
                else {
                    outputText = "You are " + age + " years old! Happy Birthday!!";
                }
            }
            ageLabel.setText(outputText);
        }
    }
}

