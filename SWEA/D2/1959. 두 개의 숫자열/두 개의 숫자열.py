T = int(input())

for t in range(T):
    n, m = map(int, input().split())
    nlst = list(map(int, input().split()))
    mlst = list(map(int, input().split()))
    if n <= m:
        더한값lst = []
        for i in range(m-n+1):
            res = 0
            for j in range(i, n+i): #0~3
              #  print(j)
                res += nlst[j-i] * mlst[j]
            더한값lst.append(res)

        maxValue = max(더한값lst)
      #  print(더한값lst)
        print(f"#{t+1} {maxValue}")
    if n > m:
        더한값lst = []
        for i in range(n-m+1):
            res = 0
            for j in range(i, m + i):  # 0~3
            #    print(j)
                res += nlst[j] * mlst[j-i]
            더한값lst.append(res)

        maxValue = max(더한값lst)
        print(f"#{t+1} {maxValue}")


