T = int(input())

for _ in range(T):
    N = int(input())
    lst = list(map(int, input().split()))

    lst.reverse()
    maximum = 0
    sum = 0
    for i in range(N):
        if maximum < lst[i]:
            maximum = lst[i]
            continue
        sum += maximum - lst[i]

    print(sum)
    # 아래 코드는 시간초과 나는 코드
    # index = 0
    # price = 0
    # while True:
    #     if index >= N:
    #         break
    #
    #     maximum = 0
    #     oldindex = index
    #
    #     for i in range(index, len(lst)):
    #         if maximum < lst[i]:
    #             maximum = lst[i]
    #             index = i
    #
    #     for i in range(oldindex, index+1):
    #         price += maximum - lst[i]
    #     index +=1
    #
    # print(price)
