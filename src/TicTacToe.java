import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe extends JFrame implements ActionListener {

    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    int turn = 0;
    boolean player1_turn;

    TicTacToe() {

        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new BorderLayout());

        // setting the text on top of the page
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        // adding title panel+text field to the North border
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);
        title_panel.add(textField);

        // button panel
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(Color.red);
        button_panel.setSize(800, 700);

        // creating buttons
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].setOpaque(true);
            buttons[i].addActionListener(this);
        }

        this.add(title_panel, BorderLayout.NORTH);
        this.add(button_panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        firstTurn();
    }

    public void firstTurn() {

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textField.setText("X turn");
        } else {
            player1_turn = false;
            textField.setText("O turn");
        }
    }

    public void check() {

        if (turn==9){
            playAgain();
            for (int i=0; i<9; i++){
                buttons[i].setEnabled(false);
            }
            buttons[4].setEnabled(true);
            textField.setText("Draw!");
        }

        if (
                (buttons[0].getText()=="X") &&
                (buttons[1].getText()=="X") &&
                (buttons[2].getText()=="X")
            )
        {
            xWins(0,1,2);
        }

        if (
                (buttons[3].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[5].getText()=="X")
        )
        {
            xWins(3,4,5);
        }

        if (    (buttons[6].getText()=="X") &&
                (buttons[7].getText()=="X") &&
                (buttons[8].getText()=="X")
        )
        {
            xWins(6,7,8);
        }

        if (    (buttons[0].getText()=="X") &&
                (buttons[3].getText()=="X") &&
                (buttons[6].getText()=="X")
        )
        {
            xWins(0,3,6);
        }

        if (    (buttons[1].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[7].getText()=="X")
        )
        {
            xWins(1,4,7);
        }

        if (    (buttons[2].getText()=="X") &&
                (buttons[5].getText()=="X") &&
                (buttons[8].getText()=="X")
        )
        {
            xWins(2,5,8);
        }

        if (    (buttons[0].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[8].getText()=="X")
        )
        {
            xWins(0,4,8);
        }

        if (    (buttons[2].getText()=="X") &&
                (buttons[4].getText()=="X") &&
                (buttons[6].getText()=="X")
        )
        {
            xWins(2,4,6);
        }


        if (
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        )
        {
            oWins(0,1,2);
        }

        if (
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        )
        {
            oWins(3,4,5);
        }

        if (    (buttons[6].getText()=="O") &&
                (buttons[7].getText()=="O") &&
                (buttons[8].getText()=="O")
        )
        {
            oWins(6,7,8);
        }

        if (    (buttons[0].getText()=="O") &&
                (buttons[3].getText()=="O") &&
                (buttons[6].getText()=="O")
        )
        {
            oWins(0,3,6);
        }

        if (    (buttons[1].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[7].getText()=="O")
        )
        {
            oWins(1,4,7);
        }

        if (    (buttons[2].getText()=="O") &&
                (buttons[5].getText()=="O") &&
                (buttons[8].getText()=="O")
        )
        {
            oWins(2,5,8);
        }

        if (    (buttons[0].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[8].getText()=="O")
        )
        {
            oWins(0,4,8);
        }

        if (    (buttons[2].getText()=="O") &&
                (buttons[4].getText()=="O") &&
                (buttons[6].getText()=="O")
        )
        {
            oWins(2,4,6);
        }

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("X wins!");
        playAgain();
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(false);
        }
        textField.setText("O wins!");
        playAgain();
    }

    public void playAgain(){
        buttons[4].setText("Play again!");
        buttons[4].setEnabled(true);
        buttons[4].setFont(new Font(buttons[4].getFont().getFamily(),
                buttons[4].getFont().getStyle(), 40));
        buttons[4].addActionListener(e -> newGame());
    }

    public void newGame(){
        this.dispose();
        new TicTacToe();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        turn++;
                        textField.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        turn++;
                        textField.setText("X turn");
                        check();
                    }
                }
            }

        }
    }
}
