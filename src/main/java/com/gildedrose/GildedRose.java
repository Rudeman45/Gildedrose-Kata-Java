package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateQuality(items[i]);
        }
    }

    private void doUpdateQuality(Item item) {
        switch (item.name) {
            case "Aged Brie":
                doUpdateQualityAgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                doUpdateQualityBackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
                //Modification for the new item: Conjured mana cakes
            case "Conjured Mana Cake":
                doUpdateQualityConjured(item);
                break;
            default:
                doUpdateQualityDefault(item);
                break;
        }
    }

    private void doUpdateQualityDefault(Item item) {
        doUpdateQualityMinQuality(item);
        doUpdateSellInDecrease(item);
        if (item.sellIn < 0) doUpdateQualityMinQuality(item);
    }
    private void doUpdateQualityConjured(Item item){
        doUpdateQualityDefault(item);
        doUpdateQualityMinQuality(item);
    }
    private void doUpdateQualityBackstagePasses(Item item) {
        doUpdateQualityMaxQuality(item);
        {
            if (item.sellIn < 11) {
                doUpdateQualityMaxQuality(item);
            }
            if (item.sellIn < 6) {
                doUpdateQualityMaxQuality(item);
            }
        }
        doUpdateSellInDecrease(item);
        if (item.sellIn < 0) item.quality = 0;
    }
    private void doUpdateQualityAgedBrie(Item item) {
        doUpdateQualityMaxQuality(item);
        doUpdateSellInDecrease(item);
        if (item.sellIn < 0) doUpdateQualityMaxQuality(item);
    }
    private void doUpdateQualityMaxQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
    private void doUpdateQualityMinQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
    private void doUpdateSellInDecrease(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}