<?php

			 require 'DbConnect.php';
			 if(isset($_REQUEST["name"]) && isset($_REQUEST["password"]) ){    //In Gender Case We Revese it gender for given reverse gender data Ie. Male Member given Female Data 
                
				 $ck_query='select * from speechdata where Name="'.$_REQUEST['name'].'" AND Password="'.$_REQUEST['password'].'"'; //check if Student already present or not 
		         $result=mysqli_query($con,$ck_query);

				   if(mysqli_num_rows($result)>0){
				      
				   $data=mysqli_fetch_array($result);
     			 
				   $response['userId'] = $data['id'];
				   $response['Name']=$data['Name'];
				//    $response['lat']=$data['lat']; 
				//	$response['lon']=$data['lon'];

				   $response['success'] = "200";
			       $response['message'] = "Sucessfully Login";
				 }else{
				   $response['success'] = "201";
			       $response['message'] = "Invalid User";
				   
			  }
			  die(print_r(json_encode($response),true));
             }
			  else{
	               $response['success'] = "201";
			       $response['message'] = "Enter Username And Password";
				   die(print_r(json_encode($response),true));
				  
			  }
  ?>