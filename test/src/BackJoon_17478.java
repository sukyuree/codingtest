import java.util.*;

class BackJoon_17478{
    static String init = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    static String firstLine = "\"재귀함수가 뭔가요?\"\n";
    static String secondLine = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    static String thirdLine = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    static String fourthLine = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    static String firstLineAtLast = "\"재귀함수가 뭔가요?\"\n";
    static String secondLineAtLast = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
    static String finalLine = "라고 답변하였지.\n";
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        
        sb.append(init);

        recursive(0);

        System.out.print(sb.toString());
    }

    public static void recursive(int m){
        if(n == m){
            for(int i = 1; i <= n; i++){
                sb.append("____");
            }
            sb.append(firstLineAtLast);
            for(int i = 1; i <= n; i++){
                sb.append("____");
            }
            sb.append(secondLineAtLast);
            for(int i = 1; i <= n; i++){
                sb.append("____");
            }
            sb.append(finalLine);
            return;
        }
        for(int i = 1; i <= m; i++){
            sb.append("____");
        }
        sb.append(firstLine);
        for(int i = 1; i <= m; i++){
            sb.append("____");
        }
        sb.append(secondLine);
        for(int i = 1; i <= m; i++){
            sb.append("____");
        }
        sb.append(thirdLine);
        for(int i = 1; i <= m; i++){
            sb.append("____");
        }
        sb.append(fourthLine);
        recursive(m+1);
        for(int i = 1; i <= m; i++){
            sb.append("____");
        }
        sb.append(finalLine);
        return;
    }
}