//修改数量
function changeCount(method, remain){
    var countBox = $("#roomCount");
    if (method === 0){
        countBox.val(Math.max.call(0, parseInt(countBox.val()) - 1));
    }
    else if (method === 1){
        countBox.val(Math.min.call(remain, parseInt(countBox.val()) + 1));
    }
    updateTotal();

}
//更新总价
function updateTotal(){
    var priceBox = $("#price");//单价
    var roomCountBox = $("#roomCount");//房间数
    var checkInBox = $("#checkIn");//入住时间
    var checkOutBox = $("#checkOut");//离店时间
    var daysDiff = Math.floor(Math.abs(Date.parse(checkOutBox.val()) - Date.parse(checkInBox.val())) / (24 * 3600 * 1000));//天数
    var priceValue = (priceBox.text() * roomCountBox.val() * daysDiff).toString();//总价
    var totalBox = $("#total");//总价栏
    //输入框中的份额数与每份金额数相乘得到总金额
    totalBox.text(priceValue + "(入住" + daysDiff + "天)");
    if(roomCountBox.val() <= 0){//如果房间数小于等于0，也就是出错情况，默认制空
        totalBox.text(0);
    }
}
//提交订单
function submitOrder() {
    const hotelId = parseInt($('#hotelId').val());
    const roomId = parseInt($('#roomId').val());
    const userId = parseInt($('#userId').val());
    const price = parseFloat($("#price").text());//单价
    const roomCount = $("#roomCount").val();//房间数
    const checkIn = Date.parse($("#checkIn").val());
    const checkOut = Date.parse($("#checkOut").val());
    const daysDiff = Math.floor(Math.abs(checkOut - checkIn) / (24 * 3600 * 1000));
    const total = price * roomCount * daysDiff;//总价
    $.ajax({
        url: "/book/submit",
        type: "post",
        data: JSON.stringify({
            'hotelId': hotelId,
            'rooms': [{
                'roomId' : roomId,
                'hotelId' : hotelId,
                'roomCount': roomCount,
                'roomPrice' : price,
            }],
            'userId': userId,
            'checkIn': checkIn,
            'checkOut': checkOut,
            'days': daysDiff,
            'total': total,
        }), //json数据格式的用户名从jsp传递给controller
        dataType: "json",
        contentType: "application/json", //修改contentType，使@RequestParam可以接收数据。
        async: false, //让ajax执行代码顺序同步
        success: function (response) {
            //done
            console.log(response);
            alert("success");
            window.location.href = "order/" + response.data
            return response
        },
        error: function (response) {
            console.log(response);
            alert("test:");
            return response
        },
    });

}