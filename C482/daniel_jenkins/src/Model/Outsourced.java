package Model;

public class Outsourced extends Part
{
    private String companyName;

    /**
     * Create new Outsource part keep existing ID
     */public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName)
    {
        super(id, name, price, stock, min, max);
        this.companyName = companyName;

    }

    /**
     * Create new Outsource part auto-gen ID
     */public Outsourced(String name, double price, int stock, int min, int max, String company)
    {
        super(name, price, stock, min, max);
        this.companyName = company;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
}

