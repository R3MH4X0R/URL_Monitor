$(document).ready(function () {

    $('#autoref').click(function () {
        localStorage.setItem('on', 'active')
        location.reload();
    });

    $('#stopautoref').click(function () {
        localStorage.removeItem("on")
        location.reload();
    });

    if (localStorage.getItem("on") !== null) {
        setInterval(function () {
            window.location.href = "http://localhost:8080/refresh";
        }, 5000);
    }

    $('#myTable td.y_n').each(function () {
        if ($(this).text() == '200') {
            $(this).css('background-color', '#00ff00');
        } else {
            $(this).css('background-color', '#f00');
        }
    });

    $(function () {
        $("form[name='myForm']").validate({
            rules: {
                url: {
                    required: true,
                    url: true
                }

            },
            errorPlacement: function (error, element) {
                console.log('dd', element.attr("url"))
                error.appendTo("#messageBox");

            },
            messages: {
                url: "Please enter url",
                submitHandler: function (form) {
                    form.submit();
                }
            }
        });
    })

});









