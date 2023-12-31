# 알고리즘의 복잡도

- 알고리즘이 복잡한 정도 (Complexity)는 크게 두 가지로 나누어 볼 수 있다.
    - 공간 복잡도 vs. 시간 복잡도 -> 일반적으로 두 복잡도는 Trade-off 관계가 있다.
- 알고리즘의 Complexity가 높을 수록 알고리즘을 구동하는 데에 더 많은 Cost가 소비된다.

## 공간 복잡도

- Space Complexity
- 알고리즘이 동작하기 위해 필요한 공간(메모리)의 크기
- 많은 경우, 연산의 중간 결과를 저장하기 위해 메모리를 소비한다.
    - 중간 결과를 저장하여 중복 연산을 줄일 수 있다.

## 시간 복잡도

- Time Complexity (계산 복잡도; Computational Complexity)
- 알고리즘이 동작하는 데에 걸리는 시간 또는 연산의 횟수

## 복잡도의 계산 방법

- 반복문과 조건문을 고려하여 분기별로 실행 횟수를 분석을 통해 알아낼 수 있다.

``` java
// array의 길이 = N
int[] array = {1, 6, 2, 5, 4, 2, 5, 2, 3, 6, 3};

int sum = 0;
// 배열의 길이에 비례해서 반복하는 for문. 복잡도는 N
for (int i = 0; i < array.length; i++) { 
    sum += array[i];
}
```

``` java
// array의 길이 = N, array2의 길이 = M
int[] array = {1, 6, 2, 5, 4, 2, 5, 2, 3, 6, 3};
int[] array2 = {4, 2, 1, 6, 7, 4, 3, 6};

int sum = 0;
// 배열의 길이에 비례해서 반복하는 for문. 복잡도는 N
for (int i = 0; i < array.length; i++) { 
    sum += array[i];
}

// 두 번째 반복, 복잡도는 M
for (int i = 0; i < array2.length; i++) { 
    sum += array2[i];
}

// 두 for문의 복잡도를 합친 전체 복잡도는 N+M
```

``` java
// 2차원 array의 길이 = N*M
int[] array2D = {{1, 6, 2, 5, 4},
               {2, 5, 2, 3, 6},
               {3, 1, 2, 4, 5}};

int sum = 0;
// 이중 for문, M번 반복이 N번 반복되므로 복잡도는 N*M
for (int i = 0; i < array2D.length; i++) { 
    for (int j = 0; j < array2D[i].length; j++) { 
        sum += array2D[i][j];
    }
}
```

## 복잡도의 종류

- 알고리즘 동작 상황에 따른 구분
    - **최악의 경우**
    - '최선의 경우'
    - '평균적인 경우'
- 일반적으로 **최악의 경우** 에 대해 알고리즘 복잡도를 정의한다.
    - ex) 리스트에서의 개체 삽입

![리스트 개체 삽입](img/section4/1.png)

## Asymptotic Notations

![리스트 개체 삽입](img/section4/2.png)

- 점진적(asymptotic) 표기 방법
- 알고리즘에 입력되는 자료의 개수($n$)가 충분히 많다고 가정
    - 입력 자료의 개수가 작은 경우, 비교하는 의미가 크게 없기 때문
- **성능 평가에 공평한 비교** 를 하기 위한 성능 분석 기준으로 사용
    - 동작 시스템, 데이터 크기 등을 배제하고 성능을 비교하기 위해 필요
- 상한, 하한, 상한과 하한의 교집합으로 정의

    !!! note

        점진적 표기 방법은 엄밀한 정의대로 쓰기 보다는 관례적으로 Big-O 표기법을 주로 사용한다.


### Big-O Notation

![리스트 개체 삽입](img/section4/3.png)

- 복잡도 순위
    - $O(1) \subset O(logn) \subset O(n) \subset O(nlogn) \subset O(n^2) \subset O(2^n) \subset O(n!)$
        - 상수, 로그, 선형, 선형로그, 다항식(제곱), 지수, 팩토리얼
- $f(n)$ 의 Big-O Notation 정의:
    - $O(g(n)) = \{ f(n)|0 \le f(n) \le c \cdot g(n)\space \text{for all}\space \space n \ge n_0 > 0 \}\space \space \text{for} \space \exists c > 0.$
- 예시
    - $3(n+1)^2 \in O(n^2)$
    - $n^{1.998} \in O(n^2)$
    - $n^2 + n\log n + 3 \in O(n^2)$
    - $n^2 \in O(n^2)$
    - $n \in O(n^2)$

### Big-Omega  Notation

![리스트 개체 삽입](img/section4/4.png)

- $\text{Ω}(n)$,  $\text{Ω}(n^2)$, $\text{Ω}(n\log n)$ ...
- $f(n)$ 의 Big-Omega Notation 정의:
    - $\text{Ω}(g(n)) = \{ f(n)|0 \le c \cdot g(n) \le f(n) \space \space  \text{for all} \space n \ge n_0 > 0 \}\space \space \text{for} \space \space \exists c > 0.$
- 예시
    - $3(n+1)^2 \in \text{Ω}(n^2)$
    - $n^{2.002} \in \text{Ω}(n^2)$
    - $n^2 + NlogN + 3 \in \text{Ω}(n^2)$
    - $n^2 \in \text{Ω}(n^2)$
    - $n^3 \in \text{Ω}(n^2)$

### Big-Theta Notation

![리스트 개체 삽입](img/section4/5.png)

- $\text{Θ}(n)$,  $\text{Θ}(n^2)$, $\text{Θ}(n\log n)$ ...
- $f(n)$ 의 Big-Theta Notation 정의:
    - $\text{Θ}(g(n)) = \{ f(n)|0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n)\space\space \text{for all}\space n \ge n_0 > 0 \}\space \space \text{for}\space \space \exists c_1 > 0,\space\exists c_2 > 0.$
- 예시
    - $3(n+1)^2 \in \text{Θ}(n^2)$
    - $n^2 + n\log n + 3 \in \text{Θ}(n^2)$
    - $n^2 \in \text{Θ}(n^2)$
    - $n^3 \in \text{Θ}(n^3)$
