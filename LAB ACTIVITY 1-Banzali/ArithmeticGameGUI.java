
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ArithmeticGameGUI extends JFrame {

    private JTextField answerField;
    
    private JPanel questionPanel; 
    private JLabel num1Label, operatorLabel, num2Label, countLabel, feedbackLabel;
    private JButton submitButton;
    
    
    private int correctAnswers = 0;   
    private int incorrectAnswers = 0; 
    private int correctResult;
    private String currentOperator = "+"; 
    private Random random = new Random();
    
    
    private final Color defaultBackgroundColor = UIManager.getColor("Panel.background");

    public ArithmeticGameGUI() {
        // --- 1. Basic Frame Setup (JFrame) ---
        super("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); 
        
        // --- 2. Title Header ---
        JLabel headerLabel = new JLabel("Arithmetic Game Challenge", JLabel.CENTER);
        headerLabel.setFont(new Font("Inter", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(headerLabel, BorderLayout.NORTH);

        // --- 3. Left Control Panel (WEST) ---
        JPanel controlsPanel = createControlsPanel();
        add(controlsPanel, BorderLayout.WEST);

        // --- 4. Main Game Area (CENTER) ---
        JPanel gameAreaPanel = createGameAreaPanel();
        add(gameAreaPanel, BorderLayout.CENTER);
        
        // --- 5. Initial Game Setup ---
        generateNewProblem();
        updateCountsDisplay(); 
        
        // --- 6. Finalizing the Frame ---
        pack(); 
        setMinimumSize(new Dimension(750, 450));
        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    
    private JPanel createControlsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 20));
        panel.setBorder(BorderFactory.createTitledBorder("Settings"));
        
        // --- Operations Group ---
        JPanel operationPanel = new JPanel(new GridLayout(6, 1));
        operationPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
        ButtonGroup operationGroup = new ButtonGroup();
        
        // Updated labels for clarity
        String[] ops = {"Addition (+)", "Subtraction (-)", "Multiplication (*)", "Division (/)", "Modulo (%)"};
        String[] commands = {"+", "-", "*", "/", "%"}; 

        for (int i = 0; i < ops.length; i++) {
            JRadioButton opButton = new JRadioButton(ops[i]);
            if (commands[i].equals("+")) {
                opButton.setSelected(true); 
            }
            opButton.setActionCommand(commands[i]); 
            opButton.addActionListener(e -> {
                currentOperator = e.getActionCommand();
                generateNewProblem(); 
            });
            operationGroup.add(opButton);
            operationPanel.add(opButton);
        }
        
        JPanel levelPanel = new JPanel(new GridLayout(4, 1));
        levelPanel.setBorder(BorderFactory.createTitledBorder("Level"));
        ButtonGroup levelGroup = new ButtonGroup();

        String[] levels = {"Level 1 (0-10)", "Level 2 (11-100)", "Level 3 (101-999)"};
        for (int i = 0; i < levels.length; i++) {
            JRadioButton levelButton = new JRadioButton(levels[i]);
            if (i == 0) levelButton.setSelected(true); 
            levelGroup.add(levelButton);
            levelPanel.add(levelButton);
        }
        
        panel.add(operationPanel);
        panel.add(levelPanel);
        return panel;
    }

    
    private JPanel createGameAreaPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // --- A. Question Panel (CENTER of mainPanel) ---
        questionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 50));
        
        Font mathFont = new Font("Monospaced", Font.BOLD, 48);

        num1Label = createMathLabel("0", mathFont);
        operatorLabel = createMathLabel("+", mathFont);
        num2Label = createMathLabel("0", mathFont);
        
        JLabel equalsLabel = createMathLabel("=", mathFont);
        
        answerField = new JTextField(4); 
        answerField.setFont(mathFont);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        answerField.setMaximumSize(new Dimension(150, 70));
        
        answerField.setBorder(new LineBorder(new Color(47, 79, 79), 2, true)); 
        answerField.setBackground(new Color(255, 250, 240));
        answerField.addActionListener(this::checkAnswer); 
        
        questionPanel.add(num1Label);
        questionPanel.add(operatorLabel);
        questionPanel.add(num2Label);
        questionPanel.add(equalsLabel);
        questionPanel.add(answerField);
        
        mainPanel.add(questionPanel, BorderLayout.CENTER); 
        
        // --- B. Submit, Feedback, Counts, and Control Panel (SOUTH of mainPanel) ---
        JPanel bottomPanel = new JPanel(new BorderLayout(20, 10)); 
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));

        // Top section of bottomPanel (Submit & Counts)
        JPanel topBottomSection = new JPanel(new BorderLayout(20, 0));

        // 1. Submit Button (WEST of topBottomSection)
        submitButton = new JButton("SUBMIT");
        submitButton.setFont(new Font("Inter", Font.BOLD, 20));
        submitButton.setPreferredSize(new Dimension(150, 50));
        submitButton.addActionListener(this::checkAnswer); 

        JPanel submitWrapper = new JPanel(new FlowLayout(FlowLayout.LEFT));
        submitWrapper.add(submitButton);
        topBottomSection.add(submitWrapper, BorderLayout.WEST);

        // 2. Counts Display (CENTER of topBottomSection)
        countLabel = new JLabel("", JLabel.CENTER);
        countLabel.setFont(new Font("Inter", Font.BOLD, 18));
        topBottomSection.add(countLabel, BorderLayout.CENTER);

        bottomPanel.add(topBottomSection, BorderLayout.NORTH); 

        // 3. Feedback label (CENTER of bottomPanel)
        feedbackLabel = new JLabel("Ready to play!", JLabel.CENTER);
        feedbackLabel.setFont(new Font("Inter", Font.ITALIC, 16));
        bottomPanel.add(feedbackLabel, BorderLayout.CENTER); 

        // 4. Control Buttons Panel (SOUTH of bottomPanel)
        JPanel controlButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));

        // Continue Button
        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("Inter", Font.BOLD, 16));
        continueButton.setBackground(new Color(60, 179, 113)); 
        continueButton.setForeground(Color.WHITE);
        continueButton.addActionListener(e -> generateNewProblem());
        controlButtonsPanel.add(continueButton);

        // Exit Button
        JButton exitButton = new JButton("EXIT GAME");
        exitButton.setFont(new Font("Inter", Font.BOLD, 16));
        exitButton.setBackground(new Color(220, 20, 60)); 
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(e -> System.exit(0)); 
        controlButtonsPanel.add(exitButton);

        bottomPanel.add(controlButtonsPanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        return mainPanel;
    }
    
    
    private JLabel createMathLabel(String text, Font font) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(font);
        
        // --- CUSTOM BOX STYLING ---
        label.setOpaque(true); 
        label.setBackground(new Color(240, 248, 255)); 
        // Steel Blue border, 2 pixels thick, with hint for rounded corners
        label.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180), 2, true)); 
        // --------------------------
        
        label.setPreferredSize(new Dimension(100, 70));
        return label;
    }

   
    private void generateNewProblem() {
        
        int num1 = random.nextInt(10) + 1; 
        int num2 = random.nextInt(10) + 1;
        
       
        if (currentOperator.equals("/") || currentOperator.equals("%")) {
             
             if (num2 == 0) num2 = 1;
             num1 = num2 * (random.nextInt(5) + 1); 
        }

        
        if (currentOperator.equals("-") && num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        num1Label.setText(String.valueOf(num1));
        operatorLabel.setText(currentOperator);
        num2Label.setText(String.valueOf(num2));

        switch (currentOperator) {
            case "+": correctResult = num1 + num2; break;
            case "-": correctResult = num1 - num2; break;
            case "*": correctResult = num1 * num2; break;
            case "/": correctResult = num1 / num2; break;
            case "%": correctResult = num1 % num2; break;
            default: correctResult = 0; break;
        }

        answerField.setText(""); 
        feedbackLabel.setForeground(Color.GRAY);
        feedbackLabel.setText("Solve the problem!");
        questionPanel.setBackground(defaultBackgroundColor); 
        answerField.requestFocusInWindow(); 
    }
    
    
    private void updateCountsDisplay() {
        
        countLabel.setText(String.format(
            "<html><div style='text-align: center;'><b>Correct Answers:</b> <font color='green'>%d</font> | <b>Incorrect Answers:</b> <font color='red'>%d</font></div></html>", 
            correctAnswers, incorrectAnswers));
    }

   
    private void checkAnswer(ActionEvent e) {
        try {
            int userAnswer = Integer.parseInt(answerField.getText().trim());
            
            if (userAnswer == correctResult) {
                correctAnswers++;
                
                // --- VISUAL FEEDBACK: GREEN FLASH ---
                feedbackLabel.setForeground(new Color(0, 100, 0)); 
                feedbackLabel.setText("✅ Correct Answer! Great Job!");
                questionPanel.setBackground(Color.GREEN); // Flash Green
                
            } else {
                incorrectAnswers++;
                
                // --- VISUAL FEEDBACK: RED FLASH ---
                feedbackLabel.setForeground(new Color(178, 34, 34)); 
                feedbackLabel.setText("❌ Incorrect. The correct answer was " + correctResult);
                questionPanel.setBackground(Color.RED); 
            }
            
            updateCountsDisplay(); 
           
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    questionPanel.setBackground(defaultBackgroundColor); 
                    generateNewProblem();
                    ((Timer)evt.getSource()).stop(); 
                }
            });
            timer.setRepeats(false);
            timer.start();
            
        } catch (NumberFormatException ex) {
            feedbackLabel.setForeground(Color.ORANGE);
            feedbackLabel.setText("Please enter a valid number.");
            answerField.setText("");
        }
    }

    // --- Main Entry Point ---

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new ArithmeticGameGUI();
        });
    }
}