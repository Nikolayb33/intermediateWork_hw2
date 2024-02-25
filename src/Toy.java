public class Toy{
    // поля
    private Integer id;
    private String Name;
    private double mass;
    

    // конструктор
    public Toy(Integer id, String name, double mass) {
        this.id = id;
        Name = name;
        this.mass = mass;
    }

    // геттеры
    public Integer getId() {
        return id;
    }


    public String getName() {
        return Name;
    }


    public double getMass() {
        return mass;
    }

    // сеттеры
    public void setId(Integer id) {
        this.id = id;
    }


    public void setName(String name) {
        Name = name;
    }


    public void setMass(Integer mass) {
        this.mass = mass;
    }

    
}