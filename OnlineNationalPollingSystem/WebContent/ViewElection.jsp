<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.sql.ResultSet"%>
<%@page import="pollingPack.Candidate"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Online National Polling System</title>
<meta name="keywords" content="css templates, fortune website, CSS, HTML" />
<meta name="description" content="Fortune Template is a free css template from templatemo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function consWise()
{
var d="<form action='getDates.jsp'><table><tr><td>Enter Constitute</td><td><select name='t1' ><option value='Select'>Select</option><option value='1'>1</option>"+
"<option value='12'>12</option></select></td></tr>"+
"<tr><td>Enter District</td><td><select name='t2'><option value='Select'>Select</option><option value='Gandhinagar'>Gandhinagar</option>"+
"<option value='Midnapur'>Midnapur</option></select></td></tr>"+
"<tr><td>Enter State</td><td><select name='t3'><option value='Select'>Select</option><option value='Gujarat'>Gujarat</option>"+
"<option value='Jharkhand'>Jharkhand</option></select></td></tr>"+
"<tr><td>Enter Country</td><td><select name='t4'><option value='Select'>Select</option><option value='India'>India</option>"+
"<option value='Bangladesh'>Bangladesh</option></select></td></tr><tr><td></td><td><input type='submit' name='bt1' value='Constitute Wise Search'></td></tr></table></form>";
document.getElementById("ds").innerHTML=d;


}
function distWise()
{
var d="<form action='getDates.jsp'><table>"+"<tr><td>Enter District</td><td><select name='t1'><option value='Select'>Select</option><option value='Gandhinagar'>Gandhinagar</option>"+
"<option value='Midnapur'>Midnapur</option></select></td></tr>"+
"<tr><td>Enter State</td><td><select name='t2'><option value='Select'>Select</option><option value='Gujarat'>Gujarat</option>"+
"<option value='Jharkhand'>Jharkhand</option></select></td></tr>"+
"<tr><td>Enter Country</td><td><select name='t3'><option value='Select'>Select</option><option value='India'>India</option>"+
"<option value='Bangladesh'>Bangladesh</option></select></td></tr><tr><td></td><td><input type='submit' name='bt1' value='District Wise Search'></td></tr></table></form>";
document.getElementById("ds").innerHTML=d;


}
function stateWise()
{
var d="<form action='getDates.jsp'><table>"+
"<tr><td>Enter State</td><td><select name='t1'><option value='Select'>Select</option><option value='Gujarat'>Gujarat</option>"+
"<option value='Jharkhand'>Jharkhand</option></select></td></tr>"+
"<tr><td>Enter Country</td><td><select name='t2'><option value='Select'>Select</option><option value='India'>India</option>"+
"<option value='Bangladesh'>Bangladesh</option></select></td></tr><tr><td></td><td><input type='submit' name='bt1' value='State Wise Search'></td></tr></table></form>";
document.getElementById("ds").innerHTML=d;

}
function countryWise()
{
var d="<form action='getDates.jsp'><table>"+
"<tr><td>Enter Country</td><td><select name='t1'><option value='Select'>Select</option><option value='India'>India</option>"+
"<option value='Bangladesh'>Bangladesh</option></select></td></tr><tr><td></td><td><input type='submit' name='bt1' value='Country Wise Search'></td></tr></table></form>";
document.getElementById("ds").innerHTML=d;

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

    <div class="content_panel_3col_section margin_right_60">

        <div class="header_01"></div>
        <div class="image_box_01"><img src="image/m.jpg" alt="Web Template" /></div>
        <div class="p_section"></div>
        
    
    </div>
    
    <div class="content_panel_3col_section margin_right_60">
        <div class="header_01" style="text-align:center"><h4>View Election Date</h4></div>
        <ul class="services">   
<form action="UploadCommProfServ" method="post" enctype="multipart/form-data">

<div id="eDate" align="center">
<button onclick="consWise()" style="background-color:buttonhighlight;color:buttontext">Constitute wise</button>
<button onclick="distWise()" style="background-color:buttonhighlight;color:buttontext">District wise</button>
<button onclick="stateWise()" style="background-color:buttonhighlight;color:buttontext">State wise</button>
<button onclick="countryWise()" style="background-color:buttonhighlight;color:buttontext">Country wise</button>
</div>
<div id="ds">

        
    </div>
    </form>
    <div class="content_panel_3col_section">
        <div class="header_01"></div>
        
        <div class="news_section">
            
      </div>
        <div class="margin_bottom_30"></div>
    
        <div class="news_section">
            <div class="news_content">
                <div class="news_title"></div>
                
                
            </div>
        </div>
    
    	<div class="margin_bottom_30"></div>
    
        <div class="news_section">
            <div class="news_content">
                <div class="news_title"></div>
                	</div>
    	</div>
    </div>                
    
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
