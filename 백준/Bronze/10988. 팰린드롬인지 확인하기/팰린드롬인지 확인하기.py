strr = input()

def palindrome():
    start = 0
    end = len(strr) - 1

    while start < end:
        if strr[start] == strr[end]:
            start += 1
            end -= 1
        else:
            return 0

    return 1

print(palindrome())
