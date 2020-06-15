package Model;
import Other.idGenerator;


public abstract class Part
{
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private int id;

    /**
     * Create new part keep existing ID
     */protected Part(int id, String name, double price, int stock, int min, int max)
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.id = id;
    }
    /**
     * Create new part auto-generate ID
     */protected Part(String name, double price, int stock, int min, int max)
    {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.id = setID();

    }

    public int setID()
    {
        new idGenerator(this);
        return this.id = idGenerator.getPartID();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getMin()
    {
        return min;
    }

    public void setMin(int min)
    {
        this.min = min;
    }

    public int getMax()
    {
        return max;
    }

    public void setMax(int max)
    {
        this.max = max;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
