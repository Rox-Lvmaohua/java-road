package algorithm;

import java.util.Scanner;

public class TotalPackDP {


    static int N=1010;

    static Scanner sc=new Scanner(System.in);
    static int n=sc.nextInt();
    static int m=sc.nextInt();

    static int v[]=new int[N];              //体积
    static int w[]=new int[N];              //价值

    static int f[][]=new int[N][N];

    public static void main(String[] args) {

        for(int i=1;i<=n;i++) {

            v[i]=sc.nextInt();
            w[i]=sc.nextInt();
        }

        for(int i=1;i<=n;i++) {                  //针对当前的第i个物品
            for(int j=0;j<=m;j++) {              //枚举所消耗的体积
                for(int k=0;k*v[i]<=j;k++) {
                    f[i][j]=Math.max(f[i][j], f[i-1][j-k*v[i]]+w[i]*k);
                }
            }

        }

        System.out.println(f[n][m]);
    }

}
