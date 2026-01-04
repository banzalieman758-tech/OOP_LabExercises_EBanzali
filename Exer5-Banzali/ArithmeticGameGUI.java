
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ArithmeticGameGUI extends JFrame {

    // Core Components
    private JTextField answerField;
    // Reference the panel holding the math problem for visual effects
    private JPanel questionPanel; 
    private JLabel num1Label, operatorLabel, num2Label, countLabel, feedbackLabel;
    private JButton submitButton;
    
    // Game State 
    private int correctAnswers = 0;   // Tracks the number of correct answers
    private int incorrectAnswers = 0; // Tracks the number of incorrect answers
    private int correctResult;
    private String currentOperator = "+"; 
    private Random random = new Random();
    
    // Store the default background color to reset the panel later
    private final Color defaultBackgroundColor = UIManager.getColor("Panel.background");

    public ArithmeticGameGUI() {
        // --- 1. Basic Frame Setup (JFrame) ---
        super("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Use BorderLayout for the main frame
        
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
        updateCountsDisplay(); // Initialize the counter display
        
        // --- 6. Finalizing the Frame ---
        pack(); // Resize frame to fit all components
        setMinimumSize(new Dimension(750, 450));
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }
    
    // --- Helper Methods to Create Sub-Panels ---

    /**
     * Creates the control panel on the left for selecting operations and level.
     */
    private JPanel createControlsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 10, 20)); // Two sections: Operations and Levels
        panel.setBorder(BorderFactory.createTitledBorder("Settings"));
        
        // --- Operations Group ---
        JPanel operationPanel = new JPanel(new GridLayout(6, 1));
        operationPanel.setBorder(BorderFactory.createTitledBorder("Operations"));
        ButtonGroup operationGroup = new ButtonGroup();
        
        // Updated labels for clarity
        String[] ops = {"Addition (+)", "Subtraction (-)", "Multiplication (*)", "Division (/)", "Modulo (%)"};
        String[] commands = {"+", "-", "*", "/", "%"}; // Actual command symbols

        for (int i = 0; i < ops.length; i++) {
            JRadioButton opButton = new JRadioButton(ops[i]);
            if (commands[i].equals("+")) {
                opButton.setSelected(true); // Default to addition
            }
            opButton.setActionCommand(commands[i]); // Set action command to the symbol
            opButton.addActionListener(e -> {
                currentOperator = e.getActionCommand();
                generateNewProblem(); // Generate a new problem when operator changes
            });
            operationGroup.add(opButton);
            operationPanel.add(opButton);
        }
        
        // --- Level Group ---
        JPanel levelPanel = new JPanel(new GridLayout(4, 1));
        levelPanel.setBorder(BorderFactory.createTitledBorder("Level"));
        ButtonGroup levelGroup = new ButtonGroup();

        String[] levels = {"Level 1 (0-10)", "Level 2 (11-100)", "Level 3 (101-999)"};
        for (int i = 0; i < levels.length; i++) {
            JRadioButton levelButton = new JRadioButton(levels[i]);
            if (i == 0) levelButton.setSelected(true); // Default to Level 1
            levelGroup.add(levelButton);
            levelPanel.add(levelButton);
        }
        
        panel.add(operationPanel);
        panel.add(levelPanel);
        return panel;
    }

   