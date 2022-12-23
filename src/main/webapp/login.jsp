<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/styles.css" />
</head>

<body>
<c:set var="funcName" value="LOG" scope="session"/>
<c:set var="msg" value="登入" />
<c:if test="${ ! empty sessionScope.timeOut }" > <!-- 表示使用逾時，重新登入 -->
   <c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>

   <div class="overlay">
      <!-- LOGN IN FORM by Omar Dsoky -->
      <form method="post" action="<c:url value='/loginServlet'/>">
         <!--   con = Container  for items in the form-->
         <div class="con">
         <!--     Start  header Content  -->
         <header class="head-form">
            <h2>Log In</h2>
            <!--     A welcome message or an explanation of the login form -->
            <p>login here using your username and password</p>
         </header>
         <!--     End  header Content  -->
         <br>
         <div class="field-set">
           
            <!--   user name -->
               <span class="input-item">
                 <i class="fa fa-user-circle"></i>
               </span>
              <!--   user name Input-->
               <input class="form-input" id="txt-input" type="text" placeholder="@UserName" name="username" value="${username}" οnkeyup="this.value=this.value.replace(/\s+/g,'')" required>
           
            <br>
           
                 <!--   Password -->
           
            <span class="input-item">
              <i class="fa fa-key"></i>
             </span>
            <!--   Password Input-->
            <input class="form-input" type="password" placeholder="Password" id="pwd" name="password" value="${password}" οnkeyup="this.value=this.value.replace(/\s+/g,'')" required>
           
      <!--      Show/hide password  -->
           <span>
              <i class="fa fa-eye" aria-hidden="true" type="button" id="eye"></i>
           </span>
           
           
            <br>
      <!--        buttons -->
      <!--      button LogIn -->
           <button class="log-in" onclick="login()">Log In</button>
         </div>
        
      <!--   other buttons -->
         <div class="other">
      <!--      Forgot Password button-->
      <!--     Sign Up button -->
      <!--         Sign Up font icon -->
            <i class="fa fa-user-plus" aria-hidden="true"></i>
      <!--      End Other the Division -->
         </div>
           
      <!--   End Conrainer  -->
        </div>
        
        <!-- End Form -->
      </form>
      </div>
      
      <script>
      function show() {
         var p = document.getElementById('pwd');
         p.setAttribute('type', 'text');
     }
     
     function hide() {
         var p = document.getElementById('pwd');
         p.setAttribute('type', 'password');
     }
     
     var pwShown = 0;
     
     document.getElementById("eye").addEventListener("click", function () {
         if (pwShown == 0) {
             pwShown = 1;
             show();
         } else {
             pwShown = 0;
             hide();
         }
     }, false);
     function login() {
    	    document.forms[0].action="loginServlet" ;
    		document.forms[0].method="POST";
    		document.forms[0].submit();
    	}
     </script>
     
</body>
</html>