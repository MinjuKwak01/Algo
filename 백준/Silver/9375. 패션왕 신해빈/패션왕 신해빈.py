import sys

input = sys.stdin.readline

T = int(input())

for _ in range(T):
    N = int(input())
    dict = {}
    for i in range(N):
        cloth, category = map(str, input().split())
        if category in dict:
            dict[category] +=1
        else:
            dict[category] = 1

    #print(dict)
    cnt = 1
    for key in dict:
      #  print(key)
        cnt = cnt * (dict[key] + 1)
        # headgear 2개, eyewear 1개라면
        # 총 경우의 수는 (3 x 2) -1 개

    print(cnt - 1)