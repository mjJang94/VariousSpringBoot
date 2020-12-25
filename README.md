# 오라클 클라우드 활용을 위한 프로젝트
Spring Boot를 활용한 토이프로젝트

    
    
### 개발환경
- java 1.8
- intellij
- springboot
- oracle cloud
- ubuntu
    
### 명령어 몇가지 정리
1. jar 묶기 (인텔리제이 터미널에서)
<pre>
<code>
./gradlew bootjar
</code>
</pre>

2. jar 실행
<pre>
<code>
java -jar <파일 이름>
</code>
</pre>
__파일 이름 뒤에 & 추가시 백그라운드로 실행, 터미널이 닫혀도 유지__

3. 실행중인 jar 확인
<pre>
<code>
ps -ef | grep java  
</code>
</pre>

4. 실행중인 jar 종료시키기
<pre>
<code>
kill -9 <PID>
</code>
</pre>

5. 동작시킨 jar port 접속 혀용하기
<pre>
<code>
sudo iptables -I INPUT 1 -p tcp --dport <포트번호> -j ACCEPT  
</code>
</pre>
__관리자 권한 필요__

6. 3번의 iptable이 없는경우
<pre>
<code>
sudo apt-get install iptables
</code>
</pre>
__관리자 권한 필요__
