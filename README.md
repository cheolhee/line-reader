# line-reader

STDIN으로부터 입력을 받아 line-handler에 전달한다.

라인 핸들러는 현재 라인, 라인번호(1부터 시작) 두 인자를 받는 함수이다.

이것을 스킵하거나 가공해서 출력하거나 ... 

```
(fn [line number] ( ... )
```
## why?

파일이나 STDIN 입력값을 필터링하거나 변환하는 작업을 자주 하게 되는데, 

원래 sed/awk, perl 에서 하던 작업을 Clojure로 하고 싶었다.

## Usage

함수를 지정하지 않으면, 그냥 행 번호와 함께 출력한다.
```
java -jar line-reader.jar <some-file.txt
```

 모든 입력을 대문자로 바꾼다.
```
java -jar line-reader.jar '(fn [l c] (println (.toUppercase l)))' <some-file.txt
```

 웹페이지에서 이미지 src만 추출한다.
```
curl "http://www.illustrationweb.com/artists" | lein run '(fn [l c] (if-let [a (second (re-find #"src=\"(.+?(jpe?g|png|gif))\"" l))] (println a)) )'
```

## TO DOs

- 함수를 입력 파라메터가 아닌 외부 파일로부터 입력 가능하게.
- 정규식 입력을 따로 분리




## License

Copyright © 2016 cheolhee

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
