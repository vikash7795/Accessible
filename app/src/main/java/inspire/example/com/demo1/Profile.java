package inspire.example.com.demo1;

/*
 * Created by vikash on 5/10/2016.
 */
public class Profile {
    public static final Profile[] pizzas = {
            new Profile("Food", R.drawable.foodd),
            new Profile("Shopping", R.drawable.finalshopping),
            new Profile("Entertainment",R.drawable.entertainment),

            new Profile("Health",R.drawable.health),
            new Profile("Education",R.drawable.education),
            new Profile("Accessible Washrooms",R.drawable.wash),
            new Profile("Banking",R.drawable.b),
            new Profile(" Disability Events",R.drawable.devent),
            new Profile("Public Transport",R.drawable.citycentre),
            new Profile("Accessible Tours",R.drawable.tours),
            new Profile("Accessible Cabs",R.drawable.cab1),
            new Profile("Accessible Buildings",R.drawable.access),

    };
    private String name;
    private int imageResourceId;
    private Profile(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}