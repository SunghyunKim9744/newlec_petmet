<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 > 커뮤니티 > 게시글 리스트</title>
    <link rel="stylesheet" href="../../../css/style.css" type="text/css">
    <link rel="stylesheet" href="../../../css/admin/components/table/list.css" type="text/css">
    <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>

</head>

<body>
    <header class="header">
        <div class="container">
            <div class="logo">
                <a href="../../index.html">
                  <i class="fas fa-dog fa-3x"></i>
                  <h1>PetMet</h1>
                </a>
            </div>

            <nav>
                <h1 class="d-none">헤더 목록</h1>
                <ul>
                  <li>
                    <a href="../../user/index.html">
                      <i class="fas fa-users fa-2x"></i>
                      <span>USER</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../feed/index.html">
                      <i class="fas fa-camera-retro fa-2x"></i>
                      <span>FEED</span>
                    </a>
                  </li>
                  <li>
                    <a href="../index.html">
                      <i class="fas fa-american-sign-language-interpreting fa-2x"></i>
                      <span>COMMUNITY</span>
                    </a>
                  </li>
                  <li>
                    <a href="../../petplace/index.html">
                      <i class="fas fa-map-marked-alt fa-2x"></i>
                      <span>PLACE</span>
                    </a>
                  </li>
                </ul>
            </nav>

            <!-- <nav>
                <h1>바로가기 메뉴</h1>
                <ul>
                    <li><a href>펫멧이동</a></li>
                    <li><a href>로그아웃</a></li>
                </ul>
            </nav> -->
        </div>
    </header>

    <section class="body">
        <h1 class="d-none">Content Body</h1>
        <div class="container">
            <aside class="aside">
                <h1 class="d-none">Aside 메뉴</h1>

                <nav>
                    <h1 class="d-none">세부 메뉴 목록</h1>

                    <ul>
                        <li>
                            <a href="../notice/list.html">공지사항관리</a>
                        </li>

                        <li>
                            <a href="../QnA/list.html">QnA 관리</a>
                        </li>

                        <li>
                            <a href="list.html">카테고리 관리</a>
                        </li>

                        <li>
                            <a href="../board/list.html">게시글 관리</a>
                        </li>

                        <li>
                            <a href="../board/reported.html">신고된 게시글 관리</a>
                        </li>

                        <li>
                            <a href="../comment/list.html">댓글 관리</a>
                        </li>

                        <li>
                            <a href="../comment/reported.html">신고된 댓글 관리</a>
                        </li>
                    </ul>
                </nav>
            </aside>

            <main class="main">
                <h1 class="d-none">Main Content</h1>

                <section>
                    <h1 class="d-none">게시글 리스트</h1>

                    <input type="button" value="+ Add Category">
                    
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td class="col-l">카테고리명</td>
                                <td class="col-m">게시글 수</td>
                                <td>삭제</td>
                            </tr>
                        </thead>
                        
                        <tbody>
	                        <c:forEach var="c" items="${list }">
	                            <tr>
	                                <td>${c.id}</td>
	                                <td class="col-l"><input type="text" name="name" value="${c.name}"></td>
	                                <td class="col-m">${c.cntBoard}</td>
	                                <td><input type="checkbox" name=""></td>
	                            </tr>
	                        </c:forEach>
                        </tbody>
                    </table>
                </section>

                <section>
                    <h1 class="d-none">이벤트 버튼</h1>
                    <input type="submit" value="저장">
                    <input type="submit" value="삭제">
                </section>

                <div class="pager">
                    <div>
                      <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
                      <li><a href="#"">1</a></li>
                    </ul>
                    <div>
                      <a href="#"><i class="fas fa-angle-right"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                </div>
            </main>
        </div>
    </section>

    <footer class="footer">
        <div class="d-none">
            <h1>Footer</h1>
        </div>
    </footer>

</body>
</html>