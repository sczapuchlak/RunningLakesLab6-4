package com.Stephanie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class RunningControls {


    //create new scanners, define variables
    static Scanner stringScanner = new Scanner(System.in);
    static Scanner numberScanner = new Scanner(System.in);
    static HashMap lakeRunTimes = new HashMap();
    static ArrayList<RunningControls> RunTotals = new ArrayList();
    public String lakeName;
    double runningTime;

    RunningControls(String lake, double timeRan){

    lakeName =lake;
    runningTime= timeRan;
}
//get the lake and time
String getLake(){
    return lakeName;
}
Double getTimeRan(){
    return runningTime;
}

// ask user for lake name and time it took to run around the lake
    public static void addTime() {

        System.out.println("How many times did you run?");
        int numberOfRuns = numberScanner.nextInt();
        for (int x = 0; x < numberOfRuns; x++) {
            System.out.println("What was the lake name for run number " + ( ++x));
            String lake = stringScanner.nextLine();
            System.out.println("How fast did you run the lake?(In minutes.seconds): ");
            Double timeRan = numberScanner.nextDouble();
            RunTotals.add(new RunningControls(lake, timeRan));

    }}

    static void FastestTime() {
        for (RunningControls eachTime : RunTotals) {
            String lake = eachTime.getLake();
            if (lakeRunTimes.containsKey(lake)) {
                Double minimumTime = 0.0;
                Double time = eachTime.getTimeRan();
                Double fasterTime= (Double) lakeRunTimes.get(lake);
                if (time < fasterTime) {
                    minimumTime = time;
                }
               lakeRunTimes.replace(lake, fasterTime, minimumTime);
            } else {
                Double time = eachTime.getTimeRan();
                lakeRunTimes.put(lake, time);
            }
        }
        System.out.println("Your fastest times are as follows: " + lakeRunTimes);
    }
}

