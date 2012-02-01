package fr.xebia.katas.gildedrose;

public abstract class AbstractStoreItem extends Item {

	public AbstractStoreItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateQuality() {
		setSellIn(getSellIn() - 1);
	}
	
	public boolean isLegendary(){
		return false;
	}
}
