package Railway_Reservation_System.model;

public class Passenger {
        private String passengerName;
        private String passengerGender;
        private int passengerAge;
        private   long pnr;

        public Passenger(String passengerName,String passengerGender,int passengerAge,long pnr){
            this.passengerName=passengerName;
            this.passengerGender=passengerGender;
            this.passengerAge=passengerAge;
            this.pnr=pnr;
        }

    public int getPassengerAge() {
        return passengerAge;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public long getPnr() {
        return pnr;
    }
}
