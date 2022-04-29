<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Admin Dashboard</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- <link rel="stylesheet" href="style.css"> -->
    </head>
    <style>
        .innerright,label {
    color: #580c91;
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
    background-color: #590896;
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
    color: #590896;
    text-align: center;
    
}
    </style>
    <body class="xy">

    <?php
   include("data_class.php");

$msg="";

   if(!empty($_REQUEST['msg'])){
    $msg=$_REQUEST['msg'];
 }

if($msg=="done"){
    echo "<div class='alert alert-success' role='alert'>Sucssefully Done</div> ";
}
elseif($msg=="fail"){
    echo "<div class='alert alert-danger' role='alert'>Fail</div>";
}

    ?>



<div class="container">
        <div class="row"><img class="imglogo" src="images/logo.png"/></div>
        <span class="d-block p-2 text-white" style="background-color:#590896; border-radius: 50px;">
            <h4 style="color:White; font-size: 1.5rem; text-align-last: center;  margin-top: 15px; font-family: fangsong;">Admin Panel</h4>
        </span>
        <div class="innerdiv">
            <div class="leftinnerdiv">
                <!-- <button class="voiletbtn"> ADMIN</button> -->
                <button class="voiletbtn" onclick="openpart('addbook')" >ADD BOOK</button>
                <button class="voiletbtn" onclick="openpart('bookreport')" > BOOK REPORT</button>
                <button class="voiletbtn" onclick="openpart('bookrequestapprove')"> BOOK REQUESTS</button>
                <button class="voiletbtn" onclick="openpart('addperson')"> ADD PERSON</button>
                <button class="voiletbtn" onclick="openpart('studentrecord')"> PERSON REPORT</button>
                <button class="voiletbtn"  onclick="openpart('issuebook')"> ISSUE BOOK</button>
                <button class="voiletbtn" onclick="openpart('issuebookreport')"> ISSUE REPORT</button>
                <a href="index.php"><button class="voiletbtn" >LOGOUT</button></a>
            </div>

            <div class="rightinnerdiv">   
            <div id="bookrequestapprove" class="innerright portion" style="display:none">
            <button class="voiletbtn" >BOOK REQUEST APPROVE</button>

            <?php
            $u=new data;
            $u->setconnection();
            $u->requestbookdata();
            $recordset=$u->requestbookdata();

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;'><tr><th style='  border: 0px solid #ddd;
            padding: 8px;'>Person Name</th><th>Person type</th><th>Book name</th><th>Days </th><th>Approve</th></tr>";
            foreach($recordset as $row){
                $table.="<tr>";
                "<td>$row[0]</td>";
                "<td>$row[1]</td>";
                "<td>$row[2]</td>";

                $table.="<td>$row[3]</td>";
                $table.="<td>$row[4]</td>";
                $table.="<td>$row[5]</td>";
                $table.="<td>$row[6]</td>";
                $table.="<td><a href='approvebookrequest.php?reqid=$row[0]&book=$row[5]&userselect=$row[3]&days=$row[6]'><button type='button' class='btn btn-primary'>Approved BOOK</button></a></td>";
                $table.="<td><a href='approvebookrequest.php?reqid=$row[0]&book=$row[5]&userselect=$row[3]&days=$row[6]'>Approved</a></td>";
                $table.="<td><a href='deletebook_dashboard.php?deletebookid=$row[0]'>Delete</a></td>";
                $table.="</tr>";
                // $table.=$row[0];
            }
            $table.="</table>";

            echo $table;
            ?>

            </div>
            </div>

            <div class="rightinnerdiv">   
            <div id="addbook" class="innerright portion" style="<?php  if(!empty($_REQUEST['viewid'])){ echo "display:none";} else {echo ""; }?>">
            <button class="voiletbtn" >ADD NEW BOOK</button>
            <form action="addbookserver_page.php" method="post" enctype="multipart/form-data">
            <label>Book Name:</label><input type="text" name="bookname"/>
            </br>
            <label>Description:</label><input  type="text" name="bookdetail"/></br>
            <label>Autor:</label><input type="text" name="bookaudor"/></br>
            <label>Publication:</label><input type="text" name="bookpub"/></br>
            <div>Branch:<input type="radio" name="branch" value="Commerce"/>Commerce<input type="radio" name="branch" value="Science"/>Science<div style="margin-left:80px"><input type="radio" name="branch" value="IT"/>IT<input type="radio" name="branch" value="Other"/>Other</div>
            </div>   
            <label>Price:</label><input  type="number" name="bookprice"/></br>
            <label>Quantity:</label><input type="number" name="bookquantity"/></br>
            <label>Book Photo</label><input  type="file" name="bookphoto"/></br>
            </br>
            <input type="submit" value="Submit"/>
            </br>
            </br>
            </form>
            </div>
            </div>


            <div class="rightinnerdiv">   
            <div id="addperson" class="innerright portion" style="display:none">
            <button class="voiletbtn" >ADD PERSON</button>
            <form action="addpersonserver_page.php" method="post" enctype="multipart/form-data">
            <label>Name:</label><input type="text" name="addname"/>
            </br>
            <label>Pasword:</label><input type="pasword" name="addpass"/>
            </br>
            <label>Email:</label><input  type="email" name="addemail"/></br>
            <label for="typw">Choose type:</label>
            <select name="type" >
                <option value="student">Student</option>
                <option value="teacher">Teacher</option>
            </select>

            <input type="submit" value="SUBMIT"/>
            </form>
            </div>
            </div>

            <div class="rightinnerdiv">   
            <div id="studentrecord" class="innerright portion" style="display:none">
            <button class="voiletbtn" >PERSON RECORD</button>

            <?php
            $u=new data;
            $u->setconnection();
            $u->userdata();
            $recordset=$u->userdata();

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse; width: 100%;'><tr><th style='  border: 0px solid #ddd;
            padding: 8px;'> Name</th><th>Email</th><th>Type</th></tr>";
            foreach($recordset as $row){
                $table.="<tr>";
                "<td>$row[0]</td>";
                $table.="<td>$row[1]</td>";
                $table.="<td>$row[2]</td>";
                $table.="<td>$row[4]</td>";
                $table.="<td><a href='deleteuser.php?useriddelete=$row[0]' style='color:white;'><button type='button' class='btn btn-danger'>Delete</a></button></td>";
                $table.="</tr>";
                // $table.=$row[0];
            }
            $table.="</table>";

            echo $table;
            ?>

            </div>
            </div>

            <div class="rightinnerdiv">   
            <div id="issuebookreport" class="innerright portion" style="display:none">
            <button class="voiletbtn" >Issue Book Record</button>

            <?php
            $u=new data;
            $u->setconnection();
            $u->issuereport();
            $recordset=$u->issuereport();

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;'><tr><th style='  border: 0px solid #ddd;
            padding: 8px;'>Issue Name</th><th>Book Name</th><th>Issue Date</th><th>Return Date</th><th>Fine</th></th><th>Issue Type</th></tr>";

            foreach($recordset as $row){
                $table.="<tr>";
                "<td>$row[0]</td>";
                $table.="<td>$row[2]</td>";
                $table.="<td>$row[3]</td>";
                $table.="<td>$row[6]</td>";
                $table.="<td>$row[7]</td>";
                $table.="<td>$row[8]</td>";
                $table.="<td>$row[4]</td>";
                // $table.="<td><a href='otheruser_dashboard.php?returnid=$row[0]&userlogid=$userloginid'>Return</a></td>";
                $table.="</tr>";
                // $table.=$row[0];
            }
            $table.="</table>";

            echo $table;
            ?>

            </div>
            </div>

