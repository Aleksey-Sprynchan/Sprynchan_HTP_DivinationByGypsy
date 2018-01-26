package by.spr.divination.runner;

import by.spr.divination.bean.Flower;
import by.spr.divination.logic.Divination;

public class MainRunner {

	public static void main(String[] args) throws InterruptedException {

		Divination div = new Divination();

		boolean yesAnswer = div.needForDivination();
		
		Flower flower = div.gettingBloomedFlower(yesAnswer);

		div.giveGoldToGypsyWoman();

		String chosenTopic = div.chooseTopicForDivination();

		String result = div.predict(flower, chosenTopic);

		printPrediction(result, chosenTopic);

	}

	public static void printPrediction(String prediction, String chosenTopic) throws InterruptedException {
		
		System.out.println("So, you want to know more about you future, specifically about " + chosenTopic);
		Thread.sleep(2000);
		System.out.println("I think, it will be....");
		Thread.sleep(2000);
		System.out.println("Oh, I see...");
		Thread.sleep(4000);

		System.out.println("Yes, my prediction is " + prediction);

	}

}
