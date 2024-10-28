
public class EndStation extends Station{

    public EndStation(String lineColor, String name){
        super(lineColor, name);
    }

    public void makeEnd(){
        if(this.next != null){
        this.previous = this.next;
        }

        if(this.previous != null){
        this.next = this.previous;
        }
    }

    public String toString(){
        return "END" + super.toString();//calling on toString method from Station 
        //+ name + ": " + lineColor + " line, in service:" + inService + ", previous station: " + prevName + ", next station: " + nextName ;
    }
}
