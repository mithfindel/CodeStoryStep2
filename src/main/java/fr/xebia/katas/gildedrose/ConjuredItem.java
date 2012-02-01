package fr.xebia.katas.gildedrose;

public class ConjuredItem extends StandardItem {

	public ConjuredItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
		degradeSpeed = 2;
	}

	
}
