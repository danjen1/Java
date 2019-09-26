
public class Apartment {

    private final int rooms;
    private final int squareMeters;
    private final int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }
    
    public boolean larger(Apartment otherApartment){
        return this.squareMeters > otherApartment.squareMeters;
    }
    
    private int price(){
        return pricePerSquareMeter * squareMeters;
    }
    
    public int priceDifference(Apartment otherApartment){
        return Math.abs(this.price() - otherApartment.price());
    }
    public boolean moreExpensiveThan(Apartment otherApartment){
        return this.price() - otherApartment.price() > 0;
    }
}
