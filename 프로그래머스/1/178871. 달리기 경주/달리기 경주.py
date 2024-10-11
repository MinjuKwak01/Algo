def solution(players, callings):
    
    result = {}
    rev_result = {i:players for i, players in enumerate(players) }
    for i, player in enumerate(players):
        result[player] = i
    
    for e in callings:
        idx = result[e] #불린사람 등수
        result[e] -=1
        result[players[idx -1]] +=1
        players[idx-1], players[idx] = players[idx], players[idx-1]
        
    
    return players