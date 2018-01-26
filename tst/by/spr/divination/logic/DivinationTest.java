package by.spr.divination.logic;

import static org.junit.Assert.*;

import org.junit.Test;

import by.spr.divination.bean.Flower;

import org.junit.Before;

public class DivinationTest {

	private Divination div;

	@Before
	public void initDivination() {
		div = new Divination();

	}

	@Test
	public void testDivinationMapNotNull() {
		assertNotNull("Divination was not initialized", div.getDivMap());

	}

	@Test
	public void testIfHaveYesAnswer() {
		if (div.needForDivination() != true) {
			fail();
		}
	}

	@Test
	public void testIfHaveFlowerAfterYesAnswer() {
		boolean answer = div.needForDivination();

		assertNotNull("Flower was not initialized", div.gettingBloomedFlower(answer));

	}

	@Test
	public void testIfFlowerIsAreadyBloomed() {
		if (div.gettingBloomedFlower(true).isAlreadyBloomed() == false) {
			fail("Flower has not bloomed yet");
		}

	}

	@Test
	public void testExistingChosenTopic() {
		div.giveGoldToGypsyWoman();
		String[] topics = div.getDivMap().keySet().toArray(new String[div.getDivMap().size()]);
		String choice = div.chooseTopicForDivination();
		boolean exist = false;
		for (String s : topics) {
			if (choice.equals(s)) {
				exist = true;
			}
		}

		assertEquals("Chosen topic is not exist", true, exist);

	}

	@Test
	public void testIfPredictValueIsFromDivinationMap() {

		Flower flower = div.gettingBloomedFlower(true);
		div.giveGoldToGypsyWoman();		
		String chosenTopic = div.chooseTopicForDivination();
		String result = div.predict(flower, chosenTopic);
		
		String[] values = div.getDivMap().get(chosenTopic);
		
		boolean b = false;
		for(String s: values) {
			if (result.equals(s)) {
				b = true;
			}
		}
		
		assertEquals("Predicted value is not from initial DivinationMap", true, b);

	}

}
