
N = int(input())

from collections import deque
strr = deque()
for i in range(1,N+1):
    strr.append(i)

def func():
    if len(strr) == 1:
        return strr
    while True:
        # 버리는 카드
      #  print(strr)
        strr.popleft()
        if len(strr) == 1:
            break
        # 뒤로 보내는 카드
        num = strr.popleft()
        strr.append(num)
    return strr

result = func()
print(result.popleft())
