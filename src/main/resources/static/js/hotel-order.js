
var amountBox = $(".amount");//
var totalBox = $(".totalPeople");

function updateTotal(){
    var priceValue = amountBox.val();//单价
       //输入框中的份额数与每份金额数相乘得到总金额
    totalBox.text(priceValue);
    if(amountBox.val() <= 0){
        totalBox.text(1);
    }
}

$(function(){
    $(".add").click(function() {
        amountBox.val(parseInt(amountBox.val()) + 1); //点击加号输入框数值加1
        updateTotal();  //显示总金额
    });
    $(".min").click(function(){
        amountBox.val(parseInt(amountBox.val()) - 1); //点击减号输入框数值减1
        if(amountBox.val() <= 0){
            amountBox.val(1); //最小值为1
        }
        updateTotal();
    });
    $(".amount").keyup(function(){
        var clickBox = $(this);
        if(/[^\d]/.test(clickBox.val())){//替换非数字字符
            var count = clickBox.val().replace(/[^\d]/g,'');
            $(this).val(count);
        }
        updateTotal();  //手动输入数值金额随之改变
    });
});