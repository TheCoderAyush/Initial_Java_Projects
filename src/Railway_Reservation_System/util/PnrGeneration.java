package Railway_Reservation_System.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class PnrGeneration {
    public static long pnr(){
       Random rn = new Random();
       long pnr = rn.nextLong(10000000,999999999);
       return pnr;

    }




}
