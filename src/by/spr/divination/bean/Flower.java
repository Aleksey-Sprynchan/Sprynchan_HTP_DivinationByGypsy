package by.spr.divination.bean;

public class Flower {

	private String title;
	private Bud bud;
	private Stem stem;
	private int numberOfLeaves;
	private boolean alreadyBloomed;

	public Flower(String title) {
		this.title = title;
		bud = new Bud(2);
		stem = new Stem(10, 1);

	}

	public void grow() {
		this.stem.setHeight(25);
		this.stem.setWidth(3);
		this.bud.setSize(8);

	}

	public void bloom() {

		if (this.isAlreadyBloomed() == true) {
			System.out.println("Your flower has already bloomed!");
		} else {
			this.bud.setSize(this.bud.getSize());
			this.bud.setColor("yellow");
			this.numberOfLeaves = (int) (Math.random() * 21) + 13;
			this.bud.addFreshLeaves(numberOfLeaves);
		}

		this.setAlreadyBloomed(true);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Bud getBud() {
		return bud;
	}

	public void setBud(Bud bud) {
		this.bud = bud;
	}

	public Stem getStem() {
		return stem;
	}

	public void setStem(Stem stem) {
		this.stem = stem;
	}

	public int getNumberOfLeaves() {
		return numberOfLeaves;
	}

	public void setNumberOfLeaves(int numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}

	public boolean isAlreadyBloomed() {
		return alreadyBloomed;
	}

	public void setAlreadyBloomed(boolean alreadyBloomed) {
		this.alreadyBloomed = alreadyBloomed;
	}

}
