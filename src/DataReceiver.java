import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DataReceiver {
    public static void main(String[] args) {
        new DataReceiver();
    }

    public DataReceiver() {
        DatagramSocket ds = null;

        try {
            ds = new DatagramSocket(2024);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, 1024);
            
            while(true){
                ds.receive(dp);
                String str = new String(dp.getData(), 0, dp.getLength());
                System.out.println(str);
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if(ds != null){
                ds.close();
            }
        }
    }
}
