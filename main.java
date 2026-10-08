import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    private JLabel display;
    private Timer timer;

    private int segundos = 0;

    public Main() {

        setTitle("Cronômetro");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cor de fundo
        getContentPane().setBackground(new Color(25, 25, 25));

        // Display
        display = new JLabel("00:00:00");
        display.setFont(new Font("Arial", Font.BOLD, 48));
        display.setForeground(Color.WHITE);
        display.setHorizontalAlignment(SwingConstants.CENTER);

        // Painel dos botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBackground(new Color(25, 25, 25));

        JButton iniciar = new JButton("Iniciar");
        JButton pausar = new JButton("Pausar");
        JButton zerar = new JButton("Zerar");

        painelBotoes.add(iniciar);
        painelBotoes.add(pausar);
        painelBotoes.add(zerar);

        // Layout
        setLayout(new BorderLayout());
        add(display, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Timer
        timer = new Timer(1000, e -> {
            segundos++;
            atualizarDisplay();
        });

        // Botão iniciar
        iniciar.addActionListener(e -> {
            timer.start();
        });

        // Botão pausar
        pausar.addActionListener(e -> {
            timer.stop();
        });

        // Botão zerar
        zerar.addActionListener(e -> {
            timer.stop();
            segundos = 0;
            atualizarDisplay();
        });

        setVisible(true);
    }

    private void atualizarDisplay() {

        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int segundosRestantes = segundos % 60;

        display.setText(
            String.format(
                "%02d:%02d:%02d",
                horas,
                minutos,
                segundosRestantes
            )
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
