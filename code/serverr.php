
<?php
$fname = $lname=$phn=$mailid =$CaptainId=$pass=$cpass="";
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

$sql = $sql = "INSERT INTO admin (fname,lname,mailid,phn,pass,cpass)
VALUES ('gaurav','kumar','gaurav@gmail.com','98455638','pass','cpass')";


if (mysqli_query($conn, $sql)) {
    echo "done";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
  }


$obj=json_decode($_GET['json']);

echo $obj->name;




?>