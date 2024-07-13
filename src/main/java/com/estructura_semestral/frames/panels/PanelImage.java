/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructura_semestral.frames.panels;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImage extends JPanel {
    private String path;
    
    public PanelImage(String path) {
        this.path = path;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon img = new ImageIcon(getClass().getResource(path));
        if (img.getImage() != null) {
            g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
        } else {
            System.out.println("Image not found: " + path);
        }
    }
}
