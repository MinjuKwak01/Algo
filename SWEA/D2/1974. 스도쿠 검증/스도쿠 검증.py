T = int(input())

for t in range(1,T+1):
    lst = []
    for _ in range(9):
        line = list(map(int, input().split()))
        lst.append(line)

    # 가로
    # [0,1,2] [3,4,5] [6,7,8]
    flag = 1
    for i in range(9):
        dict = {}
        for k in range(1, 10):
            dict[k] = 0
        for j in range(9):
            dict[lst[i][j]] = 1
        벨류lst = dict.values()
        if 0 in 벨류lst:
            flag = 0

    # 세로
    # [0,1,2] [3,4,5] [6,7,8]
    for i in range(9):
        dict = {}
        for k in range(1, 10):
            dict[k] = 0
        for j in range(9):
            dict[lst[j][i]] = 1
        벨류lst = dict.values()
        if 0 in 벨류lst:
            flag = 0


    for block_row in range(0, 9, 3):  # 0, 3, 6
        for block_col in range(0, 9, 3):  # 0, 3, 6
            # 현재 3x3 블록의 숫자들을 저장
            current_block = []
            for i in range(3):
                for j in range(3):
                    num = lst[block_row + i][block_col + j]
                    current_block.append(num)

            if len(set(current_block)) != 9:
                flag = 0

    print(f"#{t} {flag}")