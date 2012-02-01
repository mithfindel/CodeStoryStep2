package fr.xebia.katas.gildedrose;

public class AgingItem extends AbstractStoreItem {

	public AgingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		super.updateQuality();
		setQuality(Math.min(getQuality() + 1, 50));
	}

	
}
