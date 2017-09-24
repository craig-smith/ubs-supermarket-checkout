<html xmlns:th="http://www.springframework.org/schema/mvc">
<head>
    <title>UBS-SUPERMARKET-CHECKOUT</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/vue"></script>
</head>

<body>
<h1>UBS-SUPERMARKET-CHECKOUT</h1>
<h2>--Usage--</h2>
<p>Navigate to the link Checkout to access demo of Supermarket Checkout</p>

<div id="links" style="float:float-left">
   <ul>
       <#list links?keys as link>
           <li><a href="${links[link]}">${link}</a></li>
       </#list>
   </ul>
</div>
<div style="clear: left"></div>

</body>
</html>