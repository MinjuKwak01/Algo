strr = input()

result = ''

for i in strr:
    if i >= 'A' and i <= 'Z':
        asci = ord(i) + 13
        if chr(asci) > 'Z':
            asci -= 26
        result += chr(asci)
    elif i >= 'a' and i <= 'z':
        asci = ord(i) + 13
        if chr(asci) > 'z':
            asci -= 26
        result += chr(asci)
    else:
        result += i

print(result)