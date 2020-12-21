// //新流程不预估，而是发送请求后获取订单信息
// function updateTotal(){
//     var flightFrom = $("#flightFrom").val();//出发地
//     var flightTo = $("#flightTo").val();//目的地
//     var flightDepart = $("#flightDepart").val();//出发时间
//     var flightArrived = $("#flightArrived").val();//到达时间
//     var flightLevel = $("#flightLevel").val();//机舱级别
//     var flightSeats = $("#flightSeats").val();//乘坐人数
//     var flightTotal = $("#flightTotal");//总价栏
//     var total = 0;
//     if (flightFrom === "" || flightTo === "" || flightSeats <= 0){
//         flightTotal.val(total);
//         return;
//     }
//     $.ajax({
//         type: 'POST',
//         url: '/evaluateOrder',
//         data: JSON.stringify({
//             'flightFrom': flightFrom,
//             'flightTo': flightTo,
//             'flightDepart': flightDepart,
//             'flightArrived': flightArrived,
//             'flightLevel': flightLevel,
//             'flightSeats': flightSeats,
//         }),
//         dataType: "json",
//         contentType: "application/json", //修改contentType，使@RequestParam可以接收数据。
//         async: false, //让ajax执行代码顺序同步
//         success: function (response) {
//             if (response.code === 200){
//                 total = Math.ceil(response.data);
//                 flightTotal.val(total);
//             } else {
//                 //  估值失败
//                 alert(response.message);
//             }
//         }
//
//     });
// }
