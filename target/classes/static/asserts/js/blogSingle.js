function postComment() {
    var blogId = $("#blogId").val();
    var commentContent = $("#commentContent").val();
    if (!commentContent) {
        alert("回复不能为空!");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/blog/comment",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": blogId,
            "parentType": 0,
            "commentContent": commentContent
        }),
        success: function (response) {
            if (response.code === 200) {
                //    回复成功
                //    弹出回复成功浮动框消息(数秒后自动消失)
                alert("回复成功");
                window.location.reload();
                $("#commentContent").val("");
                var bottomBox = document.getElementById("commentList");
                bottomBox.scrollIntoView();  //点击后地址栏url不会变化，可多次点击
            } else {
                //  回复失败
                //  未登录, 虽然在这个项目中不会出现, 因为拦截器强制拦截了所有网页.
                if (response.code === 2003) {
                    //检测是否点击跳转登陆页面
                    // todo 做一个跳转页面确实很重要, 但是如何打开登陆页面呢, 这是一个问题
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        //如何跳转至内部服务器的主页呢?
                        //先这样试试, 好像也不是很大问题
                        var win = window.open("http://localhost:8080");
                        win.localStorage.setItem("closable", true);
                    }
                }
                alert(response.message);
            }
        },
    });
}