
## 해당 폴더는 공부 내용을 기록하기 위한 양식을 정리한 폴더입니다.

- 공부한 내용은 모두 [`scripts`](../scripts/) 폴더에 저장합니다.
- [`scripts`](../scripts/) 폴더는 각 챕터별 폴더로 구성되어 있습니다.

```
scripts
├── ch_01
│   ├── code
│   │   ├── Problem_1
│   │   │   ├── README.md
│   │   │   ├── solution.java
│   │   │   └── solution.md
│   │   ├── Problem_2
│   │   │   ├── README.md
│   │   │   ├── solution.java
│   │   │   └── solution.md
│   │   └── sample.java
│   ├── extra
│   │   ├── extra_sample_1.md
│   │   └── extra_sample_2.md
│   ├── README.md
│   ├── section_02.md
│   └── section_04.md
└── ch_02
    ├── code
    ├── README.md
    └── section_01.md
```

--- 

## 1. `chatper` directory

각 챕터별 폴더는 다음과 같이 구성되어 있습니다.

```
scripts/ch_01
├── code
│   ├── Problem_1
│   │   ├── README.md
│   │   ├── solution.java
│   │   └── solution.md
│   ├── Problem_2
│   │   ├── README.md
│   │   ├── solution.java
│   │   └── solution.md
│   └── sample.java
├── extra
│   ├── extra_sample_1.md
│   └── extra_sample_2.md
├── README.md
├── section_02.md
└── section_04.md
```

- 챕터에서 수행한 코드를 저장할 `code` 폴더
- 챕터에 관한 포괄적인 내용을 담은 `README.md` 파일
- 각 절 `(section)` 에서 배운 내용을 적을 `section_**.md` 파일들
- 그 외 추가적으로 기록하고 싶은 내용이 담긴 `extra` 폴더

만약 `extra` 또는 `code` 폴더와 같이, 적을 내용이 없는 경우에는 해당 폴더, 파일을 생성하지 않아도 됩니다.

이는 `section_**.md` 또한 마찬가지 입니다.

---

### A. 챕터에 관한 포괄적을 내용을 담은 `README.md` 파일

`README.md` 파일은 해당 챕터를 `공부하기 전`, `공부한 후` 에 작성합니다. 
`공부하기 전` 에는 챕터에 어떤 `section` 들이 있는지 확인하기 위함이고, `공부한 후` 에는 공부한 전체적인 내용을 기록하기 위함입니다.

따라서 `README.md` 파일에는 다음과 같은 내용이 포함되어야 합니다.
- 챕터에 속한 각 `section` 의 목차
- 각 `section` 에 속한 문제와 문제 풀이 `(link)`
- 챕터를 공부하고 추가적으로 기록한 내용의 목차
- 챕터를 끝내고 배운 내용 또는 중요하다 느낀 점을 적은 script

이에 대한 전체 양식은 다음과 같습니다.

```markdown
### Chapter `{chapter_num}` : `{chapter_name}`

- [`{section_01_name}`]({src_to_sec1})
- [`{section_02_name}`]({src_to_sec2})
- [`{section_03_name}`]({src_to_sec3})
    - [`{Problem_1}`]({src_to_code_Problem_1})
- [`{section_04_name}`]({src_to_sec4})
- [`{section_05_name}`]({src_to_sec5})
- [`{section_06_name}`]({src_to_sec6})
    - [`{Problem_2}`]({src_to_code_Problem_2})

- [`{extra_scripts_01}`]({src_to_extra1})
- [`{extra_scripts_02}`]({src_to_extra2})
- [`{extra_scripts_03}`]({src_to_extra3})

---

### What I learned from this chapter

- `{scripts}`
```

만약 추가적으로 기록한 내용이 없거나 `({extra_scripts})`, `section` 에 문제가 없을 경우 `({Problem})`, 해당 내용은 생략합니다.

양식은 [`link`](./ch___README_sample.md) 를 눌러 직접 확인하실 수 있습니다. 

---

### B. 각 `section` 에서 배운 내용을 적을 `section_**.md` 파일

`section_**.md` 파일은 여러개 일 수 있습니다. 각 챕터별로 순서를 매겨 각자 저장합니다. 만약 챕터에 `section` 이 5 개라면 `section_01.md` ~ `section_05.md` 파일이 존재할 수 있습니다.

`section_**.md` 의 양식에 대한 내용입니다. `section_**.md` 는 해당 section 에서 배운 내용을 정리해 기록하고, 관련된 내용에 대해 수행한 점을 기록합니다. 이는 관련 내용 검색 결과, 내용 검증 코드 등이 될 수 있습니다. 

하지만 기록할 때 사용한 참고자료가 있다면 반드시 이를 표기해야 합니다.

정리하자면 `section_**.md` 는 다음과 같은 내용을 포함합니다.
- 해당 `section` 에서 배운 내용을 정리한 `script`
- 배운 내용을 활용해 공부한 내용
- 위 과정에서 참고한 자료

`section_**.md` 의 전체 양식은 다음과 같습니다.

```markdown

### Chapter `{chapter_num}` : `{chapter_name}` - `{section_name}`

- `{scripts}`

---

### Reference

- 1. [`{link_1}`]() : `{Reference_description}`
- 2. [`{link_2}`]() : `{Reference_description}`
```

양식은 [`link`](./ch___section_00_sample.md) 를 눌러 직접 확인하실 수 있습니다. 

---

## 2. `code` directory

각 챕터 폴더에 속한 `code` 폴더에 대한 설명입니다.

```
scripts/ch_01/code
├── Problem_1
│   ├── README.md
│   ├── solution.java
│   └── solution.md
├── Problem_2
│   ├── README.md
│   ├── solution.java
│   └── solution.md
└── sample.java
```

`code` 폴더는 챕터에서 수행한 코드를 저장할 폴더입니다.

`code` 폴더는 다음과 같은 구성을 갖고 있습니다.
- 해당 챕터에 속한 문제에 대한 폴더들
    - 문제에 대한 설명을 적은 `README.md`
    - 문제 풀이를 설명한 `solution.md`
    - 문제 풀이에 사용된 소스코드 `solution.java`
- 그 외 남기고 싶은 모든 것

만약 해당 챕터에 문제가 있다면 반드시 풀이하고, 그에 대한 solution 을 작성해 기록해야 합니다. solution 에 대한 양식은 없습니다.

그 외의 것은 자유롭게 작성하셔도 됩니다.

---

## 3. `extra` directory

각 챕터 폴더에 속한 `extra` 폴더에 대한 설명입니다.

```
scripts/ch_01/extra
├── extra_sample_1.md
└── extra_sample_2.md
```

`extra` 폴더는 추가적으로 기록하고 싶은 내용을 저장하는 폴더입니다.

간단한 예시로, `M1 Mac 에 java 설치, 실행하는 법` 또는 `java 에서 indentation` 등이 있을 수 있습니다.

양식은 없습니다.
