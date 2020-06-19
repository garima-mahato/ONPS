<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online National Polling System</title>
<meta name="keywords" content="css templates, fortune website, CSS, HTML" />
<meta name="description" content="Fortune Template is a free css template from templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function showResult()
{
var ed=document.getElementById("t1").value;
var url="showResult.jsp?eid="+ed;

var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    var res=xmlhttp.responseText;
    var res2=res.split(",");
    var s="<table border='1' bgcolor='gray' align='center'>"
    +" <tr><th>Election ID</th><th>Party Name</th><th>Votes secured</th></tr>";
    s=s+"<tr><td>"+res2[0]+"</td><td>"+res2[1]+"</td><td>"+res2[2]+"</td></tr></table>";
    
    document.getElementById("myDiv").innerHTML=s;
    }
  }
xmlhttp.open("GET",url,true);
xmlhttp.send();
}
</script>
</head>
<body>
<div id="templatemo_header_wrapper">
    <div id="templatemo_header_panel">
    <div id="templatemo_header" font-color:"white"> National Online Polling System        </div>
         <div id="templatemo_tagline">
	     (NOPS)  
        </div>
  </div>
</div>

<div id="templatemo_banner_wrapper">
    <div id="templatemo_banner_panel"><img src="image/par.jpg"/>
    </div>
</div>

<div id="templatemo_menu_wrapper">
    <div id="templatemo_menu_panel">
        <ul>
            <li><a href="Home.jsp" class="current">Home</a></li>
            <li><a href="AboutUs.jsp">About Us</a></li>
            <li><a href="FAQ.jsp">FAQ</a></li>
            <li><a href="Gallery.jsp">Gallery</a></li>  
            <li><a href="Contact.jsp">Contact</a></li> 
            <li><a href="Complaints.jsp">Complaints</a></li>                     
        </ul> 
    </div>
</div> <!-- end of menu -->

<div id="templatemo_content_wrapper">
<div id="templatemo_content_panel">
<h3 align="center">View Result</h3>

 Enter Election ID: <input type="text" name="t1" id="t1"><input type="submit" value="Submit" onclick="showResult()">

<div id="myDiv"></div>
    
    
                  
    
<div class="margin_bottom_20"></div>
</div> <!-- end of content panel -->
</div> <!-- end of content wrapper -->

<div id="templatemo_footer_wrapper">
<div id="templatemo_footer_panel">
     <marquee>Jai Hind!!!!</marquee>
    <div class="margin_bottom_20"></div>
   
</div> <!-- end of footer panel -->
</div> <!-- end of footer wrapper-->
<div align=center>@Designed by NP</div>
</body>
</html>