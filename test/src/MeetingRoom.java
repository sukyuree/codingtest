import java.util.*;
import java.io.*;

public class MeetingRoom {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        List<meeting> meetinglist = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            meeting m = new meeting();
            m.start = Integer.parseInt(st.nextToken());
            m.end = Integer.parseInt(st.nextToken());
            meetinglist.add(m);
        }
        Collections.sort(meetinglist);
        int count = 1;
        int end = meetinglist.get(0).end;
        meetinglist.remove(0);
        for(int i = 0; i < N-1; i++){
            if(end <= meetinglist.get(i).start){
                end = meetinglist.get(i).end;
                count++;
            }
        }

        System.out.println(count);
    }
}

class meeting implements Comparable<meeting>{
    int start;
    int end;

    @Override
    public int compareTo(meeting m){
        if(this.end == m.end) return this.start - m.start;
        return this.end - m.end;
    }
}
