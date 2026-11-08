/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gml.xelias1.tic_tac;

/**
 *
 * @author Michal
 */
public class Game {
    private TicTacType currentPlayer = TicTacType.CROSS;
    
    public TicTacType makeMove(){
        TicTacType out = currentPlayer;
        if(currentPlayer == TicTacType.CROSS){
            currentPlayer = TicTacType.CIRCLE;
        } else {
            currentPlayer = TicTacType.CROSS;
        }
        
        return out;
    }
}
