package by.spr.divination.bean;

public class Bud {

	private Leaf leaves[];
	private String color;
	private int size;
	private boolean alreadyBloomed;

	public Bud(int size) {

		this.size = size;
		this.color = "green";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Leaf[] getLeaves() {
		return leaves;
	}

	public void addFreshLeaves(int randomNumber) {

		if (leaves != null) {

		} else {
			leaves = new Leaf[randomNumber];

			for (Leaf leaf : leaves) {
				leaf = new Leaf("white", "ellipse");
			}

		}
	}

}
