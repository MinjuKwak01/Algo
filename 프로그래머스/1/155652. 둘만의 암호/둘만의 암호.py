def solution(s, skip, index):
    answer = ''
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    valid_chars = ''.join([c for c in alphabet if c not in skip])
    
    print(valid_chars)
    
    for char in s:
        현재인덱스 = valid_chars.index(char)
        새로운인덱스 = (현재인덱스 + index) % len(valid_chars)
        answer += valid_chars[새로운인덱스]
    
    

    return answer