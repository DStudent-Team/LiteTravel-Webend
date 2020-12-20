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