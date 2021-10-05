# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 내용
* Domain
  * Player : Console API를 통해 값을 입력하는 사용자 도메인
    * 숫자인지 확인
    * 중복되는 값이 있는지 확인
    * 3자리인지 확인
    * 결과값 가져오기
    * 숫자 다시 입력할 때 값 초기
    * 숫자를 모두 맞춰서 게임 완료되었는지 확인
  * Computer : Randoms API를 통해 값을 갖는 컴퓨터 도메인
    * 랜덤 숫자 생성
    * 중복되는 값이 있는지 확인
  * Constant : 상수
    * 최소 숫자
    * 최대 숫자
    * 자릿수
  * ErrorMessage : 에러 메세지 enum
    * 숫자 범위 에러
    * 중복된 숫자 에러
    * 자릿수 에러
* View
  * InputView : 입력값을 갖는 뷰
    * 게임 시작할 때 문구 출력
    * 입력값 받기
  * OutputView : 결과를 출력하는 뷰
    * 게임 결과 출력
    * 게임 완료 후, 게임 재진행 안내문 출력
* Controller
  * BaseballGameController
    * 게임 시작하기
    * 게임 완료된 후, 재진행 처리