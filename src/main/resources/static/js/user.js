// 修改用户信息
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

// 后台删除用户提示框
function deleteUser (userId) {
    let x;
    let r=confirm("按下按钮!");
    if (r===true){
        alert("修改成功！");
        window.location.reload();
        console.log(userId);
    }
    else{
        x="你按下了\"取消\"按钮!";
    }

}

// 暂时没办法了，只能用这种办法传。。
/**
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
    console.log("有毒啊"+userId+userCode+userPassword+userName+userBirth+userEmail+userPhone+userAddressSpecific+userState);
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
    $('#putMethod').val("PUT");
}

function clearUser(){
    // console.log("有毒啊"+userId+userCode+userPassword+userName+userBirth+userEmail+userPhone+userAddressSpecific+userState);
    //向模态框中传值
    $('#userId').val("");
    $('#userCode').val("");
    $('#userPassword').val("");
    $('#userName').val("");
    $('#userBirth').val("");
    $('#userEmail').val("");
    $('#userPhone').val("");
    $('#userAddressSpecific').val("");
    $('#userState').val("");
    $('#putMethod').val("post");
}
