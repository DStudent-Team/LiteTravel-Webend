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
    $('#userBirth').val(userBirth);
    $('#userEmail').val(userEmail);
    $('#userPhone').val(userPhone);
    $('#userAddressSpecific').val(userAddressSpecific);
    $('#userState').val(userState);
    $('#putMethod').removeAttr("disabled");
    console.log(userId)
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
    $('#userBirth').val("");
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
    return value === null || value.toString().trim().length === 0
}

// 后台机票
function getFlightMessage(flightId) {
//    post获取信息
}

function submitReserve() {
    let tickets = $(this).find("ul[name='ticket']");
    var ticketJson = [];
    for (let i = 0; i < tickets.length; i++) {
        var ticketSeat = tickets[i].find("li[name='ticketSeat']");
        var ticketPrice = tickets[i].find("li[name='ticketPrice']");
        ticketJson.push({"ticketSeat":ticketSeat, "ticketPrice":ticketPrice});
    }


    $.ajax({
        data: {
            "flightId": 1,
            "companyId": 1,
            "service": "test",
            "tickets": ticketJson,
        }
    });
}

function createTicketList(seats) {
    let $tbody = $('#ticketTbody');
    let $ticket;
    for (var i = 0; i < seats; i++) {
        $ticket = document.createElement("tr");
        var seat = document.createElement("td");
        var price = document.createElement("td");
        createInput('ticketSeat', 'text', "", seat);
        createInput('ticketPrice', 'number', "", price);
        $ticket.appendChild(seat);
        $ticket.appendChild(price);
    }
    $tbody.appendChild($ticket);

}
function createInput(inputName, inputType, inputValue, aDiv) {
    var input = document.createElement("input");
    input.setAttribute("type",inputType) ;
    input.setAttribute("name",inputName) ;
    input.setAttribute("value", inputValue) ;
    aDiv.appendChild(input);
}