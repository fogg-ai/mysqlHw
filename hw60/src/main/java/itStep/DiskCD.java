package itStep;

public class DiskCD {
    private int id;
    private String name;
    private int cost;

    public DiskCD(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "DiskCD{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

}
