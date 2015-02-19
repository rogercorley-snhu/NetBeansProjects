/*******************************************************************************
* Design a GUI program to find the weighted average of four test scores.  
* The four test scores and their respective weights are given in the 
* following format:     testscore1 weight1
* 
* For example, the sample data is as follows:
*       75 0.20
*       95 0.35
*       85 0.15
*       65 0.30
* 
* The user is supposed to enter the data and press a Calculate button.  
* The program must display the weighted average.
*******************************************************************************/

package it145_week06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IT145_Week06 extends JFrame {

    private JLabel lbl_Grades, lbl_Weights;
    private JLabel lbl_FinalGrade, lbl_CalcGrade;
    private JButton calculateB, exitB;
    
    private CalculateButtonHandler cbHandler;
    private ExitButtonHandler ebHandler;
    
    private int WIDE = 600;
    private int TALL = 300;

//    private final JLabel[] lbl_Blank = new JLabel[7];
    private final JTextField[] jtf_Exam = new JTextField[4];
    private final JTextField[] jtf_Weight = new JTextField[4];
    
    public IT145_Week06() {
        //  CREATE LABELS
        lbl_Grades = new JLabel("GRADES");
        lbl_Weights = new JLabel("WEIGHTS");
        lbl_FinalGrade = new JLabel("FINAL GRADE");
        lbl_CalcGrade = new JLabel("");
        
        // CREATE TEXTFIELDS
        
        /*
        for (int b = 0; b < lbl_Blank.length; b++) {
             lbl_Blank[b] = new JLabel("");
        }
        */
        
        for (int i = 0; i < jtf_Exam.length; i++) {
            jtf_Exam[i] = new JTextField("");
            jtf_Weight[i] = new JTextField("");
        }
        
        //  CREATE CALCULATE BUTTON
        calculateB = new JButton("CALCULATE");
        cbHandler = new CalculateButtonHandler();
        calculateB.addActionListener(cbHandler);
        
        //  CREATE EXIT BUTTON
        exitB = new JButton("EXIT");
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
        
        //  WINDOW PROPERTIES
        setTitle("IT-145 : Grade Calculator");
        Container appWindow = getContentPane();
        appWindow.setLayout(new GridLayout (7, 2));
        setSize(WIDE, TALL);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //  ADD COMPONENTS IN APPWINDOW
//        appWindow.add(lbl_Blank[0]);
            appWindow.add(lbl_Grades);
            appWindow.add(lbl_Weights);    
//        appWindow.add(lbl_Blank[1]);
            appWindow.add(jtf_Exam[0]);
            appWindow.add(jtf_Weight[0]);
//        appWindow.add(lbl_Blank[2]);
            appWindow.add(jtf_Exam[1]);
            appWindow.add(jtf_Weight[1]);
//        appWindow.add(lbl_Blank[3]);
            appWindow.add(jtf_Exam[2]);
            appWindow.add(jtf_Weight[2]);
//        appWindow.add(lbl_Blank[4]);
            appWindow.add(jtf_Exam[3]);
            appWindow.add(jtf_Weight[3]);
//        appWindow.add(lbl_Blank[5]);
            appWindow.add(lbl_FinalGrade);
            appWindow.add(lbl_CalcGrade);
//        appWindow.add(lbl_Blank[6]);
            appWindow.add(calculateB);
            appWindow.add(exitB);
    }
    
    private class CalculateButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                double[] grade = new double[4];
                double[] weight = new double[4];
                double[] points = new double[4];
                
                double sum = 0;
                
                for (int x =0; x < 4; x++) {
                    grade[x] = Double.parseDouble(jtf_Exam[x].getText());
                    weight[x] = Double.parseDouble(jtf_Weight[x].getText());
                }
                
                for (int c = 0; c < 4; c++) {
                    points[c] = grade[c] * weight[c];
                }
                
                for (int i = 0; i < points.length; i++) {
                    sum += points[i];
                }
                
                double gradeTotal = sum / 4;
                double gradeTotalMod = sum % 4;
                
                lbl_CalcGrade.setText(gradeTotal + "." + gradeTotalMod);
        }
    }
    
    private class ExitButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        IT145_Week06 startCalc = new IT145_Week06();
    }
}

