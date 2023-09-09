def look_and_say(data='1', maxlen=5):
    seq = data
    result = []
    
    for i in range(maxlen):
        count = 1
        next = ""
        
        for i in range(len(seq) - 1):
            if seq[i] != seq[i + 1]:
                next += str(count) + seq[i]
                count = 1
            else:
                count += 1

        seq = next + str(count) + seq[-1]
        result += [seq]

    return result
