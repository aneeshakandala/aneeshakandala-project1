import java.util.ArrayList;

public class TransferStation extends Station (

    private ArrayList<Station> transferList = new ArrayList<>();

    public TransferStation(String name, String lineColor){
        super(name, lineColor);
    }

    public void addTransferStationPrev(Station s){
        transferList.add(s);
        s.addPrev(this);
    }

    public void addTransferStationNext(Station s){
        transferList.add(s);
        s.addNext(this);
    }

    public String toString(){
        String start = "TRANSFERSTATION " + name + ": " + lineColor + ", in service: " + inService + ", previous station: " + previous + ", next station: " + next + "\n\tTransfers: \n";
        if (transferList != null){
            for (int i = 0; i < transferList.size(); i++){
                start = start + transferList.get(i).toString() + "\n";
            }
        }
        return start;
    }







)
