def time_convert(t) :
    year, month, day = map(int, t.split('.'))
    return year * 12 * 28 + month * 28 + day #일수로 변환

def solution(today, terms, privacies):
    term_dict = dict()
    today = time_convert(today) #오늘 날짜 합 구하기
    answer = []    
    
    for term in terms : #약관종류, 유효시간
        name, period = term.split()
        term_dict[name] = int(period) * 28 # 달 -> 일수 로 변환 {A : 3}
    
    for idx, privacy in enumerate(privacies) : #개인정보 수집 일자
        start, name = privacy.split() #수집일자, 약관종류
        end = time_convert(start) + term_dict[name] #더한날짜
        if end <= today : #날짜가 지났다면
            answer.append(idx+1)    
    
    return answer
