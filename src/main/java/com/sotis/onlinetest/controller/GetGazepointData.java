package com.sotis.onlinetest.controller;


import com.sotis.onlinetest.model.GazePoint;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GetGazepointData {
    String line = "";
    String[] values;
    String sDate = "";

    public static List<GazePoint> gazeTime = new ArrayList<>();

    public void readCSV(String path) {
        try {
            BufferedReader  br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null) {
                GazePoint gp = new GazePoint();
                values = line.split(",");
                System.out.println(values[11]);
                gp.setGazeTime(values[3]);
                gp.setBpogX(values[11]);
                gp.setBpogY(values[12]);
                gazeTime.add(gp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();;
        }

        /*try {
            sDate = sDate.substring(5,28);
            System.out.println(sDate);
            Date date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(sDate);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

    }
}
