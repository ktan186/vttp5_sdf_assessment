package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import vttp.batch5.sdf.task01.models.BikeEntry;

// Use this class as the entry point of your program

public class Main {

	public static void main(String[] args) {

		System.out.printf("hello, world\n");

		String line = "";
		List<BikeInfo> info = new ArrayList<>();
		String filename = "day.csv";
		List<BikeInfo> sortedInfo = new ArrayList<>();

		try {
			FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            // // Read and ignore the header line
            br.readLine();

			while ((line = br.readLine()) != null) {
				String[] lineData = line.split(",");

				int season = Integer.parseInt(lineData[0].trim());
				int month = Integer.parseInt(lineData[1].trim());
				boolean holiday = Boolean.parseBoolean(lineData[2].trim());
				int day = Integer.parseInt(lineData[3].trim());
				int weather = Integer.parseInt(lineData[4].trim());
				int casual = Integer.parseInt(lineData[8].trim());
				int registered = Integer.parseInt(lineData[9].trim());

				// int season = BikeEntry.toBikeEntry(lineData).getSeason();
				// int month = BikeEntry.toBikeEntry(lineData).getMonth();
				// boolean holiday = BikeEntry.toBikeEntry(lineData).isHoliday();
				// int day = BikeEntry.toBikeEntry(lineData).getWeekday();
				// int weather = BikeEntry.toBikeEntry(lineData).getWeather();
				// int casual = BikeEntry.toBikeEntry(lineData).getCasual();
				// int registered = BikeEntry.toBikeEntry(lineData).getRegistered();

				// info.add(BikeEntry.toBikeEntry(lineData));

				int total = Integer.parseInt(lineData[8]) + Integer.parseInt(lineData[9]);
				info.add(new BikeInfo(season, month, holiday, day, weather, casual, registered, total));


				// for (int i = 0; i < info.size(); i++) {
				// 	System.out.println(info.get(i));
				// }

				sortedInfo = info.stream().
					sorted(Comparator.comparing(BikeInfo::getTotal).reversed()).collect(Collectors.toList());

				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < sortedInfo.size(); i++) {
			System.out.printf("\n %s \n", sortedInfo.get(i));
		}

		System.out.println(sortedInfo.size());

		String[] position = {"highest", "second highest", "third highest", "forth highest", "fifth highest"};
				
		for (int i = 0; i < position.length; i++) {
			int curSeason = sortedInfo.get(i).getSeason();
			String nSeason = toSeason(curSeason);
			int curDay = sortedInfo.get(i).getDay();
			String nDay = toWeekday(curDay);
			int curMonth = sortedInfo.get(i).getMonth();
			String nMonth = toMonth(curDay);
			int curTotal = sortedInfo.get(i).getTotal();
			String nTotal = Integer.toString(curTotal);
			int curWeather = sortedInfo.get(i).getWeather();
			String nWeather = toWeather(curWeather);
			boolean curHol = sortedInfo.get(i).isHoliday();
			String nHol = toHol(curHol);

			String msg = "The " + position[i] + " recorded number of cyclists was in " 
			+ nSeason + ", on a " + nDay + " in the month of " + nMonth + 
			". There were a total of " + nTotal + " cyclists. The weather was " + 
			nWeather + ". " + nDay + " was " + nHol + ".";

			System.out.println(msg);
			System.out.println("\n");
		}
	}

	public static String toSeason(int season) {
		//season (1:spring, 2:summer, 3:fall, 4:winter)
		switch (season) {
			case 1: return "spring";
			case 2: return "summer";
			case 3: return "fall";
			case 4: return "winter";
			default:
				return "funny season";
		}
	}

	public static String toWeekday(int weekday) {
		switch (weekday) {
			case 0: return "Sunday";
			case 1: return "Monday";
			case 2: return "Tuesday";
			case 3: return "Wednesday";
			case 4: return "Thursday";
			case 5: return "Friday";
			case 6: return "Saturday";
			default:
				return "incorrect day";
		}
	}

	public static String toMonth(int month) {
		switch (month) {
			case 1: return "January";
			case 2: return "Feburary";
			case 3: return "March";
			case 4: return "April";
			case 5: return "May";
			case 6: return "June";
			case 7: return "July";
			case 8: return "August";
			case 9: return "September";
			case 10: return "October";
			case 11: return "November";
			case 12: return "December";
			default:
				return "unknown month";
		}
	}

	public static String toWeather(int weather) {
		switch (weather) {
			case 1: return "Clear, Few clouds, Partly cloudy, Partly cloudy";
			case 2: return "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist";
			case 3: return "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds";
			case 4: return "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog";
			default:
				return "incorrect weather";
		}
	}

	public static String toHol(boolean holiday) {
		if (holiday == true) {
			return "a holiday";
		} else if (holiday == false) {
			return "not a holiday";
		} else {
			return "incorrect holiday";
		}
	}

}