<!--             

issue book -->
            <div class="rightinnerdiv">   
            <div id="issuebook" class="innerright portion" style="display:none">
            <button class="voiletbtn" >ISSUE BOOK</button>
            <form action="issuebook_server.php" method="post" enctype="multipart/form-data">
            <label for="book">Choose Book:</label>
            <select name="book" >
            <?php
            $u=new data;
            $u->setconnection();
            $u->getbookissue();
            $recordset=$u->getbookissue();
            foreach($recordset as $row){

                echo "<option value='". $row[2] ."'>" .$row[2] ."</option>";
            }            
            ?>
            </select>

            <label for="Select Student">Select Person:</label>
            <select name="userselect" >
            <?php
            $u=new data;
            $u->setconnection();
            $u->userdata();
            $recordset=$u->userdata();
            foreach($recordset as $row){
                $id= $row[0];
                echo "<option value='". $row[1] ."'>" .$row[1] ."</option>";
            }            
            ?>
            </select>
<br>
            Days<input type="number" name="days"/>
            <input type="submit" value="Submit"/>
            </form>
            </div>
            </div>

            <div class="rightinnerdiv">   
            <div id="bookdetail" class="innerright portion" style="<?php  if(!empty($_REQUEST['viewid'])){ $viewid=$_REQUEST['viewid'];} else {echo "display:none"; }?>">
            
            <button class="voiletbtn" >BOOK DETAIL</button>
