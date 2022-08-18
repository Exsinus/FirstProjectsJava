import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    private static final JFrame FRAME = new JFrame("Tic-Tac-Toe | Player X");
    private static final JButton[] CELLS = new JButton[9];
    private static String queue = "O";
    private static int moveCount = 0;

    public static void main(String[] args) {
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setSize(486, 509);
        FRAME.setResizable(false);
        FRAME.setLocationRelativeTo(null);
        FRAME.setLayout(null);
        FRAME.setVisible(true);

        for (int i = 0; i < CELLS.length; i++) {
            CELLS[i] = new JButton();
        }

        int count = 0;
        for (int i = 5; i < 470; i += 155) {
            for (int j = 5; j < 470; j += 155) {
                CELLS[count++].setLocation(j, i);
            }
        }

        for (JButton cell: CELLS) {
            cell.setSize(150, 150);
            cell.addActionListener(e -> move(cell));
            cell.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 130));
            FRAME.add(cell);
        }
    }

    private static void move(JButton cell) {
        if (cell.getText().equals("")) {
            FRAME.setTitle("Tic-Tac-Toe | Player " + queue);
            if (queue.equals("X")) {
                queue = "O";
                cell.setForeground(Color.BLUE);
            } else {
                queue = "X";
                cell.setForeground(Color.RED);
            }

            cell.setText(queue);
            moveCount++;
            resultCheck();
        }
    }

    private static void resultCheck() {
        if (cellCheck(0) && cellCheck(1) && cellCheck(2) ||
                cellCheck(3) && cellCheck(4) && cellCheck(5) ||
                cellCheck(6) && cellCheck(7) && cellCheck(8) ||
                cellCheck(0) && cellCheck(3) && cellCheck(6) ||
                cellCheck(1) && cellCheck(4) && cellCheck(7) ||
                cellCheck(2) && cellCheck(5) && cellCheck(8) ||
                cellCheck(0) && cellCheck(4) && cellCheck(8) ||
                cellCheck(2) && cellCheck(4) && cellCheck(6)
        ) {
            System.out.println("Player " + queue + " Wins!");
            restart();
        } else if (moveCount == 9) {
            System.out.println("Draw!");
            restart();
        }
    }

    private static boolean cellCheck(int index) {
        return CELLS[index].getText().equals(queue);
    }

    private static void restart() {
        FRAME.setTitle("Tic-Tac-Toe | Player X");
        queue = "O";
        moveCount = 0;

        for (JButton cell: CELLS) {
            cell.setText("");
        }
    }
}