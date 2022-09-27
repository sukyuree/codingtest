import java.util.*;
import java.io.*;

public class PrinterQueue {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        
        for(int i = 0; i < N; i++){
            int count = 0;
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<Printer> q = new LinkedList<>();

            for(int j = 0; j < size; j++){
                Printer printer = new Printer();
                printer.order = j;
                printer.value = Integer.parseInt(st.nextToken());
                q.offer(printer);
            }
            int indexValue = ((LinkedList<Printer>) q).get(index).value;
            if(size != 1){
                boolean flag = true;
                while(flag){
                    int max = 0;
                    for(int k = 0; k < q.size(); k++){
                        if(((LinkedList<Printer>) q).get(k).value>max){
                            max = ((LinkedList<Printer>) q).get(k).value;
                        }
                    }
                    if(max == indexValue){
                        while(true){
                            if(q.element().order!=index&&q.element().value==max){
                                count++;
                                q.poll();
                            }
                            else if(q.element().order!=index&&q.element().value!=max){
                                Printer temp = q.poll();
                                q.offer(temp);
                            }
                            else if(q.element().order==index&&q.element().value==max){
                                count++;
                                break;
                            }
                        }
                        break;
                    }
                    while(true){
                        if(q.element().value < max){
                            Printer temp = q.poll();
                            q.offer(temp);
                        }
                        else if(q.element().value == max){
                            q.poll();
                            count++;
                            break;
                        }
                    }
                }
                sb.append(count).append("\n");
            }
            else{
                count = 1;
                sb.append(count).append("\n");
            }
        }
        System.out.print(sb);
    } 
    
}

class Printer{
    int order;
    int value;
}