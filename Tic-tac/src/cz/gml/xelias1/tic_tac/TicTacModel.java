/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import cz.gml.xelias1.tic_tac.TicTacType;

/**
 *
 * @author Michal
 */
public class TicTacModel {
    private TicTacType currentPlayer = TicTacType.CROSS;
    private int height, width;
    private TicTacType[][] plan;

    public TicTacModel(int height, int width) {
        if (width < 3 || height < 3) throw new RuntimeException("Bad size, must be biger than 2x2");
        this.height = height;
        this.width = width;
        emptyPlan();
    }

    public void emptyPlan(){
        plan = new TicTacType[height][width];
        for (int i = 0; i < height; i ++){
            for (int j = 0; j < width; j ++){
                plan[i][j] = TicTacType.NONE;
            }
        }
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }    
    
    
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
