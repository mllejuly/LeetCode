def dirReduc(arr):
	pairs = {'NORTH': 'SOUTH', 'EAST': 'WEST', 'SOUTH': 'NORTH', 'WEST': 'EAST'}
	i = 0
	while i < (len(arr) - 1):
		if arr[i+1] == pairs[arr[i]]:
			arr.pop(i)
			arr.pop(i)
			i = 0
		else:
			i += 1
	return(arr)
