
### Chapter 01 : Hello God Of Java
- [`4. main 메소드를 만들자`](#4-main-메소드를-만들자)
- [`6. 주석 (Comment) 처리하기`](#6-주석-comment-처리하기)

---

### `4. main 메소드를 만들자`

`java` 명령어로 실행하는 자바 프로그램은 방드시 시작점, `main` 메소드가 있어야 한다. `"일반적으로"` `main` 메소드는 다음의 형태를 갖춰야 한다.

```java
public static void main(String[] args);
```

키워드의 뜻은 `C/C++`, `Python` 에서와 동일하다. 그나마 이 중 언급할 만한 것을 정리하면 다음과 같다.

- `public` : `접근제어자`, `access modifier`
    - 접근제어자를 사용해 메서드의 사용 권한을 사용할 수 있다. `Java` 에서 접근제어자에는 다음과 같은 것들이 있다.
    - `public`, `private`, `protected`, `default`
    - 이 중 `default` 접근제어자는 처음 봤다. `default` 는 변수, 메서드의 접근제어자를 명시하지 않았을 때 자동으로 설정된다.
    `default` 접근제어자가 설정되면 동일한 패키지 안에서만 접근 가능하다. [`[1]`](#점프-투-자바-07-02-접근-제어자---wikidocs), [`[2]`](#static-keyword---wikipedia)

- `static`
    - `접근제어자` 처럼 관련된 키워드를 통칭하는 이름은 없는 것 같다. `(생각해보니 애초에 Java 에서 static 을 제외하고 lifetime 과 관련된 키워드가 또 있나? 궁금하네)`
    - 놀랍게도 `Java` 에서는 `static local variable` 을 생성할 수 없다한다. `Java` 의 `static` 키워드는 `class-level` 의 변수와 메소드를 위해 존재한다. [`[3]`](#how-do-i-create-a-static-local-variable-in-java---stackoverflow)

- `void`
    - `Java` 에서 `void` 는 `"타입"` 이 아니다. [`[4]`](#is-void-a-type---stackoverflow)
    - `Java` 의 데이터 타입에 관해 찾아보다 좋게 정리한 글을 찾아 첨부한다.
    - [`[2주차] 자바 데이터 타입, 변수 그리고 배열`](https://catsbi.oopy.io/6541026f-1e19-4117-8fef-aea145e4fc1b)

- `main` : `(아주 당연하게도)` 메소드의 이름이 `main` 이어야 한다. `C/C++` 의 `main` 함수가 존재하는 것과 비슷한 이유이다.

- `String []` : 원래 배열의 사이즈를 명시적으로 적어줘야 되는지 아닌지에 대한 내용을 적으려 했으나, 이는 나중에 더 배우고 적는게 나을 것 같다.

---

### `6. 주석 (Comment) 처리하기`

`Java` 에서 주석을 다는 방식은 `C/C++` 과 동일하다. 해당 줄을 주석처리 하려면 `//`, 여러 줄을 처리하려면 `/**/` 을 사용한다.

덧붙여 `Java` 에서 `/** */` 로 주석처리하는 것은 문서용 주석으로 간주한다.


---

### Reference

- ##### [`점프 투 자바, 07-02 접근 제어자 - wikidocs`](https://wikidocs.net/232)
    - `[1]` : 접근 제어자를 별도로 설정하지 않는다면 변수나 메서드는 default 접근 제어자가 자동으로 설정되어 동일한 패키지 안에서만 접근이 가능하다.

- ##### [`Static (keyword) - Wikipedia`](https://en.wikipedia.org/wiki/Static_(keyword))
    - `[2]` : In programming languages such as C, C++, Objective-C, and Java, static is a reserved word controlling both lifetime (as a static variable) and visibility (depending on linkage).


- ##### [`How do I create a static local variable in Java? - Stackoverflow`](https://stackoverflow.com/questions/2079830/how-do-i-create-a-static-local-variable-in-java)
    - `[3]` : I've read Java does not support static local variables unlike C/C++.

- ##### [`Is void a type? - Stackoverflow`](https://stackoverflow.com/questions/7560034/is-void-a-type)
    - `[4]` : Note that the Java programming language does not allow a "cast to void"-void is not a type




