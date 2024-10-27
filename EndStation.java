
public class EndStation extends Station{

    public EndStation(String name, String lineColor){
        super(name, lineColor);
    }

    public void makeEnd(){
        this.previous = this.next;
    }

    public String toString(){
        return "ENDSTATION " + name + ": " + lineColor + ", in service: " + inService + ", previous station: " + previous + ", next station: " + next;
    }
}
