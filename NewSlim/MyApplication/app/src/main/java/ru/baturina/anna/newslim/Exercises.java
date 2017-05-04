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
            new Exercises(R.string.riverting, R.string.riverting_descr, R.drawable.test1),
            new Exercises(R.string.kickback,R.string.kicjback_descr, R.drawable.kikbek),
            new Exercises(R.string.squat, R.string.squat_descr, R.drawable.squat),
            new Exercises(R.string.twists, R.string.twists_descr, R.drawable.twists),
            new Exercises(R.string.jumping, R.string.jumping_descr, R.drawable.jumping),
            new Exercises(R.string.boat, R.string.boat_descr, R.drawable.boat),
            new Exercises(R.string.twisting, R.string.twisting_descr, R.drawable.twisting)
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
