package com.gregory.ninjagold.controllers;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	int randomNum;
	Random rand;
	int gold = 0;
	ArrayList<String[]> activity = new ArrayList<String[]>();
	
	int size = activity.size();
	
	@RequestMapping("/")
	public String index(HttpServletRequest request){
		ArrayList<String[]> reverse = new ArrayList<String[]>();
	
		for(int i = activity.size() - 1; i >= 0; i--) {
			reverse.add(activity.get(i));
			
		}
		
		
		request.setAttribute("gold", gold);
		request.setAttribute("size", activity.size());
		request.setAttribute("activity", reverse);
		
    		return "index.jsp";
    }
	
	@PostMapping("/process")
	public String process(@RequestParam(value="building") String building ) {
		System.out.println(building);
		
		if(building.equals("farm")) {
			System.out.println("in farm ");
			randomNum = ThreadLocalRandom.current().nextInt(10, 20 + 1);
			
			System.out.println("in farmmmmmm " + randomNum);
			
			gold = gold + randomNum;
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String[] activitystring = {"You entered a farm and won " + randomNum + " gold coins", timeStamp};
			activity.add(activitystring);
			return "redirect:/";
		}
		if(building.equals("cave")) {
			randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
			gold = gold + randomNum;
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String[] activitystring = {"You entered a cave and won " + randomNum + " gold coins", timeStamp};
			activity.add(activitystring);
			return "redirect:/";
		}
		if(building.equals("house")) {
			randomNum = ThreadLocalRandom.current().nextInt(2, 5 + 1);
			gold = gold + randomNum;
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String[] activitystring = {"You entered a house and won " + randomNum + " gold coins", timeStamp};
			activity.add(activitystring);
			return "redirect:/";
		}
		if(building.equals("casino")) {
			randomNum = ThreadLocalRandom.current().nextInt(-50, 50 + 1);
			gold = gold + randomNum;
			if( randomNum >= 0) {
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				String[] activitystring = {"You entered a casino and won " + randomNum + " gold coins", timeStamp};
				activity.add(activitystring);
			}else {
				
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
				String[] activitystring = {"You entered a Casino and lost " + Math.abs(randomNum) + " gold coins like an idiot", timeStamp};
				activity.add(activitystring);
			}
			
			return "redirect:/";
		}
		return "redirect:/";
		
		
		
	}
}
