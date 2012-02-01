package fr.xebia.katas.gildedrose;

public class LegendaryItem extends AbstractStoreItem {

	public LegendaryItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		// NOP
	}
	@Override
	public boolean isLegendary() {
		return true;
	}
}
