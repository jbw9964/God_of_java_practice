
### Chapter 15 : String - 정리해 봅시다.

---

#### 직접 해봅시다

현 챕터의 `정리해 봅시다` 는 아래 문자열을 이용해 풀이한다.

```
The String class represents character strings.
```


- `[1]` : `API` 문서에서 `String` 클래스를 찾아 필요할 때마다 참조할 수 있도록 하자.
- `[2]` : `d.string.practice` 패키지에 `UseStringMethods` 라는 클래스를 만들고, `main()` 메서드도 만들자.
- `[3]` : `public void printWords(String str)` 로 선언된 메서드를 만들자. 이 메서드는 `str` 문장의 단어들을 출력한다. 예제 문장을 `str` 값으로 전달하여 `main()` 메서드에서 이 메서드를 호출하여 결과를 확인해 보자.

```
The
String
class
represents
character
strings.
```

- `[4]` : `public void findString(String str, String findStr)` 메서드를 만들자. 이 메서드는 `str` 중에서 `findStr` 로 넘겨준 값과 동일한 단어의 첫 번째 위치를 출력한다. 예제 문장을 `str` 값으로 전달하고, `findStr` 에는 `"string"` 을 넘겨주자. `main()` 메서드에서 이 메서드를 호출하여 결과를 확인해 보자.

```
string is appeared at 38
```

- `[5]` : `public void findAnyCaseString(String str, String findStr)` 메서드를 만들자. 이 메서드는 `str` 중에서 `findStr` 로 넘겨준 값과 `"대소문자 구분 없이"` 동일한 단어의 첫 번째 위치를 출력한다. 예제 문장을 `str` 값으로 전달하고, `findStr` 에는 `"string"` 을 넘겨주자. `main()` 메서드에서 이 메서드를 호출해 결과를 확인해 보자.

```
string is appeared at 4
```

- `[6]` : `public void countChar(String str, char c)` 메서드를 만들자. 이 메서드는 `str` 에서 `c` 와 동일한 `char` 의 개수를 출력한다. 예제 문장을 `str` 값으로 전달하고, `c` 는 `'s'` 를 넘겨주자. `main()` 메서드에서 이 메서드를 호출하여 결과를 확인해 보자.

```
char 's' count is 6
```

- `[7]` : `public void printContainWords(String str, String findStr)` 메서드를 만들자. 이 메서드는 `str` 문자열에서 `findStr` 이 포함된 단어를 출력한다. 예제 문장을 `str` 값으로 전달하고, `findStr` 는 `"ss"` 를 넘겨주자. `main()` 메서드에서 이 메서드를 호출하여 결과를 확인해 보자.

```
class contains ss
```
