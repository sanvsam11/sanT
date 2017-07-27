package Amazon;

/**
 * Created by SanthoshVarathan on 22/07/17.
 */
public class ClockAngle {
    public int getAngleBetweenHands(String time){
        String timeArray[] = time.split(":");

        int minutes = Integer.parseInt(timeArray[0])*60 + Integer.parseInt(timeArray[1]);
        int hourAngle = minutes/2;hourAngle = hourAngle % 360;
        int minuteAngle = minutes*6;minuteAngle = minuteAngle % 360;
        int totalAngle = Math.abs(hourAngle - minuteAngle);
        //int totalAngle = Math.abs((Integer.parseInt(timeArray[0])%12)*30 - ((Integer.parseInt(timeArray[1])/5)%12)*30);
        return totalAngle>180?360 - totalAngle:totalAngle;
    }
    public static void main(String ar[]){
        String time = "3:30";
        System.out.println("Angle:"+new ClockAngle().getAngleBetweenHands(time));
    }
}
