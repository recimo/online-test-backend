package com.sotis.onlinetest;

import com.sotis.onlinetest.controller.GetTripletsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinetestApplication.class, args);
		//String path = "F:/Faks master/SOTIS/testiranje/zad1/result/User 1 Dejan R_fixations.csv";
		//GetGazepointData gpd = new GetGazepointData();
		//gpd.readCSV(path);
		GetTripletsController gt = new GetTripletsController();
		gt.getTriplets();
	}

}
