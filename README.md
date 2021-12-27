### zero base 4주차 과제 제출
#### 게시판 페이징 구현
- 미흡한점 : 게시글 아래의 navigation block기능 구현 listPage.html 부분 하드코딩으로 대체
```html
<nav style="text-align: center;">
    <p th:text="${pagingConfigure}"></p>
    <ul>
        <li><a href="/postList?page=1">1&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=2">2&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=3">3&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=4">4&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=5">5&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=6">6&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=7">7&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=8">8&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=9">9&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=10">10&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=11">11&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=12">12&nbsp;&nbsp;&nbsp;</a></li>
        <li><a href="/postList?page=13">13&nbsp;&nbsp;&nbsp;</a></li>
    </ul>
</nav>
```
