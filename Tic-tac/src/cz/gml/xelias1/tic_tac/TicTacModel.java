package cz.gml.xelias1.tic_tac;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
    
    public void setTileType(int x, int y, TicTacType type){
        if (x < width && x > 0) throw new ArrayIndexOutOfBoundsException("Bad X");
        if (y < height && y > 0) throw new ArrayIndexOutOfBoundsException("Bad Y");
        
        plan[y][x] = type;
    }
    public TicTacType getTileType(int x, int y){
        if (x < width && x > 0) throw new ArrayIndexOutOfBoundsException("Bad X");
        if (y < height && y > 0) throw new ArrayIndexOutOfBoundsException("Bad Y");
        
        return plan[y][x];
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

    @Override
    public String toString() {
        String result = super.toString()+"TicTacModel{" + "currentPlayer=" + currentPlayer + ", height=" + height + ", width=" + width + ", plan=";
        for (int y = 0; y<height;y++){
            for (int x = 0; x<width;x++){
                String symbol = " ";
                switch(plan[y][x]){
                    case CIRCLE -> symbol = "O";
                    case CROSS -> symbol = "X";
                }
                result += (symbol + "|");
            }
            result += "\n";
        }
        return result;
    }
    
}
