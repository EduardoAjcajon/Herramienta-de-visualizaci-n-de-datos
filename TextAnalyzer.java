import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAnalyzer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Herramienta de visualización de datos");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel textLabel = new JLabel("Ingrese el texto a analizar:");
        textLabel.setBounds(10, 10, 200, 25);
        panel.add(textLabel);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 40, 460, 150);
        panel.add(textArea);

        JButton analyzeButton = new JButton("Analizar");
        analyzeButton.setBounds(10, 200, 100, 25);
        panel.add(analyzeButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 230, 460, 120);
        resultArea.setEditable(false);
        panel.add(resultArea);

        analyzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int sentenceCount = countSentences(text);
                int wordCount = countWords(text);
                int letterCount = countLetters(text);
                int numberCount = countNumbers(text);

                resultArea.setText("Número de oraciones: " + sentenceCount + "\n"
                        + "Número de palabras: " + wordCount + "\n"
                        + "Número de letras: " + letterCount + "\n"
                        + "Número de números: " + numberCount);
            }
        });
    }

    public static int countSentences(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.' || ch == '!' || ch == '?') {
                count++;
            }
        }
        return count;
    }

    public static int countWords(String text) {
        int count = 0;
        boolean isWord = false;
        int endOfLine = text.length() - 1;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch) && i != endOfLine) {
                isWord = true;
            } else if (!Character.isLetter(ch) && isWord) {
                count++;
                isWord = false;
            } else if (Character.isLetter(ch) && i == endOfLine) {
                count++;
            }
        }
        return count;
    }

    public static int countLetters(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }
}
