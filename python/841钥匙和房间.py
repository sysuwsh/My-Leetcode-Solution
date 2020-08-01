from typing import List


# dfs递归的方式
class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = {0}

        def dfs(room_index, visited):
            visited.add(room_index)
            for key in rooms[room_index]:
                if key not in visited:
                    dfs(key, visited)

        dfs(0, visited)
        return len(visited) == len(rooms)


# dfs使用栈的方式
class Solution1:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = {0}
        stack = [0]
        while stack:
            room_index = stack.pop()
            for room in rooms[room_index]:
                if room not in visited:
                    visited.add(room)
                    stack.append(room)
        return len(visited) == len(rooms)


# bfs方式
class Solution2:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = {0}
        queue = [0]
        while queue:
            room_index = queue.pop(0)
            for room in rooms[room_index]:
                if room not in visited:
                    visited.add(room)
                    queue.append(room)
        return len(visited) == len(rooms)

s = Solution2()
roomList = [[1, 3], [3, 0, 1], [2], [0]]
roomList1 = [[1], [2], [3], []]
print(s.canVisitAllRooms(roomList))
print(s.canVisitAllRooms(roomList1))