</br>
<?php
            $u=new data;
            $u->setconnection();
            $u->getbookdetail($viewid);
            $recordset=$u->getbookdetail($viewid);
            foreach($recordset as $row){

                $bookid= $row[0];
                $bookimg= $row[1];
                $bookname= $row[2];
                $bookdetail= $row[3];
                $bookauthour= $row[4];
                $bookpub= $row[5];
                $branch= $row[6];
                $bookprice= $row[7];
                $bookquantity= $row[8];
                $bookava= $row[9];
                $bookrent= $row[10];

            }            
?>

            <img style='border:1px solid #333333; float:left;margin-left:20px; height: 350px; width: 250px;' src="uploads/<?php echo $bookimg?> "/>
            </br>
            <form>
                <p style="color:black; text-align: center;"><strong>Book Name:</strong> &nbsp&nbsp<?php echo $bookname ?></p>
                <p style="color:black; text-align: center;"><strong>Book Detail:</strong> &nbsp&nbsp<?php echo $bookdetail ?></p>
                <p style="color:black; text-align: center;"><strong>Book Authour:</strong> &nbsp&nbsp<?php echo $bookauthour ?></p>
                <p style="color:black; text-align: center;"><strong>Book Publisher:</strong> &nbsp&nbsp<?php echo $bookpub ?></p>
                <p style="color:black; text-align: center;"><strong>Book Branch:</strong> &nbsp&nbsp<?php echo $branch ?></p>
                <p style="color:black; text-align: center;"><strong>Book Price:</strong> &nbsp&nbsp<?php echo $bookprice ?></p>
                <p style="color:black; text-align: center;"><strong>Book Available:</strong> &nbsp&nbsp<?php echo $bookava ?></p>
                <p style="color:black; text-align: center;"><strong>Book Rent:</strong> &nbsp&nbsp<?php echo $bookrent ?></p>
            </form>


            </div>
            </div>



            <div class="rightinnerdiv">   
            <div id="bookreport" class="innerright portion" style="display:none">
            <button class="voiletbtn" >BOOK REPORT</button>
            <?php
            $u=new data;
            $u->setconnection();
            $u->getbook();
            $recordset=$u->getbook();

            $table="<table style='font-family: Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;'><tr><th style='  border: 0px solid #ddd;
            padding: 8px;'>Book Name</th><th>Price</th><th>Qt</th><th>Available</th><th>Rent</th></th><th>View</th></tr>";
            foreach($recordset as $row){
                $table.="<tr>";
                "<td>$row[0]</td>";
                $table.="<td>$row[2]</td>";
                $table.="<td>$row[7]</td>";
                $table.="<td>$row[8]</td>";
                $table.="<td>$row[9]</td>";
                $table.="<td>$row[10]</td>";
                $table.="<td><a href='admin_service_dashboard.php?viewid=$row[0]'><button type='button' class='btn btn-primary'>View Book</button></a></td>";
                $table.="<td><a href='deletebook_dashboard.php?deletebookid=$row[0]' style='color:white;' ><button type='button' class='btn btn-danger'>Delete</a></button></td>";
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