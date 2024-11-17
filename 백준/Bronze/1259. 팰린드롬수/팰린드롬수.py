import sys
 
input = sys.stdin.readline
 
while True:
    x = input().rstrip()
    if x == '0':
        break
    else:
        cnt = 0
        l = len(x) // 2
        for i in range(l):
            if x[i] == x[-(i + 1)]: # 순차적으로 탐색
                cnt += 1
        if l == cnt:
            print('yes')
        else:
            print('no')