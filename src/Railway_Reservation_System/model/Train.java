package Railway_Reservation_System.model;

public class Train {
    String Source;
    String Destination;
    int TrainNo;
    String TrainName;
    public Train(String Source, String Destination, int trainNo, String TrainName){
        this.Source=Source;
        this.Destination=Destination;
        this.TrainName=TrainName;
        this.TrainNo=trainNo;
    }

    public String getDestination() {
        return Destination;
    }

    public int getTrainNo() {
        return TrainNo;
    }

    public String getTrainName() {
        return TrainName;
    }

    public String getSource() {
        return Source;
    }
}
