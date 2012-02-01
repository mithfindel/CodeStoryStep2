package fr.xebia.katas.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class InnTest {

   Inn inn;

   @Before
   public void createFixture() {
      this.inn = new Inn();
   }

   @Test
   public void qualityIsNeverNegative() {
      inn.getItems().add(new StandardItem("polop", 0, 0));
      inn.updateQuality();
      for(Item item: inn.getItems()) {
         assertThat(item.getQuality()).isGreaterThanOrEqualTo(0);
      }
   }

   @Test
   public void qualityIsNeverMoreThan50ExceptForSulfuras() {
   inn.getItems().add(new StandardItem("polop", 0, 50));
      inn.updateQuality();
      for(Item item: inn.getItems()) {
         if(!((AbstractStoreItem)item).isLegendary()) {
            assertThat(item.getQuality()).isLessThanOrEqualTo(50);
         }
      }
   }

   @Test
   public void qualityOfAgedBrieIncreases() {
      int initialQuality = 0;
      Item agedBrie = new AgingItem("Aged Brie", 2, initialQuality);
      inn.getItems().add(agedBrie);
      inn.updateQuality();
      assertThat(agedBrie.getQuality()).isGreaterThan(initialQuality);
   }

   @Test
   public void legendaryNeverChanges() {
      int initialQuality = 42;
      int initialSellIn = 1;
      Item legendary = new LegendaryItem("Sulfuras, Hand of Ragnaros", initialSellIn, initialQuality);
      inn.getItems().add(legendary);
      inn.updateQuality();
      assertThat(legendary.getQuality()).isEqualTo(initialQuality);
      assertThat(legendary.getSellIn()).isEqualTo(initialSellIn);
   }

   @Test
   public void soldItemsAgeTwiceFaster() {
      int initialQuality = 10;
      int initialSellIn = 2;
      Item aging = new StandardItem("Bastard Sword +15 Against Swallows", initialSellIn, initialQuality);
      inn.getItems().add(aging);
      inn.updateQuality();
      inn.updateQuality();
      inn.updateQuality();
      inn.updateQuality();
      assertThat(aging.getQuality()).isEqualTo(initialQuality - 2 * 1 - 2 * 2);
   }

   @Test
   public void backstagePassesArePITA() {
      int quality = 20;
      Item backstagePasses = new BackstagePassItem(
         "Backstage passes to a TAFKAL80ETC concert", 11, quality);
      inn.getItems().add(backstagePasses);
      inn.updateQuality();
      quality += 1;
      assertThat(backstagePasses.getQuality()).isEqualTo(quality);
      while(backstagePasses.getSellIn() > 5) {
         inn.updateQuality();
         quality += 2;
         assertThat(backstagePasses.getQuality()).isEqualTo(quality);
      }
      while(backstagePasses.getSellIn() > 0) {
          inn.updateQuality();
          quality += 3;
          assertThat(backstagePasses.getQuality()).isEqualTo(quality);
      }
      inn.updateQuality();
      assertThat(backstagePasses.getQuality()).isEqualTo(0);
   }
   
   @Test
   public void conjuredItemsAgeTwiceFaster() {
      int initialQuality = 10;
      int initialSellIn = 2;
      Item aging = new ConjuredItem("Bastard Sword +15 Against Swallows", initialSellIn, initialQuality);
      inn.getItems().add(aging);
      inn.updateQuality();
      inn.updateQuality();
      inn.updateQuality();
      assertThat(aging.getQuality()).isEqualTo(initialQuality - 2 * 2 - 1 * 4);
   }
}