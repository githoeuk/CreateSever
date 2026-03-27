import java.util.Scanner;

public class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        // 희망 출근 시간 - schedules
        // 실제 출근 시간 - timelog
        int result = 0;



        int answer = result;
        return answer;
    } // end of solution


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("인원 수 : ");
        int n = sc.nextInt();

        int[] schedules = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("희망 시간 : ");
            int hTime = sc.nextInt();
            schedules[i] = (((hTime / 100) * 100) + (hTime%100)) ;
            for (int j = 0; j < 7; j++) {
                int startday = sc.nextInt();
                int[][]timelogs = new int[n][startday];
                System.out.print("실제 출근 시간 ");
                int rTime = sc.nextInt();
                timelogs[i][j] = (((rTime / 100) * 100) + (rTime%100)) + 10 ;
            }
        }






    } // end of main

}
