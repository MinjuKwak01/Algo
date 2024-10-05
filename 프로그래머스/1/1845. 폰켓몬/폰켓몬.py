def solution(nums):
    answer = 0
    cnt = len(nums) /2
    numsset = set(nums)
    nums = list(numsset)
    
    if cnt >= len(nums):
        answer = len(nums)
    else:
        answer = cnt
    return answer