import java.util.*;
import java.io.*;

public class AbsoluteValueHeap{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<AbsoluteValueAndOwnValue> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if(number == 0){
                if(list.isEmpty()) System.out.println("0");
                else{
                    //뺄 때 정렬하지 말고
                    Collections.sort(list);
                    System.out.println(list.get(0).OwnValue);
                    list.remove(0);
                }
            }
            else{
                //넣을 때 정렬하기?
                AbsoluteValueAndOwnValue obj = new AbsoluteValueAndOwnValue();
                obj.OwnValue = number;
                obj.AbsoluteValue = (int)(obj.OwnValue*obj.OwnValue/Math.sqrt(obj.OwnValue));
                list.add(obj);
            }
        }
    }
}

class AbsoluteValueAndOwnValue implements Comparable<AbsoluteValueAndOwnValue>{
    int AbsoluteValue;
    int OwnValue;

    @Override
    public int compareTo(AbsoluteValueAndOwnValue obj) {
        if(obj.AbsoluteValue < this.AbsoluteValue) return 1;
        else if (obj.AbsoluteValue > this.AbsoluteValue) return -1;
        else{
            if(obj.OwnValue < this.OwnValue) return 1;
            else return -1;
        }
    }
}