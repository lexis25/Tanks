package com.super_cargo.display;

import com.super_cargo.IO.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
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

    private static BufferStrategy bufferStrategy;

    public static void create(int width, int height, String title, int _clearColor, int numBuffers){
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
            ((Graphics2D)bufferedGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            clearColor = _clearColor;

            created = true;

            content.createBufferStrategy(numBuffers);
            bufferStrategy = content.getBufferStrategy();
        }
    }

    public static void clear(){
        Arrays.fill(bufferedData,clearColor);
    }

    public static Graphics2D getGraphics(){
        return (Graphics2D) bufferedGraphics;
    }

    public static void destroy(){
        if(!created){
            return;
        }else{
            window.dispose();
        }
    }


    public static void swapBuffers(){
        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(buffer, 0,0, null);
        bufferStrategy.show();
    }

    public static void setTitle(String title){
        window.setTitle(title);
    }

    public static void addInputListener(Input inputListener){
        window.add(inputListener);
    }
}
