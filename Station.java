public class Station {

    protected String name;//name of station
    protected String lineColor;//lineColor of station
    protected boolean inService;//boolean for whether station is in service/available
    protected Station previous;//connection to previous station
    protected Station next;//connection to next station 

    public Station(String name, String lineColor){
        this.name = name;
        this.lineColor = lineColor;
        this.inService = true; 
        //this.previous = null;
        //this.next = null; 
    }                                                       

    public void addNext(Station n){
        //need a null checker?
        this.next = n;
        n.previous = this;                              
        // if (n != null){
        //     this.next = n; 
        // }
    }

    public void addPrev(Station p){
        //need a null checker?
        this.previous = p;                   
        p.next = this; 
        // if (p != null){
        //     this.previous = p;
        // }
    }

    public boolean equals(Station s){
        if(this == s){
            return true;
        }
        if(this.lineColor == s.lineColor || this.name == s.name){
            return true;
        }
        else{
            return false;
        }

    }

    //
    public int tripLength(){
        return ;
    }

    public void connect(Station s) {
        this.next = s;
        s.previous = this;
    }

    public boolean isAvailable(){
        return inService;
    }

    public void switchAvailable(){
        inService = !inService; 
    }

    public String toString(){
        //turn to none?
        return "STATION " + name + ": " + lineColor + " line," + " in service:" + inService + ", previous station: " + previous + ", next station: " + next ; 
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
