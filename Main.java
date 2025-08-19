import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    JTextArea result;
    JButton cal, reset;
    JLabel name, age, sex,height,weight;
    JRadioButton male, female;
    JTextField na, ag,he,we;

    Main() {
        setTitle("BMI Calculator");
        setSize(1000, 1000);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label for name
        name = new JLabel("Enter Your Name:");
        name.setBounds(100, 100, 150, 30);
        add(name);

        // TextField for name
        na = new JTextField();
        na.setBounds(300, 100, 200, 30);
        add(na);

        // Label for age
        age = new JLabel("Enter Your Age:");
        age.setBounds(100, 160, 150, 30);
        add(age);

        // TextField for age
        ag = new JTextField();
        ag.setBounds(300, 160, 200, 30);
        add(ag);

        // Label for gender
        sex = new JLabel("Select Your Gender:");
        sex.setBounds(100, 220, 150, 30);
        add(sex);

        // Radio buttons for gender
        male = new JRadioButton("Male");
        male.setBounds(300, 220, 80, 30);
        female = new JRadioButton("Female");
        female.setBounds(400, 220, 100, 30);

        // Grouping radio button
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        add(male);
        add(female);


        height = new JLabel("Enter Your Height (mm):");
        height.setBounds(100, 280, 150, 30);
        add(height);

        he=new JTextField(" ");
        he.setBounds(300, 280, 200, 30);
        add(he);


         weight = new JLabel("Enter Your Weight (Kg):");
        weight.setBounds(100, 340, 150, 30);
        add(weight);

        we=new JTextField(" ");
        we.setBounds(300, 340, 200, 30);
        add(we);


         
         cal = new JButton("Calculate");
         cal.setBounds(150 ,400,100,30);
         add(cal);
        
        reset = new JButton("Reset");
         reset.setBounds(250,400,100,30);
         add(reset);
         
         result = new JTextArea(" ");
         result.setBounds(600,100,400,400);
         add(result);
         
         
         
         
    }

    public static void main(String[] args) {
        new Main();
    }
}
