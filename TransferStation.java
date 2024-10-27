import java.util.ArrayList;

public class TransferStation extends Station {

    protected ArrayList<Station> otherStations;

    public TransferStation(String lineColor, String name){
        super(lineColor, name);
        otherStations = new ArrayList<Station>();
    }

    public void addTransferStationPrev(Station s){
        otherStations.add(s);
        s.next = this;
    }

    public void addTransferStationNext(Station s){
        otherStations.add(s);
        s.previous = this;
    }

    public String toString(){
        String start = "TRANSFER" + super.toString() + "\n\tTransfers: \n";
        if (otherStations != null){
            for (int i = 0; i < otherStations.size(); i++){
                start = start + "\t" + otherStations.get(i).toString() + "\n";
            }
        }
        return start;
    }







}
