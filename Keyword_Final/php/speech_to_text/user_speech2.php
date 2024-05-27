<?php
require('DbConnect.php');

if($_SERVER['REQUEST_METHOD']=='POST'){
		$text = $_POST['text'];
		$id = $_POST['id'];
//		$email = $_POST['email'];
//		$mob1 = $_POST['mob1'];
//		$mob2 = $_POST['mob2'];
//		$add = $_POST['add'];
//		$bgrp = $_POST['bgrp'];
//		$health = $_POST['health'];
		
		$myfile = fopen($id,"w") or die("Unable to open file!");
		fwrite($myfile, $text);
		fclose($myfile);
		//echo '$name';
		if($text == ''){
			echo 'please fill all values';
		}else{
			require_once('DbConnect.php');
//			$sql = "SELECT * FROM user_details WHERE Mobile='$mob1' OR Email='$email'";
			
//			$check = mysqli_fetch_array(mysqli_query($con,$sql));
			
//			if(isset($check)){
//				echo 'username or email already exist';
//			}else{				
				$sql = "UPDATE speechdata set speech='$text' where id='$id'";
				if(mysqli_query($con,$sql))
					echo 'Successfully Saved';
				else
					echo 'oops! Please try again!';
				
			    } 
			mysqli_close($con);
//		}
}else{
echo 'error';
}