
public class Bird {
    private String name, latinName;
    private int obsrv;
    
    public Bird(String name, String latinName){
        this.name = name;
        this.latinName = latinName;
        obsrv = 0;
    }
    
    public String name(){
        return this.name;
    }
    
    public void observe(){
        this.obsrv++;
    }
    
    public String toString(){
        return this.name+" ("+this.latinName+"): "+this.obsrv+" observations";
    }
 
}
 