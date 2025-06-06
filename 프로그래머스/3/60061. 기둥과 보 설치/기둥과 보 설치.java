import java.util.*;

class Solution {

    public int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> structure = new ArrayList<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int command = frame[3];

            if (command == 1) { // 설치
                structure.add(new int[]{x, y, type});
                if (!isValid(structure)) {
                    structure.removeIf(e -> Arrays.equals(e, new int[]{x, y, type}));
                }
            } else { // 삭제
                structure.removeIf(e -> Arrays.equals(e, new int[]{x, y, type}));
                if (!isValid(structure)) {
                    structure.add(new int[]{x, y, type}); // 삭제 취소
                }
            }
        }

        // 정렬 조건: x 오름차순 → y 오름차순 → 구조물 종류 오름차순
        structure.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // 리스트를 배열로 변환
        int[][] answer = new int[structure.size()][3];
        for (int i = 0; i < structure.size(); i++) {
            answer[i] = structure.get(i);
        }

        return answer;
    }

    private boolean isValid(List<int[]> structure) {
        for (int[] frame : structure) {
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];

            if (type == 0) { // 기둥
                if (
                    y == 0 || // 바닥
                    contains(structure, x, y - 1, 0) || // 다른 기둥 위
                    contains(structure, x - 1, y, 1) || // 왼쪽 보 위
                    contains(structure, x, y, 1)        // 오른쪽 보 위
                ) continue;
                return false;
            } else { // 보
                if (
                    contains(structure, x, y - 1, 0) || // 왼쪽 아래 기둥
                    contains(structure, x + 1, y - 1, 0) || // 오른쪽 아래 기둥
                    (contains(structure, x - 1, y, 1) && contains(structure, x + 1, y, 1)) // 양쪽 보와 연결
                ) continue;
                return false;
            }
        }
        return true;
    }

    private boolean contains(List<int[]> structure, int x, int y, int type) {
        for (int[] element : structure) {
            if (element[0] == x && element[1] == y && element[2] == type) {
                return true;
            }
        }
        return false;
    }
}
