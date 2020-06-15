package Model;

public class InHouse extends Part
{
    private int machineId;

    /**
     * Create new InHouse part keep existing ID
     */public InHouse(int id, String name, double price, int stock, int min, int max, int machineId)
    {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    /**
     * Create new InHouse part auto-generate ID
     */public InHouse(String name, double price, int stock, int min, int max, int machineId)
    {
        super(name, price, stock, min, max);
        this.machineId = machineId;
    }

    public int getMachineId()
    {
        return machineId;
    }

    public void setMachineId(int machineId)
    {
        this.machineId = machineId;
    }
}
