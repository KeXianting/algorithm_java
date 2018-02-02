package test.transient_test;

import java.util.Date;

/**
 * Created by kentorvalds on 2017/8/23.
 */
public class Logging implements java.io.Serializable
{
    private Date loggingDate = new Date();
    private String uid;

    //该属性不进行序列化
    private transient String pwd;

    Logging(String user, String password)
    {
        uid = user;
        pwd = password;
    }
    public String toString()
    {
        String password=null;
        if(pwd == null)
        {
            password = "NOT SET";
        }
        else
        {
            password = pwd;
        }
        return "logon info: \n   " + "user: " + uid +
                "\n   logging date : " + loggingDate.toString() +
                "\n   password: " + password;
    }
}

