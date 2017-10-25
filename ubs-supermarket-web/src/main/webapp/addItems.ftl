<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://unpkg.com/vue"></script>

    <style>
       th, td { padding: 15px; text-align: left; }
       th { height: 50px; }
       input { margin: 20px}
    </style>
</head>

<body>
<div id="links" style="float:float-left">
    <ul>
        <#list links?keys as link>
            <li><a href="${links[link]}">${link}</a></li>
        </#list>
    </ul>
</div>
<div style="clear: left"></div>

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

<div id="form" style="margin: 30px; float: left">
    <h2>Add Items</h2>

    <label for="item"> Item: </label> <input type="text" id="item" /> <br/>
    <label for="sku"> SKU: </label> <input id="sku" type="text"/> <br/>
    <label for="price"> Price: </label> <input id="price" type="text"/> <br/>
    <label for="buyAmount">Buy Amount: </label> <input id="buyAmount" type="text"/> <br/>
    <label for="discountPrice">Discount Price: </label> <input id="discountPrice" type="text"/> <br/>

    <input type="button" id="submit" value="Submit"/>

</div>
<div>
    <h2>Delete Item</h2>
    <label for="deleteText">SKU: </label> <input type="text" id="deleteText"/>
    <input type="button" id="deleteButton" value="Delete"/>
</div>
<div id="response">
    <template v-if="message.success">

    </template>
    <template v-else>
        <p>Error</p>
        <p>reason: {{message.message}}</p>
    </template>
</div>
<script>
    var itemVue = new Vue({
        el: '#allItems',
        data: {
            items: {}
        }
    });
    $(document).ready(function() {
     loadItems();
 });

 var responseVue = new Vue({
        el: '#response',
        data: {
            message: { success: true,
                        message: 'none'
            }
        }
    });
    $(document).ready(function() {
     loadItems();
 });

 function loadItems() {
 $.ajax({
            type: 'get',
            url: '/checkout/items',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            success: function (data) {
                setItems(data);
            }
        });
 }

function setItems(data) {
    itemVue.items = data;
 }

 $('#submit').click(function() {
    var itemName = $('#item').val();
    var sku = $('#sku').val();
    var price = $('#price').val();
    var buyAmount = $('#buyAmount').val();
    var discountPrice = $('#discountPrice').val();

    if(itemName === 'undefined' || sku === 'undefined' || price === 'undefined') {
        alert('Item, SKU, and Price must be filled in');
        return;
    }

    var item = {};
    item.price = price;
    item.sku = sku;
    item.item = itemName;

    if(buyAmount !== '' || discountPrice !== '') {
        if(buyAmount === '' || discountPrice === '' ) {
            alert('if setting buy amount or discount price, both must be set');
            return;
        }

        item.discountPrice = discountPrice;
        item.buyAmount = buyAmount;
    }
        sendItem(item);
 });

 function sendItem(item) {
    $.ajax({
            type: 'post',
            url: '/addItem',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            data: JSON.stringify(item),
            success: function (data) {
                loadItems();
                setResponse(data);
            }
    });
 }

 function setResponse(data) {
    responseVue.message = data;
 }

 $('#deleteButton').click(function() {
    var sku = $('#deleteText').val();
     $.ajax({
            type: 'post',
            url: '/deleteItem',
            contentType: "application/json; charset=utf-8",
            traditional: true,
            data: sku,
            success: function (data) {
                loadItems();
                setResponse(data);
            }
    });
 });

</script>
</body>
</html>