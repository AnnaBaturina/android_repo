package ru.baturina.anna.bakeryfrag;

/**
 * Created by msipc on 19.04.2017.
 */


public class Product {
    private String name;
    private int description;
    private int imageResourceId;


    // В объекте  хранится имя и описание
    private Product(String name, int description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static final Product[] breads = {
            (new Product("Хлеб", R.string.breaddescr, R.drawable.frbread)),
            (new Product("Кексы", R.string.cakedescr, R.drawable.frcake)),
            (new Product("Печенье", R.string.coockiedescr, R.drawable.frcookies)),
    }
            ;

    public static final Product[] chocolates = {
            (new Product("Черный (горький) шоколад", R.string.chocolateDarkdescr, R.drawable.frmdarkchoc)),
            (new Product("Молочный шоколад", R.string.chocolateMilkdescr, R.drawable.frmilkchoc)),
            (new Product("Белый шоколад", R.string.chocolateWhitedescr, R.drawable.frmwhitechoc)),
    }
            ;


    public static final Product[] confects = {
            (new Product("Торты", R.string.cake2descr, R.drawable.frcake2)),
            (new Product("Пирожные", R.string.smallCake2descr, R.drawable.frmsmallcake2)),
    }
            ;


    public static final Product[] addresses = {
            (new Product("Булочная на Пятницкой", R.string.addr1, R.drawable.addr1)),
            (new Product("Булочная на проспекте Мира", R.string.addr2, R.drawable.addr2)),
            (new Product("Булочная на Арбате (скоро открытие)", R.string.addr3, R.drawable.addr3)),
    }
            ;


}
