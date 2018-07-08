<!DOCTYPE html>
<html lang="en">
<head>
	<title>School Profile</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/schl.css">
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-b-200 p-t-50">
				
					<span class="login100-form-title p-b-43 ">
						school profile
					</span>
					  <h4 class="">The school profile is shown below :</h4>            
					  <table class="table table-bordered tab">
					    <thead>
					      <tr>
					        <th> Name </th>
					        <th> Address </th>
					        <th> Locality </th>
					        <th> State </th>
					        <th> Total Classes </th>
					        <th> Gender </th>
					        <th> Medium of Instruction </th>
					        <th> Total No of Students </th>
					        <th> School DISE code </th>
					        <th> Total No of Teachers</th> 
					       </tr>
					    </thead>
					    <tbody>
					    	<?php 
                             $conn=mysqli_connect("localhost","root","toor","CareworksFoundations");
                             if(mysqli_connect_errno()){
                             	echo "Error".mysqli_connect_error();
                             }
                             $query="select * from SchoolProfile";
                             $result=mysqli_query($conn,$query);
                             while($row=mysqli_fetch_array($result))

					    
					      echo "<tr>
					        <td>$row[1]</td>
					        <td>$row[2]</td>
					        <td>$row[3]</td>
					        <td>$row[4]</td>
					        <td>$row[5]</td>
					        <td>$row[7]</td>
					        <td>$row[8]</td>
					        <td>$row[6]</td>
					        <td>$row[0]</td>
					        <td>$row[9]</td>
					      </tr>";
					  
					      ?>
					      
					    </tbody>
					  </table>
					  
					  	<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Confirm
						</button>
						</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							<a href="http://13.229.47.52:8000/category_data.php">Back</a>
						</button>
					</div>
					
				
			</div>
		</div>
	</div>
	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>