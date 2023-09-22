<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>cozentus</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href= class="navbar-brand"> Cozentus</a>
			</div>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>"/new">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>"/list">Add Users</a>
      </li>
      </ul>
      </div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${userById != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${userById == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					
						<c:if test="${userById != null}">
            			<h2 class = "text-success">Edit User</h2>
            		</c:if>
						<c:if test="${userById == null}">
						<h2 class = "text-info">Add New User</h2>
            			
            		</c:if>
					</h2>
				</caption>
            		
				<c:if test="${userById != null}">
					 <form action ="insert" method ="post">
				</c:if>
				<c:if test="${userById != null}">
					 <form action ="update" method ="post">
				</c:if>
              <form action ="insert" method ="post">
				<div class="form-group">
					<label for = "ID"></label> 
					<input type="text" class="form-control" name="name" placeholder="Enter id">
				</div>

				<div class="form-group">
					<label for= "Name"></label> 
					<input type="text" class="form-control" name="name" placeholder="Enter Name">
				</div>

				<div class="form-group">
					<label for="Email address"></label> 
					<input type="email" class="form-control" name="name"placeholder="Enter Email">
				</div>
				<div class="form-group">
					<label for="Country"></label> 
					<input type="text" value=" class="form-control" name="text"placeholder="Enter country">
				</div>
                 <c:if test ="${userById == null }">
				<input type="submit" class="btn btn-success" value="insert user"/>
				</c:if>
				<c:if test ="${userById != null }">
				<input type="submit" class="btn btn-success" value="update user"/>
				</c:if>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
