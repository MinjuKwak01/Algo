T = int(input())

for t in range(T):
    num = int(input())

    dict = {}
    lst = []
    for _ in range(num):
        a,b = map(str, input().split())
        for _ in range(int(b)):
            lst.append(a)

   # print(lst)
   # print(round(len(lst)/10))
    print(f"#{t+1}")
    for i in range((len(lst)//10)+1):
        for j in range(i* 10, (i+1)*10):
            if j == len(lst):
                break
            print(lst[j], end="")
        print()


