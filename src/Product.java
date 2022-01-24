public class Product {
    private String ID;
    private String Name;
    private String Description;
    private double Cost;

    public Product(String ID, String name, String description, double cost) {
        this.ID = ID;
        Name = name;
        Description = description;
        Cost = cost;
    }

    @Override
    public String toString() {
        return "Product {" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cost='" + Cost + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }
    public String toCSVDataRecord() {
        return (ID + ", " + Name + ", " + Description + ", " + Cost);
    }
}
