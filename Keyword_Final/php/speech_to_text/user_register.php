<?php
require('DbConnect.php');

if($_SERVER['REQUEST_METHOD']=='POST'){
		$name = $_POST['name'];
	//	$acc_no = $_POST['acc_no1'];
		$password = $_POST['password'];
		$email = $_POST['email'];
		$mob = $_POST['mob'];
		//$lat = $_POST['lat'];
	//	$lon = $_POST['lon'];
	//	$balance = $_POST[2000];

		//echo '$name';
		if($name == ''||$password == ''||$email == ''||$mob == ''){
			echo 'please fill all values';
		}else{
			require_once('DbConnect.php');
			$sql = "SELECT * FROM speechdata WHERE Mobile='$mob' OR Email='$email'";
			
			$check = mysqli_fetch_array(mysqli_query($con,$sql));
			
			if(isset($check)){
				echo 'username or email already exist';
			}else{				
				$sql = "INSERT INTO speechdata (Name,Password,Email,Mobile) VALUES('$name','$password','$email','$mob')";
				if(mysqli_query($con,$sql))
					echo 'successfully registered';
				else
					echo 'oops! Please try again!';
				
			    } 
			mysqli_close($con);
		}
}else{
echo 'error';
}