package fr.xebia.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {
   private List<Item> items;

   public Inn() {
      items = new ArrayList<Item>();
      items.add(new StandardItem("+5 Dexterity Vest", 10, 20));
      items.add(new AgingItem("Aged Brie", 2, 0));
      items.add(new StandardItem("Elixir of the Mongoose", 5, 7));
      items.add(new LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80));
      items.add(new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
      items.add(new ConjuredItem("Conjured Mana Cake", 3, 6));
   }

   public void updateQuality() {
      for (Item item: items) {
         ((AbstractStoreItem)item).updateQuality();
      }
   }

   public List<Item> getItems() {
	return items;
}

public static void main(String[] args) {
      System.out.println("OMGHAI!");
      new Inn().updateQuality();
   }

}
