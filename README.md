# Java 알고리즘 학습 기록

SSAFY에서 작성한 Java 코드를 **문제 출처별로 분류**했습니다. 원본 소스의 로직과 클래스명은 유지했고, IDE 설정과 컴파일 결과물은 제외했습니다.

> 분류 근거: `p숫자` 패키지의 문제 번호, 원본 프로젝트 폴더명, 코드의 입력·풀이 내용을 함께 확인했습니다. Codetree 폴더에는 문제 번호가 없어서 제목은 코드 동작을 바탕으로 붙였습니다. 온라인 채점 통과 여부는 확인되지 않았습니다.

## 백준 (BOJ)

| 문제 | 코드 | 핵심 개념 |
| --- | --- | --- |
| [15686 치킨 배달](https://www.acmicpc.net/problem/15686) | [Solution.java](BOJ/p15686/Solution.java) | 조합, 거리 합 최솟값 |
| [1600 말이 되고픈 원숭이](https://www.acmicpc.net/problem/1600) | [bfsMain.java](BOJ/p1600/bfsMain.java), [Solution.java](BOJ/p1600/Solution.java) | 3차원 방문 배열 BFS, DFS 연습 버전 |
| [17281 ⚾](https://www.acmicpc.net/problem/17281) | [Main.java](BOJ/p17281/Main.java) | 순열, 야구 시뮬레이션 |
| [17471 게리맨더링](https://www.acmicpc.net/problem/17471) | [Solution.java](BOJ/p17471/Solution.java) | 부분집합, 구역 연결성 BFS |
| [2447 별 찍기 - 10](https://www.acmicpc.net/problem/2447) | [Solution.java](BOJ/p2447/Solution.java) | 분할 정복, 재귀 |
| [2636 치즈](https://www.acmicpc.net/problem/2636) | [Solution.java](BOJ/p2636/Solution.java) | BFS, 시간별 상태 변화 |
| [2667 단지번호붙이기](https://www.acmicpc.net/problem/2667) | [Solution.java](BOJ/p2667/Solution.java) | BFS, 연결 요소 |
| [3109 빵집](https://www.acmicpc.net/problem/3109) | [Solution.java](BOJ/p3109/Solution.java) | 탐욕적 DFS, 경로 배치 |
| [4485 녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485) | [Main.java](BOJ/p4485/Main.java) | 다익스트라, 격자 최단 경로 |
| [5427 불](https://www.acmicpc.net/problem/5427) | [Main.java](BOJ/p5427/Main.java) | 불 확산과 탈출 BFS |

## SWEA

| 문제 | 코드 | 핵심 개념 |
| --- | --- | --- |
| 8382 방향 전환 | [BFS 풀이](SWEA/p8382/Solution.java), [수학 풀이](SWEA/p8382/SolutionMath.java) | 이동 방향의 교대, 거리 계산 |
| 1767 프로세서 연결하기 | [Solution.java](SWEA/p1767/Solution.java) | 백트래킹, 우선순위 최적화 |

## Codetree

원본 폴더에 문제 번호가 없어 **폴더명과 코드 동작으로 임시 제목**을 붙였습니다. 정확한 문제 URL은 특정하지 않았습니다.

| 임시 제목 | 코드 | 핵심 개념 |
| --- | --- | --- |
| 직사각형 나선형 채우기 | [jung/Solution.java](Codetree/jung/Solution.java) | 격자, 방향 전환 |
| 정사각형 나선형 채우기 | [jung2/Solution.java](Codetree/jung2/Solution.java) | 격자, 나선 순회 |
| 레이저와 거울 | [lazerToMirror2/Solution.java](Codetree/lazerToMirror2/Solution.java) | 반사, 방향 시뮬레이션 |
| 격자에서 편안한 상태 | [relaxedOnTheGrid/Solution.java](Codetree/relaxedOnTheGrid/Solution.java) | 인접 칸 탐색, 시뮬레이션 |
| 원점으로 돌아오기 | [returning/Solution.java](Codetree/returning/Solution.java) | 방향 명령, 좌표 시뮬레이션 |

## Teacher: 수업 개념 코드

| 개념 | 코드 | 기억할 점 |
| --- | --- | --- |
| 순열 | [perm/Solution.java](Teacher/perm/Solution.java), [fPerm/Main.java](Teacher/fPerm/Main.java) | 순서가 중요; 방문 배열 또는 비트마스크 |
| 중복 조합 | [multiCombi/Main.java](Teacher/multiCombi/Main.java), [combi/Solution.java](Teacher/combi/Solution.java) | 다음 재귀에 `i`를 전달하면 같은 원소 재선택 가능 |
| 부분집합 | [subset/Solution.java](Teacher/subset/Solution.java), [fSubset/Solution.java](Teacher/fSubset/Solution.java) | 각 원소마다 선택/비선택, 총 `2^N`개 |
| 다음 순열 | [StdMain.java](Teacher/nextPerm/StdMain.java), [LastMain.java](Teacher/nextPerm/LastMain.java), [SudoMain.java](Teacher/nextPerm/SudoMain.java) | 뒤에서 pivot 찾기 → 교환 → 뒤쪽 뒤집기 |

`Teacher/combi/Solution.java`는 폴더명이 `combi`지만 코드에서는 다음 재귀를 `i + 1`이 아닌 `i`로 호출하므로 **일반 조합이 아니라 중복 조합**입니다. `SudoMain.java`는 단계별 연습 버전으로 보고, 다음 순열은 `StdMain.java`를 기준으로 읽으면 됩니다.

## 기타 연습 코드

- [JavaCode.java](Practice/JavaCode.java): 일타싸피 로컬 소켓 연동용 시작 코드
- [codingTest.java](Practice/codingTest/codingTest.java): 별도 코딩테스트 연습 코드

## 실행

패키지 이름을 유지했으므로 각 파일은 해당 플랫폼의 소스 루트에서 컴파일합니다. 전체 컴파일은 아래와 같이 가능합니다.

```powershell
$sources = Get-ChildItem BOJ,SWEA,Codetree,Teacher,Practice -Recurse -Filter *.java | ForEach-Object FullName
javac -encoding UTF-8 -d build $sources
```

`p1600`의 DFS 버전 등 연습 코드는 알고리즘 비교 자료로 보관했습니다. 전체 소스는 컴파일을 확인했으며, 각 온라인 저지의 정답 판정은 별도로 검증하지 않았습니다.
