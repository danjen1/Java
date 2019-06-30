public class Reformatory {
    private int count;
    
    public int weight(Person person) {
        this.count++;
        return person.getWeight();
    }
    
    public void feed(Person person){
         int weight = person.getWeight();
         person.setWeight(weight + 1);         
    }
    
    public int totalWeightsMeasured(){
        return count;
    }

}
