
import java.util.ArrayList;


/**
 *
 * @author daniel
 */
public class BirdDatabase {
    private ArrayList<Bird> birds;
    
    public BirdDatabase(){
        birds = new ArrayList<Bird>();
    }
    
    public boolean observed(String name){
        for (Bird bird : birds){
            if (bird.name().equals(name)){
                bird.observe();
                return true;
            }
        }
        return false;
    }
    
    public void addBird(String name, String latinName){
        birds.add(new Bird(name, latinName));
    }
    
    public String showBird(String name){
        for (Bird bird : birds){
            if (bird.name().equals(name)){
                return bird.toString();
            }
        }
        return null;
    }
    
    public String statistics(){
        String allBirds = "";
        for (Bird bird : birds){
            allBirds += bird.toString() + "\n";
        }
        return allBirds;
    }
    
    
}
