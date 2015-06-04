/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("from present");
        TttFrame ttt=new TttFrame();
        ttt.setSize(350,400);
        ttt.setLocation(150,40);
        ttt.setVisible(true);
        ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ttt.setResizable(false);
    }
}
