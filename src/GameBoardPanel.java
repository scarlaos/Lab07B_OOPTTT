import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameBoardPanel extends JPanel {
    JButton[][] buttons = new JButton[3][3];

    public GameBoardPanel() {
        setLayout(new GridLayout(3,3));
        Font font = new Font("Arial", Font.BOLD, 28);

        for(int rows = 0; rows < 3; rows++) {
            for(int cols = 0; cols < 3; cols++) {
                buttons[rows][cols] = new JButton("");
                buttons[rows][cols].setFont(font);
                add(buttons[rows][cols]);
            }
        }
    }

    public void addButton(ActionListener e) {
        for(JButton[] row : buttons) {
            for(JButton button : row) {
                button.addActionListener(e);
            }
        }
    }

    public void setButton(int row, int col, String text) {
        buttons[row][col].setText(text);
    }

    public void resetBoard(){
        for(JButton[] row : buttons) {
            for(JButton button : row) {
                button.setText("");
                button.setEnabled(true); //button is able to reset to clear
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }
}
