/**
 * Created by BlackSpheres on 11/7/2015.
 */
public class Clock implements Runnable {
    public boolean isRun=false;
    public int time;

    public String getTime(){
        String minutes=String.format("%02d",(time/1000)/60);
        String seconds=String.format("%02d",(time/1000)%60);
        String mill=String.format("%02d",(time/10)%100);
        return minutes+":"+seconds+":"+mill;
    }
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        while (true){
            if(isRun){
                time++;
                try{
                    Thread.sleep(1);
                }
                catch (Exception e){

                }

            }
        }
    }
}
