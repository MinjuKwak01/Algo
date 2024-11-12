from collections import deque

T = int(input())

for _ in range(T):
    명령어 = list(str(input()))
    n = int(input())
    리스트 = str(input())

    # 빈 리스트일 경우 처리
    if 리스트 == "[]":
        dq = deque()
    else:
        리스트 = 리스트[1:len(리스트) - 1]
        lst = 리스트.split(",")
        dq = deque(lst)

    flag = 0
    reverseFlag = 0
    for i in range(len(명령어)):
        if 명령어[i] == "R":
            reverseFlag += 1
        elif 명령어[i] == "D":
            if len(dq) == 0:  # 비어 있는 deque에서 pop/popleft 시도 시 에러 방지
                flag = 1
                break
            if reverseFlag % 2 != 0:
                dq.pop()
            else:
                dq.popleft()

    if reverseFlag % 2 != 0 and flag == 0:
        dq.reverse()

    # 결과 출력
    if flag == 0:
        print(f"[{','.join(dq)}]")
    else:
        print("error")
