package by.spr.divination.logic;

import java.util.HashMap;
//import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.spr.divination.bean.Flower;

public class Divination {

	private Map<String, String[]> divMap;

	public Divination() {
		super();
		divMap = new HashMap<>();

	}

	public Map<String, String[]> getDivMap() {
		return divMap;
	}

	public void setDivMap(Map<String, String[]> divMap) {
		this.divMap = divMap;
	}

	Scanner sc = new Scanner(System.in);

	public boolean needForDivination() {

		System.out.println("Do you want to know what will happend to you in the future? (please, enter YES or NO)");
		String answer = (sc.nextLine()).toUpperCase();

		while (true) {
			if (answer.equals("YES")) {
				return true;
			} else if (answer.equals("NO")) {
				return false;
			} else {
				System.out.println("I don't understand you! Please, answer YES or NO.");
				answer = (sc.nextLine()).toUpperCase();
			}

		}

	}

	public Flower gettingBloomedFlower(boolean answer) {
		if (answer == true) {
			Flower flower = new Flower("Chamomile");
			flower.bloom();
			return flower;
		} else {
			System.out.println("I PUT A SPELL ON YOU, greedy man!!! GoodBye...");
			Runtime rt = Runtime.getRuntime();
			rt.exit(0);
		}
		return null;
	}

	public void giveGoldToGypsyWoman() {

		divMap.put("Position at work", new String[] { "CEO", "Engineer", "Unemployed", "Artist", "JAVA developer" });
		divMap.put("Flat", new String[] { "1 bedroom", "2 bedroom", "3 bedroom", "Big house" });
		divMap.put("Number of children", new String[] { "1", "2", "3" });
		divMap.put("Car", new String[] { "Mercedes", "Toyota", "BMW", "Geely", "Jaguar" });
		divMap.put("County you will live in 10 years", new String[] { "Belarus", "China", "UK", "USA", "India" });

	}

	public String chooseTopicForDivination() {
		System.out.println("Choose a topic for divination:");

		String[] topics = divMap.keySet().toArray(new String[divMap.size()]);

		for (int i = 0; i < topics.length; i++) {
			System.out.println(i + 1 + ". " + topics[i]);
		}

		System.out.println("Enter topic number:");
		String answer = sc.nextLine();

		int numberOfTopic = 0;

		while (true) {
			if (checkInt(answer)) {
				numberOfTopic = Integer.parseInt(answer);
				if (numberOfTopic < 1 || numberOfTopic > topics.length) {
					System.out.println("You can choose only from these topics. Enter valid topic number!");
					answer = sc.nextLine();
				} else {
					return topics[numberOfTopic - 1];

				}
			} else {
				System.out.println("You entered not a number. Enter integer number!");
				answer = sc.nextLine();
			}
		}

	}

	public static boolean checkInt(String s) {

		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public String predict(Flower flower, String topic) {

		int leaves = flower.getNumberOfLeaves();
		String[] variantsForTopic = divMap.get(topic);
		int predictedId = leaves % variantsForTopic.length;

		return variantsForTopic[predictedId];

	}

}
