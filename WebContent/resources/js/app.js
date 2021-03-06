(function () {
    $(function () {
        $(".navbar-expand-toggle").click(function () {
            $(".app-container").toggleClass("expanded");
            return $(".navbar-expand-toggle").toggleClass("fa-rotate-90");
        });
        return $(".navbar-right-expand-toggle").click(function () {
            $(".navbar-right").toggleClass("expanded");
            return $(".navbar-right-expand-toggle").toggleClass("fa-rotate-90");
        });
    });

    $(function () {
        $('.input-checkbox, .input-radio').iCheck({
            checkboxClass: 'icheckbox_flat',
            radioClass: 'iradio_flat'
        });
    });

    $(function () {
        return $('select').select2();
    });

    $(function () {
        return $('.toggle-checkbox').bootstrapSwitch();
    });

    $(function () {
        return $('.match-height').matchHeight();
    });

    $(function () {
        return $('.datatable').DataTable({
            "dom": '<"top"fl<"clear">>rt<"bottom"ip<"clear">>'
        });
    });

}).call(this);

function convertPdfToBase64(id, textInputPopulateId) {
    var reader = new FileReader();

    reader.onloadend = function () {
        x = reader.result.replace("application/data", "application/pdf");
        //console.log(x);
        if (textInputPopulateId)
            $('#' + textInputPopulateId).val(x);
        return x;
    };

    reader.readAsDataURL(document.getElementById(id).files[0]);

    console.log("Carregando...");
}
