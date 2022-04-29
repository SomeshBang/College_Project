<?php

session_start();

$userloginid=$_SESSION["userid"] = $_GET['userlogid'];
// echo $_SESSION["userid"];


?>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]>      <html class="no-js"> <![endif]-->
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Student Dashboard</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- <link rel="stylesheet" href="style.css"> -->
    </head>
    <style>
            .innerright,label {
    color: rgb(16, 170, 16);
    font-weight:bold;
}
.container,
.row{
    margin:auto;
    background-color: white;
}

.imglogo {
    margin:auto;
    background-color: white;
    width: 400px;
    height: 200px;
    object-position: center top; 
}
.innerdiv {
    text-align: center;
    margin: 100px;
}
input{
    margin-left:20px;
}
.leftinnerdiv {
    float: left;
    width: 25%;
    margin-top: -50px;
}

.rightinnerdiv {
    float: right;
    width: 75%;
    margin-top: -50px;
}

.innerright {
    background-color: white;
    font-family: fangsong;
    text-align: left;
    margin-left: 70px;
    
}

.voiletbtn {
    background-color: #a1069c;
    color: white;
    width: 95%;
    height: 40px;
    margin-top: 5px;
    border-radius: 15px;
    cursor: pointer;
}

.voiletbtn:hover{
    transform: scale(1.2); 
}

.voiletbtn,
a {
    text-decoration: none;
    color: white;
    font-size: large;
    margin: 5px;
    font-family: fangsong;
    
}

.xy{
    background-color: white;
}

th{
    background-color: #ffffff;
    color: black;
    text-align: center;
    
}
td{
    background-color: white;
    color: black;
}
td, a{
    color: #a1069c;
    text-align: center;
    
}
    </style>
    <body class="xy">

    <?php
   include("data_class.php");
    ?>
            <div class="container">
            <div class="row"><img class="imglogo" src="images/logo.png"/></div>
            <span class="d-block p-2 text-white" style="background-color:#a1069c; border-radius: 50px;">
                <h4 style="color:White; font-size: 1.5rem; text-align-last: center;  margin-top: 15px; font-family: fangsong;">Student Panel</h4>
            </span>
            <div class="innerdiv">
            <div class="leftinnerdiv">
                <!-- <button class="voiletbtn" >Welcome</button> -->
                <button class="voiletbtn" onclick="openpart('myaccount')"> My Account</button>
                <button class="voiletbtn" onclick="openpart('requestbook')"> Request Book</button>
                <button class="voiletbtn" onclick="openpart('issuereport')"> Issue Report</button>
                <a href="index.php"><button class="voiletbtn" >Logout</button></a>
            </div>


            <div class="rightinnerdiv">   
            <div id="myaccount" class="innerright portion" style="<?php  if(!empty($_REQUEST['returnid'])){ echo "display:none";} else {echo ""; }?>">
            <button class="voiletbtn" >My Account</button>

            <?php

            $u=new data;
            $u->setconnection();
            $u->userdetail($userloginid);
            $recordset=$u->userdetail($userloginid);
            foreach($recordset as $row){

            $id= $row[0];
            $name= $row[1];
            $email= $row[2];
            $pass= $row[3];
            $type= $row[4];
            }               
                ?>

            <p style="color:black"><u>Person Name:</u> &nbsp&nbsp<?php echo $name ?></p>
            <p style="color:black"><u>Person Email:</u> &nbsp&nbsp<?php echo $email ?></p>
            <p style="color:black"><u>Account Type:</u> &nbsp&nbsp<?php echo $type ?></p>
        
            </div>
            </div>


            



            <div class="rightinnerdiv">   
            <div id="issuereport" class="innerright portion" style="<?php  if(!empty($_REQUEST['returnid'])){ echo "display:none";} else {echo "display:none"; }?>">
            <button class="voiletbtn" >Issue Report</button>

            <?php

            $userloginid=$_SESSION["userid"] = $_GET['userlogid'];
            $u=new data;
            $u->setconnection();
            $u->getissuebook($userloginid);
            $recordset=$u->getissuebook($userloginid);

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;'><tr><th style='  border: 0px solid #ddd;
            padding: 8px;'>Name</th><th>Book Name</th><th>Issue Date</th><th>Return Date</th><th>Fine</th></th><th>Return</th></tr>";

            foreach($recordset as $row){
                $table.="<tr>";
               "<td>$row[0]</td>";
                $table.="<td>$row[2]</td>";
                $table.="<td>$row[3]</td>";
                $table.="<td>$row[6]</td>";
                $table.="<td>$row[7]</td>";
                $table.="<td>$row[8]</td>";
                $table.="<td><a href='otheruser_dashboard.php?returnid=$row[0]&userlogid=$userloginid'><button type='button' class='btn btn-primary'>Return</button></a></td>";
                $table.="</tr>";
                // $table.=$row[0];
            }
            $table.="</table>";

            echo $table;
            ?>

            </div>
            </div>


            <div class="rightinnerdiv">   
            <div id="return" class="innerright portion" style="<?php  if(!empty($_REQUEST['returnid'])){ $returnid=$_REQUEST['returnid'];} else {echo "display:none"; }?>">
            <button class="voiletbtn" >Return Book</button>

            <?php

            $u=new data;
            $u->setconnection();
            $u->returnbook($returnid);
            $recordset=$u->returnbook($returnid);
                ?>

            </div>
            </div>


            <div class="rightinnerdiv">   
            <div id="requestbook" class="innerright portion" style="<?php  if(!empty($_REQUEST['returnid'])){ $returnid=$_REQUEST['returnid'];echo "display:none";} else {echo "display:none"; }?>">
            <button class="voiletbtn" >Request Book</button>

            <?php
            $u=new data;
            $u->setconnection();
            $u->getbookissue();
            $recordset=$u->getbookissue();

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;'><tr>
            <th>Image</th><th>Book Name</th><th>Book Authour</th><th>Branch</th><th>  Price</th></th><th>   Request Book</th></tr>";

            foreach($recordset as $row){
                $table.="<tr>";
               "<td>$row[0]</td>";
               $table.="<td><img src='uploads/$row[1]' width='100px' height='100px' style='border:1px solid #333333;'></td>";
               $table.="<td>$row[2]</td>";
                $table.="<td>$row[4]</td>";
                $table.="<td>$row[6]</td>";
                $table.="<td>$row[7]</td>";
                $table.="<td><a href='requestbook.php?bookid=$row[0]&userid=$userloginid'><button type='button' class='btn btn-primary'>Request Book</button></a></td>";
           
                $table.="</tr>";
                // $table.=$row[0];
            }
            $table.="</table>";

            echo $table;


                ?>

            </div>
            </div>

        </div>
        </div>


        <script>
        function openpart(portion) {
        var i;
        var x = document.getElementsByClassName("portion");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";  
        }
        document.getElementById(portion).style.display = "block";  
        }

   
 
        
        </script>
    </body>
</html>