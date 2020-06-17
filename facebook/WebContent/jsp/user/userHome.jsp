<%@ page import="com.college.facebook.app.model.PostDetails" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <link rel="stylesheet" type="text/css" href="./css/post.css"/>
    <script type="text/javascript">

        function like() {
            document.posts.action="like";
            document.posts.submit();
        }

        function unlike() {
            document.posts.action="unlike";
            document.posts.submit();
        }

    </script>
    <style>
        img {
            width: 20px;
        }
    </style>
</head>
<%@include file="userHeader.jsp" %>
<body>
<div align="center">
    <h3 style="color: green">${success}</h3>
    <h3 style="color: red">${errmsg}</h3>
</div>
<%
    List<PostDetails> postDetails = (List<PostDetails>) request.getAttribute("posts");
%>

<form action="" name="posts" method="get">
    <% for (int i = 0; i < postDetails.size(); i++) {%>
        <div class="row">
            <div class="rightcolumn">
                <div class="card">
                    <h3><%=postDetails.get(i).getUsername()%></h3>
                    <h2><%=postDetails.get(i).getTitle()%></h2>
                    <img class="fakeimg" src="display?name=<%=postDetails.get(i).getPath()%>" alt="image" style="height: 50%"/>
                    <p><%=postDetails.get(i).getMessage()%></p>
                    <div>
                        <label><b>Likes: </b><%=postDetails.get(i).getLike()%></label>
                    </div>
                    <div style="text-align: right;">
                        <% if (postDetails.get(i).isEnable()) { %>
                            <button class="button button2" name="likeUnlike" value="<%=postDetails.get(i).getPostId()%>" onclick="like()">
                                Like<img class="likeUnlike" src="./images/like-icon.png" />
                            </button>
                        <%} else {%>
                            <button class="button button3" name="likeUnlike" value="<%=postDetails.get(i).getPostId()%>" onclick="unlike()">
                                Dislike<img class="likeUnlike" src="./images/unlike-icon.png" />
                            </button>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    <%}%>
</form>
</body>
</html>
