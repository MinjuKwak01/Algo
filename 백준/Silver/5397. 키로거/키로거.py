from collections import deque
T = int(input())
for _ in range(T):
    문자열 = str(input())
    lst = list(문자열)
    left = deque()  # 커서의 왼쪽 부분
    right = deque()  # 커서의 오른쪽 부분
    for char in lst:
        if char == "<":
            if left:
                right.appendleft(left.pop())  # 왼쪽에서 오른쪽으로 이동
        elif char == ">":
            if right:
                left.append(right.popleft())  # 오른쪽에서 왼쪽으로 이동
        elif char == "-":
            if left:
                left.pop()  # 왼쪽에서 삭제
        else:
            left.append(char)  # 커서 왼쪽에 삽입

    # 최종 문자열 생성
    result = ''.join(left) + ''.join(right)
    print(result)
