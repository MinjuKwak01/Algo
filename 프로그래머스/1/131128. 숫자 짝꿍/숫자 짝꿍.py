def solution(X, Y):
    count_X = {str(i): 0 for i in range(10)}
    count_Y = {str(i): 0 for i in range(10)}
    
    # X와 Y의 각 숫자 출현 횟수 계산
    for digit in X:
        count_X[digit] += 1
    for digit in Y:
        count_Y[digit] += 1
    
    # 공통으로 나타나는 숫자를 찾아 결과 문자열 생성
    result = []
    for digit in range(9, -1, -1):  # 9부터 0까지 역순으로
        digit_str = str(digit)
        common_count = min(count_X[digit_str], count_Y[digit_str])
        result.extend([digit_str] * common_count)
    
    # 결과 처리
    if not result:
        return "-1"
    if result[0] == "0":
        return "0"
    return "".join(result)