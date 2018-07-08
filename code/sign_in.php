<!DOCTYPE html>
<html lang="en">
<head>
	<title>Sign In</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	<?php
    $conn=mysqli_connect("localhost","root","toor","CareworksFoundations");
    if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
    $sql ="select mailid,pass from admin";
    $result = $conn->query($sql);
    if($result->num_rows >0){
    	while($row=$result->fetch_assoc()){
    		if($_POST['username']==$row["emailid"] && $_POST['pass']==$row["pass"]){
    			echo "successfull";
    		}
    	}
    }
    
	?>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
				<form class="login100-form validate-form" method="post">
					<span class="login100-form-title p-b-43">
						User Login
					</span>
					
					<div class="wrap-input100 rs1 validate-input" data-validate = "Username is required">
						<input class="input100" type="text" name="username">
						<span class="label-input100">Username</span>
					</div>
					
					
					<div class="wrap-input100 rs2 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="pass">
						<span class="label-input100">Password</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
                                                 <a href="http://13.229.47.52:8000/category_data.php">
							Sign in
                                                        </a>
						</button>
					</div>
					
					<div class="text-center w-full p-t-23">
						<a href="#" class="txt1">
							Forgot password?
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>