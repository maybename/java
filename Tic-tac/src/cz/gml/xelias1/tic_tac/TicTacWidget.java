/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.gml.xelias1.tic_tac;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import javax.swing.JComponent;

/**
 *
 * @author xelias1
 */


public class TicTacWidget extends JComponent {

    private TicTacType type = TicTacType.NONE;

    /**
     *
     * @param type
     * sets parameter type of this widget, if it wasn't already set
     */
    public void setType(TicTacType type){
        if (this.type != TicTacType.NONE) return;
        this.type = type;
        this.repaint();
    }
    
    public TicTacType getType(){
        return type;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("painting tiles...");
        int offset = 4;
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        g2.setStroke(new BasicStroke(8));

        switch (type) {
            case CROSS -> {
                g.setColor(Color.red);
                g.drawLine(offset, offset, this.getWidth()-offset, this.getHeight()-offset);
                g.drawLine(0, this.getHeight() - 2*offset, this.getWidth() - 2*offset, 0);
            }
            case CIRCLE -> {
                g.setColor(Color.blue);
                g.drawOval(0, 0, this.getWidth(), this.getHeight());
            }
        }
    }
   
}
