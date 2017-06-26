package com.super_cargo.display;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public abstract class Display {

    private static boolean created = false;
    private static JFrame window;
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferedData;
    private static Graphics bufferedGraphics;
    private static int clearColor;

    //temp
    private static float delte = 0;
    //temp end

    public static void create(int width, int height, String title, int _clearColor){
        if(created){
            return;
        }else {
            window = new JFrame(title);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            content = new Canvas();

            Dimension size = new Dimension(width, height);
            content.setPreferredSize(size);

            window.setResizable(false);
            window.getContentPane().add(content);
            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);

            buffer = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            bufferedData = ((DataBufferInt) buffer.getRaster().getDataBuffer()).getData();
            bufferedGraphics = buffer.getGraphics();
            clearColor = _clearColor;

            created = true;
        }
    }

    public static void clear(){
        Arrays.fill(bufferedData,clearColor);
    }

    public static void render(){
        bufferedGraphics.setColor(new Color(0xff0000ff));
        bufferedGraphics.fillOval((int)(350 + Math.sin(delte) * 200),250,100,100);
        delte += 0.02f;
    }

    public static void swapBuffers(){
        Graphics g = content.getGraphics();
        g.drawImage(buffer, 0,0, null);
    }
}
