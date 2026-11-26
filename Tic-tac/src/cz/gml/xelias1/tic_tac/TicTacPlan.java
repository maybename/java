/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gml.xelias1.tic_tac;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.FlowLayout;

import javax.swing.JComponent;

/**
 *
 * @author xelias1
 */


public class TicTacPlan extends JComponent {
    private TicTacWidget[][] tiles;
    private int height, width;
    private TicTacModel model;

    /**
     *
     * @param model
     */
    public void setModel(TicTacModel model){
        this.model = model;
        //height = model.getHeight();
        //width = model.getWidth();
    }
    public TicTacPlan(){
        height = 3;
        width = 3;
        tiles = new TicTacWidget[height][width];
        
        setLayout(new FlowLayout());
        for (int i = 0; i < height; i ++){
            for (int j = 0; j < width; j ++){
                TicTacWidget tile = new TicTacWidget();
                tiles[i][j] = tile;
                add(tile);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i < height; i ++){
            for (int j = 0; j < width; j ++){
                tiles[i][j].setType(TicTacType.NONE);
            }
        }
    }
   
}
