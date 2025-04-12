import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ManualGradesApp extends JFrame {

    private JTextArea resultArea;
    private JButton generateButton;

    private String[] lessons = {
            "Riazi", "Fizik", "Shimi", "Zist", "Adabiat",
            "Zaban Englisi", "Dini", "Tarikh", "Joghrafia", "Computer"
    };

    private String[] prizes = {
            "Kart Hadiye 100 Hezari",
            "Bilet Shahrebazi",
            "Powerbank Rayegan",
            "Mag Ekhtesasi",
            "Code Takhfif Kharid Online",
            "Headset Gaming"
    };

    private String[] punishments = {
            "10 daqiqe bezan be divar negah kon!",
            "Hameye mashghato dobare benevis!",
            "1 saat dars bekhoon bedune mobile!",
            "Beraghs rooye yek pa!",
            "Ekhtari az madar!",
            "Tamrin ezafi az riazi!"
    };

    public ManualGradesApp() {
        setTitle("Mohasebe Moaddel (Voroodi Dasti)");
        setSize(450, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        generateButton = new JButton("Vared kardan nomre ha va mohasebe");
        generateButton.setFont(new Font("Arial", Font.BOLD, 16));
        generateButton.addActionListener(e -> enterGrades());
        add(generateButton, BorderLayout.SOUTH);
    }

    private void enterGrades() {
        resultArea.setText("Nomre doroos:\n");
        double sum = 0;
        int count = 0;

        for (String lesson : lessons) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    String input = JOptionPane.showInputDialog(
                            this,
                            "Nomre " + lesson + " ra vared kon (0 ta 20):",
                            "Vorood Nomre",
                            JOptionPane.QUESTION_MESSAGE);
                    if (input == null)
                        return; // agar cancel shod
                    double grade = Double.parseDouble(input);

                    if (grade >= 0 && grade <= 20) {
                        grade = Math.round(grade * 10.0) / 10.0;
                        resultArea.append(lesson + ": " + grade + "\n");
                        sum += grade;
                        count++;
                        validInput = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Lotfan adad beine 0 ta 20 vared kon!", "Khataye vorood",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Lotfan adad sahih vared kon!", "Khataye vorood",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        double avg = Math.round((sum / count) * 100.0) / 100.0;
        resultArea.append("\nMoaddel kol: " + avg + "\n");

        if (avg >= 18) {
            String prize = prizes[new Random().nextInt(prizes.length)];
            resultArea.append("\n🎁 Tabrik! Shoma barande shodid:\n" + prize);
        } else if (avg < 10) {
            String punishment = punishments[new Random().nextInt(punishments.length)];
            resultArea.append("\n⚠️ Moaddel kheili paine! Mojazat:\n" + punishment);
        } else {
            resultArea.append("\nMoaddel motavasete. Na jaayeze... na mojazat!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManualGradesApp().setVisible(true);
        });
    }
}
