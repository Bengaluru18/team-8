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
// define variables and set to empty values
    
$fname = $lname =$phn =$mailid= $pass =$cpass="";
if (isset($_POST['submit'])) { 
    $fname=$_POST['fname'];
    $lname=$_POST['lname'];
    $phn= $_POST['phn'];
    $mailid=$_POST['mailid'];
    $pass=$_POST['pass'];
    $cpass=$_POST['cpass'];

$servername = "localhost";
$username = "root";
$password = "toor";
$dbname = "CareworksFoundations";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO admin (fname,lname,mailid,phn,pass,cpass)
VALUES ('$fname','$lname','$mailid','$phn','$pass','$cpass')";


if (mysqli_query($conn, $sql)) {
    echo "done";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
  }



?>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-160 p-t-50">
				<form method="post" class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
					Welcome to the Sign Up Page
					</span>
					
					<div class="wrap-input100 rs1 validate-input" data-validate = "First name is required">
						<input class="input100" type="text" name="fname">
						<span class="label-input100">First Name</span>
					</div>
					
					
					<div class="wrap-input100 rs2 validate-input" data-validate="Last name is required">
						<input class="input100" type="text" name="lname">
						<span class="label-input100">Last Name</span>
					</div>

					<div class="wrap-input100 rs3 validate-input" data-validate="Email id is required">
						<input class="input100" type="email" name="mailid">
						<span class="label-input100">Email id</span>
					</div>

					<div class="wrap-input100 rs4 validate-input" data-validate="Phone no is required">
						<input class="input100" type="phone" name="phn">
						<span class="label-input100">Phone </span>
					</div>

					<div class="wrap-input100 rs5 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="pass">
						<span class="label-input100">Password</span>
					</div>

					<div class="wrap-input100 rs6 validate-input" data-validate="Password confirmation is required">
						<input class="input100" type="password" 
						name="cpass">
						<span class="label-input100">Confirm Password</span>
					</div>
                    <div class="container-login100-form-btn">

					<input type="submit" name="submit" value="Submit" class="login100-form-btn">
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