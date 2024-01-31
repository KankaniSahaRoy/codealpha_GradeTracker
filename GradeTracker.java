/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codealpha;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradeTracker extends JFrame implements ActionListener {

    private final ArrayList<Double> grades = new ArrayList<>();
    private final JTextField studentsField = new JTextField(10);
    private final JTextField idfield = new JTextField(10);
    private final JTextArea displayArea = new JTextArea(20,30);

    public GradeTracker() {
        setTitle("Student Grades Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(5, 5));
        JLabel idlevel = new JLabel("Enter students department");
        inputPanel.add(idlevel);
        inputPanel.add(idfield);
        JLabel studentsLabel = new JLabel("Enter number of students:");
        inputPanel.add(studentsLabel);
        inputPanel.add(studentsField);
        idfield.setBackground(Color.pink);
        studentsField.setBackground(Color.pink);
        
        
        
        
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        
        displayArea.setBackground(Color.pink);
        calculateButton.setBackground(Color.GRAY);

        add(inputPanel, BorderLayout.WEST);
        
        add(calculateButton, BorderLayout.CENTER);
        add(new JScrollPane(displayArea), BorderLayout.EAST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate")) {
            grades.clear();
            displayArea.setText("");
            int numStudents = Integer.parseInt(studentsField.getText());

            for (int i = 1; i <= numStudents; i++) {
                String gradeString = JOptionPane.showInputDialog("Enter grade for student " + i + ":");
                try {
                    double grade = Double.parseDouble(gradeString);
                    grades.add(grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
                    return;
                }
            }

            if (!grades.isEmpty()) {
                double sum = 0;
                double lowest = grades.get(0);
                double highest = grades.get(0);

                for (double grade : grades) {
                    sum += grade;
                    if (grade < lowest) {
                        lowest = grade;
                    }
                    if (grade > highest) {
                        highest = grade;
                    }
                }

                double average = sum / grades.size();

                displayArea.append("Average: " + average + "\n");
                displayArea.append("Lowest score: " + lowest + "\n");
                displayArea.append("Highest score: " + highest + "\n");
            }
        }
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(GradeTracker::new);
    }
}
