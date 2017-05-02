package ru.baturina.anna.adapterpictures;


public class Exercise {
    private int nameId;
    private int descriptionId;
    private int imageId;


    // В объекте Workout хранится имя и описание

    public Exercise(int nameId, int descriptionId, int imageId) {
        this.nameId = nameId;
        this.descriptionId = descriptionId;
        this.imageId = imageId;
    }

    public static final Exercise[] exercises = {
            new Exercise(R.string.riverting, R.string.riverting_descr, R.drawable.riveting),
            new Exercise(R.string.kickback,R.string.kicjback_descr, R.drawable.kikbek),
            new Exercise(R.string.squat, R.string.squat_descr, R.drawable.squat),
            new Exercise(R.string.twists, R.string.twists_descr, R.drawable.twists),
            new Exercise(R.string.jumping, R.string.jumping_descr, R.drawable.jumping),
            new Exercise(R.string.boat, R.string.boat_descr, R.drawable.boat),
            new Exercise(R.string.twisting, R.string.twisting_descr, R.drawable.twisting)
    };


    public int getName() {
        return nameId;
    }

    public void setName(int nameID)
    {
        this.nameId = nameId;
    }

    public int getDescription() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
