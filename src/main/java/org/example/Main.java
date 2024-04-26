package org.example;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.AbstractBorder;

public class Main extends JFrame {

    private JLabel weightLabel, heightLabel, ageLabel, activityLabel, genderLabel;
    private JTextField weightField, heightField, ageField;
    private JComboBox<String> activityComboBox, genderComboBox;
    private JButton calculateButton;
    private JTextArea resultTextArea;

    public Main(){
        setTitle("Калькулятор БЖУ");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Создаем панель для ввода данных
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        // Добавляем стиль для меток
        Font labelFont = new Font("Arial", Font.BOLD, 14);

        // Добавляем метку для веса
        weightLabel = new JLabel("Вес (кг):");
        weightLabel.setFont(labelFont);
        c.gridy = 0;
        inputPanel.add(weightLabel, c);

        // Добавляем поле ввода для веса
        weightField = new JTextField(5);
        weightField.setBorder(new RoundBorder(8, Color.GRAY));
        weightField.setOpaque(false);
        weightField.setBackground(new Color(220, 220, 220));
        weightField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 1;
        inputPanel.add(weightField, c);

        // Добавляем метку для роста
        heightLabel = new JLabel("Рост (см):");
        heightLabel.setFont(labelFont);
        c.gridy = 2;
        inputPanel.add(heightLabel, c);

        // Добавляем поле ввода для роста
        heightField = new JTextField(5);
        heightField.setBorder(new RoundBorder(8, Color.GRAY));
        heightField.setOpaque(false);
        heightField.setBackground(new Color(220, 220, 220));
        heightField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 3;
        inputPanel.add(heightField, c);

        // Добавляем метку для возраста
        ageLabel = new JLabel("Возраст (лет):");
        ageLabel.setFont(labelFont);
        c.gridy = 4;
        inputPanel.add(ageLabel, c);

        // Добавляем поле ввода для возраста
        ageField = new JTextField(5);
        ageField.setBorder(new RoundBorder(8, Color.GRAY));
        ageField.setOpaque(false);
        ageField.setBackground(new Color(220, 220, 220));
        ageField.setPreferredSize(new Dimension(100, 30));
        c.gridy = 5;
        inputPanel.add(ageField, c);

        // Добавляем метку для активности
        activityLabel = new JLabel("Активность:");
        activityLabel.setFont(labelFont);
        c.gridy = 6;
        inputPanel.add(activityLabel, c);

        // Добавляем выпадающий список для выбора активности
        activityComboBox = new JComboBox<>(new String[] { "Низкая", "Умеренная", "Высокая" });
        c.gridy = 7;
        inputPanel.add(activityComboBox, c);

        // Добавляем метку для гендера
        genderLabel = new JLabel("Пол:");
        genderLabel.setFont(labelFont);
        c.gridy = 8;
        inputPanel.add(genderLabel, c);

        // Добавляем выпадающий список для выбора гендера
        genderComboBox = new JComboBox<>(new String[] { "Мужской", "Женский" });
        c.gridy = 9;
        inputPanel.add(genderComboBox, c);



        // Создаем панель для кнопки расчета
        JPanel buttonPanel = new JPanel();

        // Добавляем стиль для кнопки
        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        // Добавляем кнопку расчета
        calculateButton = new JButton("Рассчитать БЖУ");
        calculateButton.setFont(buttonFont);
        calculateButton.setBackground(Color.GREEN);
        calculateButton.setForeground(Color.WHITE);
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        // Создаем текстовую область для вывода результата
        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);

        // Добавляем стиль для текстовой области
        resultTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Добавляем панели ввода данных, кнопку расчета и текстовую область для вывода результата в главное окно
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultTextArea, BorderLayout.SOUTH);

        // Выравниваем поля ввода по центру
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Отображаем окно
        setVisible(true);
    }

    public class RoundBorder extends AbstractBorder {
        private int radius;
        private Color color;

        public RoundBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.top = insets.right = insets.bottom = radius;
            return insets;
        }
    }

    private void addInputField(JPanel panel, GridBagConstraints c, int yPos, String labelText, JTextField textField) {
        c.gridx = 0;
        c.gridy = yPos;
        JLabel label = new JLabel(labelText);
        panel.add(label, c);

        c.gridx = 1;
        panel.add(textField, c);
    }

    private void addInputLabel(JPanel panel, GridBagConstraints c, int yPos, String labelText) {
        c.gridx = 0;
        c.gridy = yPos;
        JLabel label = new JLabel(labelText);
        panel.add(label, c);
    }

    private class CalculateButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            // Получаем значения из полей ввода
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());
            int age = Integer.parseInt(ageField.getText());
            String activity = (String) activityComboBox.getSelectedItem();
            String gender = (String) genderComboBox.getSelectedItem();

            // Определяем коэффициент активности и пола
            double activityFactor, genderFactor;

            switch (activity) {
                case "Низкая":
                    activityFactor = 1.2;
                    break;
                case "Умеренная":
                    activityFactor = 1.375;
                    break;
                case "Высокая":
                    activityFactor = 1.55;
                    break;
                default:
                    activityFactor = 1.2;
                    break;
            }

            switch (gender) {
                case "Мужской":
                    genderFactor = 5;
                    break;
                case "Женский":
                    genderFactor = -161;
                    break;
                default:
                    genderFactor = 5;
                    break;
            }

            // Рассчитываем БЖУ
            double bju = (10 * weight + 6.25 * height - 5 * age + genderFactor) * activityFactor;

            // Выводим результат в текстовую область
            resultTextArea.setText("БЖУ: " + bju + " г");
        }
    }

    public static void main(String[] args) {
        new Main();
    }



}
