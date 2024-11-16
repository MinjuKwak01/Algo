T = int(input())
for t in range(T):
    n = int(input())
    lst = list(map(int, input().split()))
    lst.sort()

    print(f"#{t+1}", *lst)