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