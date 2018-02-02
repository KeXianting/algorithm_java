package test.transient_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by kentorvalds on 2017/8/23.
 */
public class TransientDemo {

    public static void main(String[] args) {
        Logging logInfo = new Logging("MIKE", "MECHANICS");
        System.out.println(logInfo.toString());
        try {
            ObjectOutputStream o = new ObjectOutputStream(
                    new FileOutputStream("logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        } catch (Exception e) {//deal with exception}

            //To read the object back, we can write

            try {
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream("logInfo.out"));
                Logging logInfo1 = (Logging) in.readObject();
                System.out.println(logInfo1.toString());
            } catch (Exception e1) {//deal with exception}
                e1.printStackTrace();
            }


        }
    }
}
