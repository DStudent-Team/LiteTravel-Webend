// 前台修改用户信息
function modifyInfo () {
    const userId = parseInt($('#userId').val());
    const username = $('#username').val();
    const gender = parseInt($('input:radio[name="gender"]:checked').val());
    const birth = $('#birth').val();
    const phone = parseInt($('#phone').val());
    const email = $('#email').val();
    const address = $('#address').val();
    console.log(gender);
    console.log(userId);
    console.log(username);
    console.log(email);
    $.ajax({
        url: "/user/modify",
        type: "post",
        data: JSON.stringify({
            'userId': userId,
            'userName': username,
            'userGender': gender,
            'userBirth': birth,
            'userPhone': phone,
            'userEmail': email,
            'userAddressSpecific': address,
        }),
        dataType: "html",
        contentType: "application/json",
        async: false,
        success: function (response) {
            console.log(response)
            alert("修改成功！");
            window.location.reload();
        },
        error: function (response) {
            console.log(response);
            alert("error");
            return response;
        }
    });

}

/*后台用户管理脚本
* */

// 后台删除用户提示框确认
function deleteByUserId (userId) {
    $('#deleteId').val(userId);
    console.log(userId);
}

// 暂时没办法了，只能用这种办法传。。
/**接收参数
 * #userId  对应  输入框的id=“userId“
 * val("userId")表示把输入框的value值设置为userId 用于编辑
 * 传值到模态框
 * @param userId
 * @param userCode
 * @param userPassword
 * @param userName
 * @param userBirth
 * @param userEmail
 * @param userPhone
 * @param userAddressSpecific
 * @param userState
 */
function editUser (userId, userCode, userPassword,
                   userName, userBirth, userEmail,
                   userPhone, userAddressSpecific, userState){
    // $('#myModal').modal("hide");
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
    //向模态框中传值
    $('#userId').val(userId);
    $('#userCode').val(userCode);
    $('#userPassword').val(userPassword);
    $('#userName').val(userName);
    $('#userEmail').val(userEmail);
    $('#userPhone').val(userPhone);
    $('#userAddressSpecific').val(userAddressSpecific);
    $('#userState').val(userState);
    $('#putMethod').removeAttr("disabled");
    console.log(userId)
}

// 用户权限
function setAuthority(userId, userName){
    $('#authorityUserId').val(userId);
    $('#authorityUserName').val(userName);
}

/*清除输入框的内容  #userId  对应  输入框的id=“userId“
*    val(" ")表示把输入框的value值置空
*
* */
function clearUser(){
    $('#userId').val("");
    $('#userCode').val("");
    $('#userPassword').val("");
    $('#userName').val("");
    $('#userEmail').val("");
    $('#userPhone').val("");
    $('#userAddressSpecific').val("");
    $('#userState').attr("disabled",true);
    // $('#putMethod').val("");


}

/*判断输入框输入是否为空
* 为空则提示框变红
* */
function checkValid(){
    //	userCode, userPassword, userName
    console.log("TEst");

    const flagCode = !checkBlank($("#userCode").val());
    if(flagCode === false){
        $("#userCode").css('borderColor','red');
    }else {
        $("#userCode").css('borderColor','#ced4da')
    }
    const flagPassword = !checkBlank($("#userPassword").val());
    if(flagPassword === false){
        $("#userPassword").css('borderColor','red');
    }else {
        $("#userPassword").css('borderColor','#ced4da')
    }
    const flagName = !checkBlank($("#userName").val());
    if(flagName === false){
        $("#userName").css('borderColor','red');
    }else {
        $("#userName").css('borderColor','#ced4da')
    }
    if (flagCode && flagPassword && flagName){
        return true;
    }
    else{
        alert("账户名，用户名，密码均不能为空")
        return false;
    }

}

/*后台blog管理脚本
* */
// 删除blog
function deleteByBlogId (blogId) {
    $("#deleteBlogId").val(blogId);
    console.log(blogId);
}

//检查数据是否为空或者为空格
function checkBlank(value){
    return value === null || value.toString().trim().length === 0;
}




