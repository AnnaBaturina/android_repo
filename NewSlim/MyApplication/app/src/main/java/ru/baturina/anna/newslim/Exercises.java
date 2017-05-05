package ru.baturina.anna.newslim;


public class Exercises {
    private int nameId;
    private int descriptionId;
    private int imageId;


    // В объекте Workout хранится имя и описание

    private Exercises(int nameId, int descriptionId, int imageId) {
        this.nameId = nameId;
        this.descriptionId = descriptionId;
        this.imageId = imageId;
    }

    public static final Exercises [] exercises = {
            new Exercises(R.string.first, R.string.firstDescr, R.drawable.first),
            new Exercises(R.string.second,R.string.firstDescr, R.drawable.second),
            new Exercises(R.string.third, R.string.thirdD, R.drawable.third),
            new Exercises(R.string.fourth, R.string.fourthD, R.drawable.fourth),
            new Exercises(R.string.fifth, R.string.firstDescr, R.drawable.fifth),
            new Exercises(R.string.sixth, R.string.firstDescr, R.drawable.sixth),
            new Exercises(R.string.seveth, R.string.firstDescr, R.drawable.seventh),
            new Exercises(R.string.eigth, R.string.firstDescr, R.drawable.eighth),
            new Exercises(R.string.nineth, R.string.firstDescr, R.drawable.nineth),
            new Exercises(R.string.tenth, R.string.firstDescr, R.drawable.tenth),
    };


    public int getName() {
        return nameId;
    }

    public int getDescription() {
        return descriptionId;
    }

    public int getImageId() {
        return imageId;
    }


}
