<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Patient SignUp</title>
</head>
<body class = "text-center">
        <div class="container-sm">
            <div class="p-3 border bg-light">
                <div>
                        <label class = "display-4">Submit Patient Details</label>
                        <form action="post" class="needs-validation">
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">Patient ID:</label><br>
                                <input type="text" class="form-control"><br>    
                            </div>
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">User Name:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">Password:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">Name:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">Address:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">            
                                <label class="h6 mb-3 font-weight-normal">Contact:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <label class="h6 mb-3 font-weight-normal">Email:</label><br>
                                <input type="text" class="form-control"><br>
                            </div>
                            <div class="form-group">
                                <input type="submit" class="btn btn-primary btn-lg">
                            </div>
                        </form>
                    
                </div>
            </div>
        </div>
</body>
</html>