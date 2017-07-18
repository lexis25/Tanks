package com.super_cargo.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static BufferedImage resize(BufferedImage image, int width, int height) {

        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        newImage.getGraphics().drawImage(image, 0, 0, width, height, null);
        return newImage;
    }

    public static Integer[][] levelParser(String filePath){

        Integer[][]result = null;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            List<Integer[]> levelLines = new ArrayList<Integer[]>();
            while ((line = reader.readLine()) != null){
                levelLines.add(str2int_arrays(line.split(" ")));
            }
            result = new Integer[levelLines.size()][levelLines.get(0).length];
            for (int i = 0; i < levelLines.size() ; i++) {
                result[i] = levelLines.get(i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }



        return result;
    }

    public static final Integer[] str2int_arrays(String [] sArr){
        Integer[] result = new Integer[sArr.length];

        for (int i = 0; i < sArr.length; i++) {
            result[i] = Integer.parseInt(sArr[i]);
        }

        return result;
    }


}
