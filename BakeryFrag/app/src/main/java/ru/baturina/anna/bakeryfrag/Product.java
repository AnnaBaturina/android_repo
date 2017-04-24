package ru.baturina.anna.bakeryfrag;

/**
 * Created by msipc on 19.04.2017.
 */


public class Product {
    private int name;
    private int description;
    private int imageResourceId;


    // В объекте  хранится имя и описание
    private Product(int name, int description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public static final Product[] breads = {
            (new Product(R.string.bread, R.string.breaddescr, R.drawable.frbread)),
            (new Product(R.string.cake, R.string.cakedescr, R.drawable.frcake)),
            (new Product(R.string.coockie, R.string.coockiedescr, R.drawable.frcookies)),
    }
            ;

    public static final Product[] chocolates = {
            (new Product(R.string.chocolateDark, R.string.chocolateDarkdescr, R.drawable.frmdarkchoc)),
            (new Product(R.string.chocolateMilk, R.string.chocolateMilkdescr, R.drawable.frmilkchoc)),
            (new Product(R.string.chocolateWhite, R.string.chocolateWhitedescr, R.drawable.frmwhitechoc)),
    }
            ;


    public static final Product[] confects = {
            (new Product(R.string.cake2, R.string.cake2descr, R.drawable.frcake2)),
            (new Product(R.string.smallCake2, R.string.smallCake2descr, R.drawable.frmsmallcake2)),
    }
            ;


    public static final Product[] addresses = {
            (new Product(R.string.addr1short, R.string.addr1, R.drawable.addr1)),
            (new Product(R.string.addr2short, R.string.addr2, R.drawable.addr2)),
            (new Product(R.string.addr3short, R.string.addr3, R.drawable.addr3)),
    }
            ;

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

//    @Override
//    public String toString() {
//        return this.name;
//    }


}
