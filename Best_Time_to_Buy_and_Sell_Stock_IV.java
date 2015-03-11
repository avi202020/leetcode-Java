买卖股票
乍看之下，想到了DP。今天好多DP题啊。
dp[j]代表到第j天还有已经交易i次的最大利润。
dp[j]=max(dp[i-1][k]+a[j]-a[k]) foreach1<=k&&k<i

但这样的复杂度是n*m*m的，数据范围是1000的，肯定拿不到满分。
再观查式子dp[i-1][k]+a[j]-a[k]如果改写成
dp[i-1][k]-a[k]+a[j]
这样的情况就不一样的。
前面一部分dp[i-1][k]-a[k]和j是无关的
也就是说到dp[j]的时候，只要知道前面dp[i-1][k]-a[k]的最大值即可。
所以我们维护dp[i-1][k]-a[k]最大值。
这样复杂度就可以降掉一维。满足题目要求 。
开码。


int main()
{  
       int T;
       int n,m;
       int last=0;
       int i,j,k;
      
       while(scanf("%d%d",&n,&m)!=EOF)
       {
              for(i=1;i<=n;i++)
              {
                     scanf("%d",&a[i]);
              }
              for(i=0;i<=m;i++)
              {
                     for(j=1;j<=n;j++)
                     {
                            dp[i][j]=0;
                     }
              }
              int ans=0;
              dp[0][1]=0;
              int tmp=-INF;
              for(i=1;i<=m;i++)
              {
                     dp[i][1]=0;
                     tmp=dp[i-1][1]-a[1];
                     for(j=2;j<=n;j++)
                     {
                            dp[i][j]=dp[i][j-1];
                            if(tmp+a[j]>dp[i][j])
                                    dp[i][j]=tmp+a[j];
                            if(dp[i][j]>ans)
                                    ans=dp[i][j];

                            if(dp[i-1][j]-a[j]>tmp)
                                    tmp=dp[i-1][j]-a[j];
                     }
              }
              printf("%d\n",ans);
       }
    return 0;
}
