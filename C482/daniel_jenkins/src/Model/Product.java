package Model;

import Other.idGenerator;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class Product
{
    private  int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    @FXML
    private ObservableList<Part> associatedParts;


    /**
     * Create new product keep existing ID
     */public Product(String name,
                   double price,
                   int stock,
                   int min,
                   int max,
                   ObservableList<Part> associatedParts)
    {

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
        this.id = setID();
    }
    /**
     * Create new product aute-generate ID
     */
    public Product(int id,
                   String name,
                   double price,
                   int stock,
                   int min,
                   int max,
                   ObservableList<Part> associatedParts)
    {

        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.associatedParts = associatedParts;
        this.id = id;
    }

    public int setID()
    {
        new idGenerator(this);
        return this.id = idGenerator.getProdID();
    }
    public void setID(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public ObservableList<Part> getAssociatedParts()
    {
        return associatedParts;
    }

    public void setAssociatedParts(ObservableList<Part> associatedParts)
    {
        this.associatedParts = associatedParts;
    }
}
