T = int(input())

for t in range(T):
    n, m = map(int, input().split())
    lst = []
    for _ in range(n):
        nums = list(map(int, input().split()))
        lst.append(nums)

    maxVal = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
           # print(i, j)
            summation = 0
            for k in range(m):
                for l in range(m):
                    summation += lst[i+k][j+l]

            if maxVal <= summation:
                maxVal = summation
    print(f"#{t+1} {maxVal}")

# 5-2+1 n-m+1
#00 01 10 11