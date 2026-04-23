public class Ingredient {
    protected String name;
    protected int calories;
    protected boolean vegetarian;

    public Ingredient(String name, int calories, boolean vegetarian) {
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
    }

    public static Ingredient fromCSV(String csvLine) {
        String [] parts = csvLine.split(",");
        boolean vegi = false;

        if (parts[2].equals("true")) {
            vegi = true;
        }

        return new Ingredient(parts[0], Integer.parseInt(parts[1]), vegi);
    }

    public String toXML() {
        return  "        <ingredient>\n" +
                "          <name>" + name + "</name>\n" +
                "          <calories>" + calories + "</calories>\n" +
                "          <vegetarian>" + vegetarian + "</vegetarian>\n" +
                "        </ingredient>\n";
    }

    public int getCalories() {
        return calories;
    }
}
