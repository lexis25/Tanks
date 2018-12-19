package com.super_cargo.utils;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static BufferedImage resize(BufferedImage image, int width, int height) {

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        newImage.getGraphics().drawImage(image, 0, 0, width, height, null);
        return newImage;
    }

    public static int[][] levelParser(String filePath){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            List<Integer[]> lvlLines = new ArrayList<Integer[]>();
            while ((line = reader.readLine()) != null){
                lvlLines.add(str2int_arrays(line.split(" ")));
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public static final Integer[] str2int_arrays(String [] sArr){
        Integer[] result = new Integer[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            result[i] = Integer.parseInt(sArr[i]);
        }

        return result;
    }


}