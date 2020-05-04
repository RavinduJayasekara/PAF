<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Patient Login</title>
</head>
<body>
      <div class="container-sm">
        <div class="p-3 border bg-light">
          <label class="display-4">Patient Login</label>
          <form class="px-4 py-3">
            <div class="form-group">
              <label for="exampleDropdownFormEmail1">User Name:</label>
              <input type="text" class="form-control" id="username" placeholder="User Name">
            </div>
            <div class="form-group">
              <label for="exampleDropdownFormPassword1">Password</label>
              <input type="password" class="form-control" id="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary btn-lg">Sign in</button>
          </form>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="SignUp.html">Do you have a account? Sign up</a>
        </div>
      </div>
</body>
</html>