// 后台机票
// 获取页面页面信息到模态框
function getFlightMessage(flightId, companyId, seats, level, from, to, depart, arrived) {
    $("#flightId").val(flightId);
    $("#companyId").val(companyId);
    $("#toSeats").val(seats);
    $("#flightDepart").val(depart);
    $("#flightArrived").val(arrived);
    document.getElementById('flightFrom').innerHTML=from;
    document.getElementById('flightTo').innerHTML=to;
    document.getElementById('Depart').innerHTML=depart;
    document.getElementById('arrived').innerHTML=arrived;
    document.getElementById('seats').innerHTML=seats;
    document.getElementById('level').innerHTML=level;
    createTicketList(seats);


}

// 机票服务post提交
function submitReserve () {
    const flightId = parseInt($('#flightId').val());
    const companyId = parseInt($('#companyId').val());
    const service = $('#service').val();

    let $tbody = document.getElementById("ticketTbody");
    let tickets = $tbody.getElementsByTagName("tr");
    let ticketJson = [];

    for (let i = 0; i < tickets.length; i++) {
        /* name*="xx" 表示获取所有包含name="xx"的dom */
        let ticketSeat = $('input[name*="ticketSeat"]')[i].value;
        let ticketPrice = $("input[name*='ticketPrice']")[i].value;
        ticketJson.push({"ticketSeat":ticketSeat, "ticketPrice":ticketPrice});
    }

    console.log("test");
    $.ajax({
        type: "POST",
        url: "/manage/reserve",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            'flightId': flightId,
            'companyId': companyId,
            'service': service,
            'flightTickets': ticketJson,
        }),
        success: function (response) {
            console.log(response);
            alert("添加成功！");
            window.location.reload();
        },
        error: function (response) {
            console.log(response);
            alert("error");
            return response;
        }
    });
}
// 删除机票预约
function deleteFlight (flightId) {
    $("#deleteFlightId").val(flightId);
    console.log(flightId);
}


//生成机票的座位和票价的输入框
function createTicketList(seats) {
    let $tbody = document.getElementById("ticketTbody");
    let $ticket;
    // console.log('去你的！'+seats);
    for (let i = 0; i < seats; i++) {
        $ticket = document.createElement("tr");
        const seat = document.createElement("td");
        const price = document.createElement("td");
        createInput('ticketSeat'+i, 'text', "", seat);
        createInput('ticketPrice'+i, 'number', "", price);
        $ticket.appendChild(seat);
        $ticket.appendChild(price);
        $tbody.appendChild($ticket);
    }
}

function clearTicketList(){
    $("#ticketTbody").empty();
}

function createInput(inputName, inputType, inputValue, aDiv) {
    let input = document.createElement("input");
    input.setAttribute("type",inputType) ;
    input.setAttribute("name",inputName) ;
    input.setAttribute("value", inputValue) ;
    // input.setAttribute("id", inputId) ;

    aDiv.appendChild(input);
}

/*机票服务脚本*/
function deleteReserve (reserveId, flightId){
    $("#deleteReserveId").val(reserveId);
    $("#reserveFlightId").val(flightId);
}

function editReserve(reserveId, total, service) {
    $("#reserveId").val(reserveId);
    $("#total").val(total);
    $("#_service").val(service);
}
function clearReserve() {
    $("#reserveId").val('');
    $("#total").val('');
    $("#_service").val('');
}

/**
 * 酒店前端数据管理层
 * 创建点击事件，点击更新将数据提交给输入框对应值
 * @param hotelId
 * @param hotelName
 * @param hotelMinPrice
 * @param userId
 * @param userName
 * @param hotelPhone
 * @param hotelReplyLevel
 * @param hotelAddress
 * @param hotelAddressSpecific
 * @param hotelDescription
 */
//模态框赋值，用于更新数据时
function editHotel (hotelId, hotelName, hotelMinPrice,
                    hotelPhone, userId, userName,hotelReplyLevel,
                    hotelAddress, hotelAddressSpecific, hotelDescription){
    // $('#myModal').modal("hide");
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
    //向模态框中传值
    $('#hotelId').val(hotelId);
    $('#hotelName').val(hotelName);
    $('#hotelMinPrice').val(hotelMinPrice);
    $('#hotelManagerId').val(userId);
    $('#hotelManagerName').val(userName);
    $('#hotelPhone').val(hotelPhone);
    $('#hotelReplyLevel').val(hotelReplyLevel);
    $('#hotelAddress').val(hotelAddress);
    $('#hotelAddressSpecific').val(hotelAddressSpecific);
    $('#hotelDescription').val(hotelDescription);
}

