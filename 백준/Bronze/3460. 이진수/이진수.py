N:int = int(input())

for i in range(N):
    num:int = int(input())
    lst: list = []
    mok =0
    namuji =0
    while num !=0:
        mok = num//2
        namuji = num%2
        lst.append(namuji)
        num=mok
    for i in range(len(lst)):
        if lst[i] ==1:
            print(i, end=' ')
