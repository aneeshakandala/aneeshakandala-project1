import java.util.ArrayList;

public class Station {

    protected String name;//name of station
    protected String lineColor;//lineColor of station
    protected boolean inService;//boolean for whether station is in service/available
    protected Station previous;//connection to previous station
    protected Station next;//connection to next station 


    public Station(String lineColor, String name){//initializing 
        this.lineColor = lineColor;
        this.name = name;
        this.inService = true; 
        this.previous = null;
        this.next = null; 
    }                                                       

    public void addNext(Station n){
        //need a null checker
        if(n != null){
        this.next = n;
        n.previous = this;  
        }                            
    }

    public void addPrev(Station p){
        //need a null checker
        if(p != null){
        this.previous = p;                   
        p.next = this; 
        }
    }

    public boolean equals(Station s){
        if(this == s){
            return true;
        }
       if(this.lineColor == s.lineColor && this.name == s.name){
            return true;
        }
        
        return false;

    }


    public int tripLength(Station destination) {
        ArrayList<Station> visitedStations = new ArrayList<Station>();
        Station current = this;
        //System.out.println(this.toString());
        return tripLength_helper(destination, 0, current, visitedStations);
    }


     public int tripLength_helper(Station destination, int count, Station current, ArrayList<Station> visitedStations){
        if(current.equals(destination)){
            return count;
        }
        if(current.next == null){
            return -1;
        }
        for(int i = 0; i < visitedStations.size(); i++) {
            if(visitedStations.get(i) == current) {
                return -1;
            }
        }
        visitedStations.add(current);

        if(current instanceof TransferStation){
            TransferStation transfer = (TransferStation) current;

            for(int i = 0; i < transfer.otherStations.size(); i++){
                Station t = transfer.otherStations.get(i);
                if(t.lineColor == destination.lineColor){
                    int transferpath = tripLength_helper(destination, count + 1, t, visitedStations);
                    if(transferpath != -1){
                        return transferpath;
                    }
                }
            }
        }
        return tripLength_helper(destination, count + 1, current.next, visitedStations);
    }

    public void connect(Station s) {
        if(s != null) {
            this.addNext(s);
            s.addPrev(this);
        }
    }

    public boolean isAvailable(){
        return this.inService;
    }

    public void switchAvailable(){
        this.inService = !this.inService; //switching from inService to not inService, therefore switching the availability 
    }

    public String toString(){
        String prevName = "";
        String nextName = "";

        if(previous == null || previous.name == null){//checking whether there is a previous station or not
            prevName = "none"; //returning null if station does not exist
        }
        else{
            prevName = previous.name;//returning name as usual
        }
        if(next == null || next.name == null){
            nextName = "none";//returning null is station does not exist
        }
        else{
            nextName = next.name;//returning name as usual
        }

        return "STATION " + this.name + ": " + this.lineColor + " line, in service: " + this.inService + ", previous station: " + prevName + ", next station: " + nextName ; 
    }

    public String getName(){
        return name;
    }

    public String getlineColor(){
        return lineColor;
    }

    public Station getPrevious(){
        return previous;
    }

    public Station getNext(){
        return next;
    }



    

    












































}
