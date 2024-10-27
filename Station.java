public class Station {

    protected String name;//name of station
    protected String lineColor;//lineColor of station
    protected boolean inService;//boolean for whether station is in service/available
    protected Station previous;//connection to previous station
    protected Station next;//connection to next station 


    public Station(String lineColor, String name){
        this.lineColor = lineColor;
        this.name = name;
        this.inService = true; 
        this.previous = null;
        this.next = null; 
    }                                                       

    public void addNext(Station n){
        //need a null checker?
        if(n != null){
        this.next = n;
        n.previous = this;  
        }                            
        // if (n != null){
        //     this.next = n; 
        // }
    }

    public void addPrev(Station p){
        //need a null checker?
        if(p != null){
        this.previous = p;                   
        p.next = this; 
        }
        // if (p != null){
        //     this.previous = p;
        // }
    }

    public boolean equals(Station s){
        if(this == s){
            return true;
        }
       if(this.lineColor == s.lineColor && this.name == s.name){
            return true;
        }
        else{
            return false;
        }

    }

    public int tripLength(Station dest){
        return 0;
    }

    public void connect(Station s) {
        this.next = s;
        s.previous = this;
    }

    public boolean isAvailable(){
        return this.inService;
    }

    public void switchAvailable(){
        this.inService = !this.inService; 
    }

    public String getPreviousName(){
        if (previous == null || previous.name == null){
            return "none";
        }
        else{
            return previous.name;
        }
    }

    public String getNextName(){
        if (next == null || next.name == null){
            return "none";
        }
        else{
            return next.name;
        }
    }

    public String toString(){
        String prevName = getPreviousName();
        String nextName = getNextName();
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
