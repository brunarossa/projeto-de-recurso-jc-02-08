public abstract class Product{
    private String name;
    private double weight;
    private static int id;
    private String type;

    public Product(String name, double weight, String type) {
        id++;
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public static void setId(int id) {
        Product.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public static int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
