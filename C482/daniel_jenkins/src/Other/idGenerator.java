package Other;

import Model.Part;
import Model.Product;

public class idGenerator
{
    private static int partID = 0;
    private static int prodID = 0;

    public idGenerator(Part part)
    {
        if (part != null)
        {
            partID++;
        }
    }

    public idGenerator(Product product)
    {
        if (product != null)
        {
            prodID++;
        }
    }

    public static int getPartID()
    {
        return partID;
    }

    public  void setPartID(int partID)
    {
        idGenerator.partID = partID;
    }

    public static int getProdID()
    {
        return prodID;
    }

    public  void setProdID(int prodID)
    {
        idGenerator.prodID = prodID;
    }
}
