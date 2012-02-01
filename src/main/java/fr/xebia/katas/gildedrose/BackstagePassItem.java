package fr.xebia.katas.gildedrose;

public class BackstagePassItem extends AbstractStoreItem {

	public BackstagePassItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void updateQuality() {
		int sellIn = getSellIn();
		if (sellIn <= 0) {
			setQuality(0);
		} else if (sellIn < 6) {
			setQuality(Math.min(getQuality()+3, 50));
		} else if (sellIn < 11) {
			setQuality(Math.min(getQuality()+2, 50));
		} else {
			setQuality(Math.min(getQuality()+1, 50));
		}
		super.updateQuality();
	}

}
