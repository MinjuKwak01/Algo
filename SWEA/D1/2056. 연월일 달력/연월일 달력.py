T = int(input())
for test_case in range(1, T + 1):
    #받아온 라인을 문자열로 변환
    strLine = str(input())
    #연,월,일 을 각각의 변수에 담음
    yy = strLine[0:4]
    mm = strLine[4:6]
    dd = strLine[6:8]

    #31,30,28까지인 달별로 분류
    d31 = [1, 3, 5, 7, 8, 10, 12]
    d30 = [4, 6, 9, 11]
    d28 = [2]

    #최대 가능 일을 설정
    maxDay = 0
    if int(mm) in d31:
        maxDay = 31
    elif int(mm) in d30:
        maxDay = 30
    elif int(mm) in d28:
        maxDay = 28
    else: #0월이거나 13월이상인 달인 경우
        maxDay = -1

    if int(dd) <= 0: #day가 0보다 같거나 작을경우
        print(f"#{test_case} -1")
    elif maxDay < int(dd): # 해당 달이 가질수 있는 day보다 값이 클 경우
        print(f"#{test_case} -1")
    else: #정상적인 날짜일경우
        print(f"#{test_case} {yy}/{mm}/{dd}")