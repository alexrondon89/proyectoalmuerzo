<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"rel="stylesheet">
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    
<body>
	<form method="POST">
	  <div class="form-group">
	   	<label for="name">email</label>
	    <input type=text class="form-control" id="email" name="email"  aria-describedby="emailHelp" placeholder="tu email">
	    
	    <label for="name">password</label>
	    <input type=text class="form-control" id="password" name="password"  aria-describedby="emailHelp" placeholder="tu email">
	    
	  </div>
	  <button type="submit" class="btn btn-primary">borrar</button>
	</form>
</body>

</html>
