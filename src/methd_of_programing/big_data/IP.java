package methd_of_programing.big_data;

/**
 * Created by kentorvalds on 2018/1/18.
 */
public class IP implements Comparable<IP>{
    public String ip;
    public int nums;
    public IP(){}
    public IP(String ip,int nums){
            this.ip = ip;
            this.nums = nums;
    }
    @Override
    public int compareTo(IP o) {
        if (this.ip.equals(o.ip)) {
            o.nums=this.nums+o.nums;
        }else {
            if (this.nums > o.nums) {
                return -1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
