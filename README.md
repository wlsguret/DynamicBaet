# DynamicBeat
Java로 만든 리듬게임 2021.03~04

라이브러리
JavaSE-15, jlayer-1.0.1.jar 

실행파일 Main.java

JFrame 을 기본 베이스로 동작하고 멀티 쓰레드를 이용하여
메인, 게임플레이, 음악, 노트 각각 쓰레드를 구현했다.

KeyAdapter로 KeyEvent를 구현

Beat VO객체 
떨어지는 노트 각각의 정보를 저장한다.
public Beat(int time, String noteName)
time = 노트가 판정선에 도착하는 시간
noteName = 입력받는 key 종류 [S,D,F,Space,J,K,L]

Track VO객체 
게임 시작 전 곡 선택시 보여지는 리스트 각각의 정보를 저장하는 객체
해당 곡의 이미지파일 정보, mp3파일 정보, 곡 정보 들을 저장하고 있다.


게임에 사용된 이미지 파일들은 저작권 없는 Free Image를 다운로드 받아 편집하거나 직접 제작하여 사용하였다.
간단한 포토샵은 직접 할 수 있게 되었다.
