package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory
{

    private static final ObservableList<Part> allParts= FXCollections.observableArrayList();
    private static final ObservableList<Product> allProducts= FXCollections.observableArrayList();

    public static void addPart(Part newPart)
    {
        allParts.add(newPart);
    }
    public static void addProduct(Product newProduct)
    {
        allProducts.add(newProduct);
    }

    public int lookupPart(int partId)
    {
        return partId;
    }
    public int lookupProduct(int productId)
    {

        return productId;
    }

    public static ObservableList<Part> lookupPart(String partName)
    {
        return allParts;
    }
    public static ObservableList<Product> lookupProduct(String productName)
    {
        return allProducts;
    }

    public static ObservableList<Part> getAllParts()
    {
        return allParts;
    }
    public static ObservableList<Product> getAllProducts()
    {
        return allProducts;
    }

    public static void updatePart(Part part, int index)
    {
    }

    public static void upDateProduct(Product product, int index)
    {
    }

    public boolean deletePart(Part part)
    {
        if (allParts.contains(part))
        {
            allParts.remove(part);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(Product product)
    {
        if (allProducts.contains(product))
        {
            allProducts.remove(product);
            return true;
        } else {
            return false;
        }
    }
}