//模态框置空，用于插入数据和点击清空模态框时
function clearHotel (userId, userName){
    // 置空模态框
    $('#hotelId').val('');
    $('#hotelName').val('');
    $('#hotelMinPrice').val('');
    $('#hotelManagerId').val(userId);
    $('#hotelManagerIdTrue').val(userId);
    $('#hotelManagerName').val(userName);
    $('#hotelPhone').val('');
    $('#hotelReplyLevel').val('');
    $('#hotelAddress').val('');
    $('#hotelAddressSpecific').val('');
    $('#hotelDescription').val('');
}

//检测输入的酒店数据是否合法
function checkHotelData() {

}

//用户订单评价模态框赋值
function setOrderComment(userId, hotelId, orderId){
    $('#ocUserId').val(userId);
    $('#ocHotelId').val(hotelId);
    $('#ocOrderId').val(orderId);
}
function clearOrderComment(){
    $('#ocUserId').val('');
    $('#ocHotelId').val('');
    $('#ocOrderId').val('');
}


/**
 * 酒店前端数据管理层
 * 创建点击事件，点击更新将数据提交给输入框对应值
 * @param hotelId
 * @param hotelName
 * @param hotelMinPrice
 * @param hotelManagerId
 * @param hotelPhone
 * @param hotelReplyLevel
 * @param hotelAddress
 * @param hotelAddressSpecific
 * @param hotelDescription
 */
//模态框赋值，用于更新数据时
function editHotel (hotelId, hotelName, hotelMinPrice,
                    hotelManagerId, hotelPhone, hotelReplyLevel,
                    hotelAddress, hotelAddressSpecific, hotelDescription){
    // $('#myModal').modal("hide");
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
    //向模态框中传值
    $('#hotelId').val(hotelId);
    $('#hotelName').val(hotelName);
    $('#hotelMinPrice').val(hotelMinPrice);
    $('#hotelManagerId').val(hotelManagerId);
    $('#hotelPhone').val(hotelPhone);
    $('#hotelReplyLevel').val(hotelReplyLevel);
    $('#hotelAddress').val(hotelAddress);
    $('#hotelAddressSpecific').val(hotelAddressSpecific);
    $('#hotelDescription').val(hotelDescription);
}

//模态框置空，用于插入数据和点击清空模态框时
function clearHotel (){
    // 置空模态框
    $('#hotelId').val('');
    $('#hotelName').val('');
    $('#hotelMinPrice').val('');
    $('#hotelManagerId').val('');
    $('#hotelPhone').val('');
    $('#hotelReplyLevel').val('');
    $('#hotelAddress').val('');
    $('#hotelAddressSpecific').val('');
    $('#hotelDescription').val('');
}

//检测输入的酒店数据是否合法
function checkHotelData() {

}

/*酒店房间增加修改管理*/
//模态框置空，用于插入数据和点击清空模态框时
function clearRoom (){
    // 置空模态框
    $('#roomId').val('');
    $('#roomName').val('');
    $('#roomPrice').val('');
    $('#roomRemaining').val('');
    $('#roomMax').val('');
    $('#roomBookMax').val('');
    $('#roomCancel').val('');
    $('#roomSize').val('');
    $('#roomWifi').val('');
    $('#roomBedAdd').val('');
    $('#roomDescription').val('');
}

//模态框赋值，用于更新数据时
function editRoom (roomId,roomName, roomPrice,
                    roomRemaining, roomMax,roomBookMax, roomCancel,
                    roomSize, roomWifi,roomBedAdd,roomDescription){
    // $('#myModal').modal("hide");
    $("#myModalLabel").text("新增");
    $('#myModal').modal();
    //向模态框中传值
    $('#roomId').val(roomId);
    $('#roomName').val(roomName);
    $('#roomPrice').val(roomPrice);
    $('#roomRemaining').val(roomRemaining);
    $('#roomMax').val(roomMax);
    $('#roomBookMax').val(roomBookMax);
    $('#roomCancel').val(roomCancel);
    $('#roomSize').val(roomSize);
    $('#roomWifi').val(roomWifi);
    $('#roomBedAdd').val(roomBedAdd);
    $('#roomDescription').val(roomDescription);
}

function transferRoomId(roomId) {
    $('room_Id').val(roomId);
}
