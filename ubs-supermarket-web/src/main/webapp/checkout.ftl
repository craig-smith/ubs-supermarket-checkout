<html>
<head>
    <title>UBS-SUPERMARKET-CHECKOUT</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/vue"></script>

    <style>
       th, td { padding: 15px; text-align: left; }
        th { height: 50px; }
    </style>

</head>

<body>
<h1>UBS-SUPERMARKET-CHECKOUT</h1>


<div id="links" style="float:float-left">
    <ul>
        <#list links?keys as link>
            <li><a href="${links[link]}">${link}</a></li>
        </#list>
    </ul>
</div>
<div style="clear:right"></div>
<div id="allItems" style="float:left; padding-left: 40px; margin-left:40px; border:solid">
    <table>
        <tr>
            <th>Item Name</th>
            <th>Item SKU</th>
            <th>Item Price</th>
            <th>Item Buy Amount</th>
            <th>Item Discount Price</th>
        </tr>
        <tr v-for="item in items" :id="item.sku">
            <td class="item">{{item.item}}</td>
            <td class="sku">{{item.sku}}</td>
            <td class="price">{{item.price}}</td>
            <td>{{item.buyAmount}}</td>
            <td>{{item.discountPrice}}</td>
        </tr>
    </table>
</div>

<div id="cart" style="border:solid; margin:30px; float:left; padding: 30px">
    <h2>Cart</h2>
    <table>
        <tr>
            <th>Item Name</th>
            <th>Item SKU</th>
            <th>Item Single Price</th>
            <th>Count</th>
            <th>Total for Item</th>
        </tr>
        <tr v-for="item in cartItems">
            <td>{{item.name}}</td>
            <td>{{item.sku}}</td>
            <td>{{item.price}}</td>
            <td>{{item.count}}</td>
            <td>{{item.total}}</td>
        </tr>
    </table>
    <h3>Cart Total: {{total}}</h3>
    <input id="skuText" type="text" value="SKU"/>
    <input id="addItem" type="button" value="Add Item"/>

    <input id="reset" type="button" value="Reset Cart"/>
</div>


<script>
    $(document).ready(function() {
        sendResetRequest();
    });
    var itemVue = new Vue({
        el: '#allItems',
        data: {
            items: {}
        }
    });

    $(document).ready(function() {
     $.ajax({
            type: 'get',
            url: '/checkout/items',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                setItems(data);
            }
        });
 });

 function setItems(data) {
    itemVue.items = data;
 }

 var cart = new Vue({
    el: '#cart',
    data: {
        cartItems: [],
        total: 0
    }
 });

 $('#addItem').click(function() {
    var sku = $('#skuText').val();
    currentItem = $('#' + sku)
    $.ajax({
            type: 'post',
            url: '/checkout/addItem',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            data: sku,
            success: function (data) {
                addToCart(data);
            }
    });


 });

 function getCheckoutTotal(){
 $.ajax({
            type: 'get',
            url: '/checkout/total',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                addTotalToCart(data);
            }
    });
 }
 function addToCart(data) {
    var name = currentItem.find('.item').html();
    var sku = currentItem.find('.sku').html();
    var price = data
    var cartItem = {
        'name': name,
        'price': price,
        'sku': sku,
        'total': '',
        'count': 1
    };

    var existingItem = $.grep(cart.cartItems, function(e){return e.sku == sku;});
    if(existingItem.length == 1) {
        existingItem[0].count ++;
        getTotalForItem(sku, existingItem[0]);
    } else {
     getTotalForItem(sku, cartItem);
     cart.cartItems.push(cartItem);
    }
       getCheckoutTotal();
 }

 function getTotalForItem(sku, cartItem){
       $.ajax({
            type: 'post',
            url: '/checkout/totalforitem',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            data: sku,
            success: function (data) {
                getPrice(data, cartItem);
            }
        });
 }

 function addTotalToCart(data) {
    cart.total = data;
 }

 function getPrice(data, cartItem) {
    cartItem.total = data;
 }

 $('#reset').click(function() {
    sendResetRequest();
 });
 function sendResetRequest() {
  $.ajax({
            type: 'get',
            url: '/checkout/reset',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                resetCart();
            }
        });
 }


 function resetCart() {
    cart.cartItems = [];
    cart.total = 0;
 }
    </script>
</body>
</html>