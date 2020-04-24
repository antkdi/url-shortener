<div align="center">
<h1>Url-Shortener</h1>
</div>

- [1.Subject](#1subject)
- [2.Environment](#2environment)
- [3.Install](#3install)
- [4. Usage](#4-usage)
- [2.Environment](#2environment-1)



## 1.Subject 

URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service

    - URL 입력폼 제공 및 결과 출력
    - URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
    - 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
    - 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
    - Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
    - Database 사용은 필수 아님



 ## 2.Environment 

  - JDK 1.8
  - InteliJ
  - Gradle 4.10.3
  - lombok 1.18.6
  - JPA / Hibernate
  - Spring boot 2.2.2.RELEASE
  - Junit (SpringBootTest)
  - H2 Database 
  - JSP



 ## 3.Install 

  - Repository Clone

    - `$ git clone https://github.com/antkdi/url-shortner`

    

## 4. Usage

  - Build

    - `$ ./gradlew bootWar`

  - Execute

    - `$ java -jar ./build/libs/url-shortner.war`

    

