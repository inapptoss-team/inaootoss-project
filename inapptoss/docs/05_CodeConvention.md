# 📘 Inapptoss 프로젝트 코드 컨벤션

> **목적:**
> 팀 내 개발 코드의 일관성을 유지하고, 유지보수성을 높이기 위해 코드 스타일, 네이밍, 구조 규칙을 정의한다.
> (대상: Android(Java/Kotlin), HTML/CSS/JS)

---

## 🧩 1. 기본 원칙

1. 가독성 > 압축성
   → “짧은 코드보다 명확한 코드가 더 낫다.”
2. 함수 하나는 **하나의 역할**만 수행한다.
3. 네이밍은 **역할을 명확히 드러내도록 작성**한다.
4. 상수화 가능한 값은 반드시 상수로 분리한다.

---

## ☕ 2. Java / Android Convention

### 🏷 클래스 및 파일 구조

| 구분    | 예시                                      | 규칙                              |
| ----- | --------------------------------------- | ------------------------------- |
| 클래스   | `GameManager`, `MapManager`             | **PascalCase** 사용               |
| 인터페이스 | `PuzzleEventListener`                   | `Listener`, `Callback` 등 접미사 사용 |
| 메서드   | `callPuzzle()`, `outPuzzle()`           | **camelCase**, 동사 시작            |
| 상수    | `MAX_STAGE_COUNT`, `DEFAULT_HINT_COUNT` | 전부 대문자, `_` 구분                  |
| 변수    | `currentStage`, `playerState`           | camelCase                       |
| 패키지   | `com.example.inapptoss.manager.game`    | 전부 소문자                          |

---

### 📂 디렉터리 구조 규칙

* **core/** : 게임 공통 로직
* **manager/** : 게임 내 주요 매니저 클래스
* **bridge/** : JS ↔ Android 연결 로직
* **data/** : 로컬 저장소 / 리포지토리 계층
* **ui/** : Activity, Fragment, Adapter 등 UI 관련

---

### ⚙️ 함수 규칙 예시

```java
// ✅ 좋음
public void callPuzzle(String puzzleId) {
    puzzleManager.loadPuzzle(puzzleId);
    uiManager.showPuzzleView();
}

// 🚫 나쁨
public void puzzleStart(String id) {
    load(id);
    show();
}
```

* 한 메서드에는 **하나의 명확한 동작**만 정의.
* “동사 + 명사” 형태로 동작을 명시.

---

### 💬 주석 규칙

```java
/**
 * 퍼즐 호출 함수
 * @param puzzleId 불러올 퍼즐의 ID
 */
public void callPuzzle(String puzzleId) { ... }
```

* 메서드 상단에 Javadoc 형식 주석 사용
* 구현 내부에서는 `//` 한 줄 주석 사용 (간결하게)

---

### 🧱 클래스 헤더 템플릿

```java
/**
 * GameManager
 * 게임 전반의 상태를 관리하는 매니저 클래스
 *
 * [책임]
 * - PlayerState, GameState 관리
 * - 퍼즐 / 맵 전환 제어
 *
 * [작성자] Ara
 * [최종 수정일] 2025-10-07
 */
public class GameManager { ... }
```

---

## 🌐 3. HTML / CSS / JS Convention

### 📄 HTML

* 들여쓰기 **2칸**
* 속성 순서: id → class → data-* → 기타
* id는 camelCase, class는 kebab-case
* 역할 구분 주석 필수

```html
<!-- ✅ GOOD -->
<div id="puzzleUi" class="popup-window" data-type="puzzle"></div>

<!-- 🚫 BAD -->
<div class="PopupWindow" id="PUZZLE_UI"></div>
```

---

### 🎨 CSS

| 항목   | 규칙                                  |
| ---- | ----------------------------------- |
| 클래스명 | `kebab-case`                        |
| 변수   | `--main-bg-color`, `--accent-color` |
| 단위   | px → 정밀 위치, % → 반응형                 |
| 중첩   | 3단계 이상 금지                           |
| 파일   | 화면 단위(`game.css`, `puzzle.css`)로 분리 |

```css
/* ✅ GOOD */
#game-container {
  position: relative;
  width: 100vw;
  height: 100vh;
}
```

---

### ⚙️ JavaScript

| 항목 | 규칙                                            |
| -- | --------------------------------------------- |
| 함수 | camelCase                                     |
| 상수 | 대문자 + `_`                                     |
| 객체 | PascalCase (클래스), camelCase (인스턴스)            |
| 파일 | 기능 단위 (`interaction.js`, `puzzle-manager.js`) |
| 주석 | `//` 단일 주석, `/** ... */` 블록 주석                |

```js
// ✅ GOOD
function openPuzzle(puzzleId) {
  const puzzleFrame = document.getElementById('puzzle-ui');
  puzzleFrame.src = `puzzles/${puzzleId}.html`;
}
```

---

## 🧰 4. 파일명 규칙 요약

| 타입         | 예시                                       | 규칙         |
| ---------- | ---------------------------------------- | ---------- |
| Activity   | `MainActivity.java`                      | PascalCase |
| Manager    | `GameManager.java`                       | PascalCase |
| Script     | `dialog_script.json`                     | snake_case |
| Resource   | `room_bg.png`, `door_click.wav`          | snake_case |
| Layout XML | `activity_main.xml`, `fragment_game.xml` | snake_case |

---

## 🧩 5. 커밋 규칙 (Git)

| 타입          | 예시                               | 설명       |
| ----------- | -------------------------------- | -------- |
| `feat:`     | `feat: 퍼즐 호출 기능 추가`              | 새로운 기능   |
| `fix:`      | `fix: MapManager null 참조 수정`     | 버그 수정    |
| `refactor:` | `refactor: PlayerManager 구조 단순화` | 코드 구조 변경 |
| `docs:`     | `docs: 세부설계 문서 수정`               | 문서 변경    |
| `style:`    | `style: 코드 포맷팅 / 네이밍 수정`         | 코드 스타일   |

---

## 🧾 6. PR / 리뷰 원칙

1. PR은 한 기능 단위로 작게 끊을 것
2. PR 제목은 `[feat]`, `[fix]` 등 태그 포함
3. 리뷰어는 최소 1명 이상 승인 후 머지
4. 주석 및 코드 컨벤션 위반 시 요청 없이 수정 가능

---

## 🧩 7. 예시 커밋 흐름

```
feat: PuzzleManager 기능 구현  
fix: ResourceManager에서 JSON 불러오기 오류 수정  
style: GameManager 네이밍 컨벤션 적용  
docs: 코드 컨벤션 문서 추가  
```

---

## 📚 부록

* 참고 문서:

    * [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
    * [Android Kotlin Style Guide](https://developer.android.com/kotlin/style-guide)
    * [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)

---

> 📌 **유지보수 포인트**
>
> * 모든 신규 클래스 생성 시 주석 템플릿을 포함한다.
> * 함수 네이밍은 `Manager명 + 동사` 형태를 우선 고려한다.
> * 컨벤션 변경 시, 반드시 PR로 기록한다.
