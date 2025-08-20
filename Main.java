import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    private JTextArea result;
    private JButton cal, reset;
    private JLabel name, age, sex, heightLabel, weightLabel;
    private JRadioButton male, female;
    private JTextField na, ag, he, we;

    Main() {
        setTitle("BMI Calculator");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        name = new JLabel("Enter Your Name:");
        name.setBounds(50, 30, 150, 30);
        add(name);

        na = new JTextField();
        na.setBounds(220, 30, 150, 30);
        add(na);

        age = new JLabel("Enter Your Age:");
        age.setBounds(50, 80, 150, 30);
        add(age);

        ag = new JTextField();
        ag.setBounds(220, 80, 150, 30);
        add(ag);

        sex = new JLabel("Select Your Gender:");
        sex.setBounds(50, 130, 150, 30);
        add(sex);

        male = new JRadioButton("Male");
        male.setBounds(220, 130, 80, 30);
        female = new JRadioButton("Female");
        female.setBounds(310, 130, 100, 30);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        add(male);
        add(female);

        heightLabel = new JLabel("Enter Your Height (meters):");
        heightLabel.setBounds(50, 180, 180, 30);
        add(heightLabel);

        he = new JTextField();
        he.setBounds(240, 180, 130, 30);
        add(he);

        weightLabel = new JLabel("Enter Your Weight (kg):");
        weightLabel.setBounds(50, 230, 180, 30);
        add(weightLabel);

        we = new JTextField();
        we.setBounds(240, 230, 130, 30);
        add(we);

        cal = new JButton("Calculate");
        cal.setBounds(80, 280, 120, 30);
        cal.addActionListener(this);
        add(cal);

        reset = new JButton("Reset");
        reset.setBounds(220, 280, 120, 30);
        reset.addActionListener(this);
        add(reset);

        result = new JTextArea();
        result.setBounds(50, 330, 700, 200);
        result.setEditable(false);
        add(result);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cal) {
            try {
                String nameText = na.getText().trim();
                String ageText = ag.getText().trim();
                String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Not specified";
                double height = Double.parseDouble(he.getText().trim());
                double weight = Double.parseDouble(we.getText().trim());

                if (height <= 0 || weight <= 0) {
                    result.setText("Height and weight must be positive numbers.");
                    return;
                }

                double bmi = weight / (height * height);
                String category = categorizeBMI(bmi);

                result.setText(String.format(
                    "Name: %s\nAge: %s\nGender: %s\nHeight: %.2f m\nWeight: %.2f kg\n\nYour BMI is: %.2f\nCategory: %s",
                    nameText.isEmpty() ? "—" : nameText,
                    ageText.isEmpty() ? "—" : ageText,
                    gender,
                    height,
                    weight,
                    bmi,
                    category
                ));
            } catch (NumberFormatException ex) {
                result.setText("Please enter valid numeric values for height and weight.");
            }
        } else {
            na.setText("");
            ag.setText("");
            male.setSelected(false);
            female.setSelected(false);
            he.setText("");
            we.setText("");
            result.setText("");
        }
    }

    private String categorizeBMI(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        new Main();
    }
}
