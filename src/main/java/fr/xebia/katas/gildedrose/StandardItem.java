package fr.xebia.katas.gildedrose;

public class StandardItem extends AbstractStoreItem {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	protected int degradeSpeed =1;
	
	@Override
	public void updateQuality() {
		super.updateQuality();
		int actualDegradeSpeed = degradeSpeed;
		if(getSellIn() < 0) {
			actualDegradeSpeed = degradeSpeed*2;
		}
		setQuality(Math.max(getQuality() - actualDegradeSpeed, 0));
	}

}
