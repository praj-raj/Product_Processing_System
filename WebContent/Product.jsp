<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
		<title>Big style CSS3 registration form</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
		<style>
			body {
				background-image:url(bg2.jpg);
			}
		</style>
		<style type="text/css">				
			form.registration{
  			  width:600px;
  			  float:left;
  			  color:#818181;
  				background: #f1f1f1 url(pen.png) no-repeat top right;
  				border: 2px solid #ccc;
  				padding:10px;
  				font-family: Georgia;
  				font-size: 14px;
  				-moz-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
  				-webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
  				-moz-border-radius: 15px;
  				-webkit-border-radius: 15px;
			}
			form.registration fieldset{
			    border-top:1px solid #ccc;
			    border-left:0;
			    border-bottom:0;
			    border-right:0;
			    padding:6px;
			    margin:0px 30px 0px 0px;
			}
			form.registration legend{
			    text-align:left;
			    color:#ccc;
			    font-size:18px;
			    padding:0px 4px 0px 4px;
			    margin-left:20px;
			}
			form.registration label{
				  font-size: 32px;
			    width:200px;
			    float: left;
			    text-align: right;
			    color:#999;
			    clear:left;
			    margin:4px 4px 0px 0px;
			    padding:0px;
			}
			form.registration input{
				  font-family: Georgia;
				  font-size: 28px;
			    float:left;
			    width:300px;
			    border:1px solid #cccccc;
			    margin:2px 0px 2px 2px;
			    color:#00abdf;
			    height:32px;
			    padding:3px;
				  -moz-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
				  -webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
				  -webkit-border-radius: 5px;
				  -moz-border-radius: 5px;
			}
			form.registration input:focus, form.registration select:focus{
				  background-color:#E0E6FF;
			}
			form.registration select{
				  font-family: Georgia;
				  font-size: 28px;
			    float:left;
			    border:1px solid #cccccc;
			    margin:2px 0px 2px 2px;
			    color:#00abdf;
				  height:40px;
				  -moz-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
				  -webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
				  -webkit-border-radius: 5px;
				  -moz-border-radius: 5px;
			}
			.button, .button:visited{
				  float:right;
				  text-shadow: 0 -1px 1px rgba(0,0,0,0.25);
				  border-bottom: 1px solid rgba(0,0,0,0.25);
				  cursor: pointer;
				  padding: 5px 10px 5px 5px; 
				  color: #fff; 
				  text-decoration: none;
				  font-size: 32px; padding: 10px 15px; 
				  background-color: #00abdf;
			    display: inline-block; 	
			   	-moz-border-radius: 10px; 
  				-webkit-border-radius: 10px;
  				-moz-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
  				-webkit-box-shadow: 0 1px 3px rgba(0,0,0,0.5);
			}
			.button:hover{ 
				  background-color: #777; 
			}
		</style>
		        <link rel="stylesheet" type="text/css" href="style1.css" />
	</head>
	<body>
	<div class="menu">
			
			<div class="leftmenu">
				<a href="admin.jsp"><h4> Back</h4></a>
			</div>

			<div class="rightmenu">
				<ul>
					<li class="active menu__item menu__item--current"><a class="menu__link" href="admin.jsp">Home <span class="sr-only">(current)</span></a></li>
					
					<li class=" menu__item"><a class="menu__link" href="UserController?action=displayAll">Users</a></li>
					<li class=" menu__item"><a class="menu__link" href="Product.jsp">Add Product</a></li>
				
				</ul>
			</div>

		</div>
		
    <form class="registration" action="UserController" method="post">
    <input type="hidden" name="action" value="insertProduct">
        <fieldset>
            <legend>Product</legend>
            <h1>${msg}</h1>
            <label>Catagery</label>
            <input type="text" maxlength="100" value="" name="catagery"/>                                  
            <label>Name</label>
            <input type="text" maxlength="100" value="" name="name" />           
            
            <label>MRP </label>
           <input type="text"  value="" name="price"/>
           <label>Selling price </label>
            <input type="text" maxlength="100" value="" name="sprice"/>                                  
           <label>Quantity</label>
           <input type="text"  value="" name="quantity"/>
           <label>Image</label>
           <input type="file"  value="" name="image"/>
           
           
                   
        </fieldset>
        
        <fieldset>   
          <input class="button" type="submit" value="ADD Product"/><br/> 
        </fieldset>   
    </form>
	</body>
</html>