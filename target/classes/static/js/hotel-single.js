function bookRoom(roomId) {
    var checkIn = $('#checkIn').val();
    var checkOut = $('#checkOut').val();
    checkIn = new Date(Date.parse(checkIn.replace(/-/g, "/")));
    checkOut = new Date(Date.parse(checkOut.replace(/-/g, "/")));
    if(checkIn.length === 0 || checkOut.length === 0){
        checkOut.setTime(checkOut.getTime() + 24 * 60 * 60 * 1000);
    }
    var days = (checkOut - checkIn) / (1000 * 60 * 60 * 24);
    console.log('Days diff: ' + days);
    if(days <= 0){
        alert("输入的时间不正确!");
        return;
    }
    var hotelId = $('#hotelId').val();
    var userId = $('#userId').val();
    var travelers = document.getElementById('travelers').value;
    var children = document.getElementById('children').value;
    var price = $('#price').val();
    $.ajax({
        url: "/book",
        type: "post",
        data: JSON.stringify({
            'hotelId' : parseInt(hotelId),
            'roomId' : parseInt(roomId),
            'userId' : parseInt(userId),
            'checkIn' : checkIn,
            'checkOut' : checkOut,
            'travelers' : parseInt(travelers),
            'children' : parseInt(children),
            'days' : days,
            'price' : parseFloat(price),
        }), //json数据格式的用户名从jsp传递给controller
        dataType: "html",
        contentType: "application/json", //修改contentType，使@RequestParam可以接收数据。
        async: false, //让ajax执行代码顺序同步
        done: function(response)
        {
            //done

        },
        error:function (response) {
            console.log("errorMsg : " + response.toString());
            alert(response);
        }
    });
    
}