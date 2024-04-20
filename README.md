- 프로메테우스 설정 및 실행 화면
![스크린샷 2024-04-20 오후 2 33 54](https://github.com/yhyoon1004/spring_boot_core_util/assets/79188190/a0ca76b8-8f8a-4fba-acaa-906ab7a58d4a)

- 프로메테우스 모니터링 그래프 (변화량/증가량)
  - increase( ~ [시간값])을 사용하여 변화량을 그래프로 확인 가능
  - http_server_requests_seconds_count{uri="/log"}  기존에는 기존값에서 증가만하는 그래프
  - rate(~ [시간값]) 평균증가율 | irate(~ [시간값]) => 순간증가율
  <img width="1512" alt="스크린샷 2024-04-20 오후 5 27 49" src="https://github.com/yhyoon1004/spring_boot_core_util/assets/79188190/cb4e3db9-1cc6-4694-b6df-ea543542282f">
