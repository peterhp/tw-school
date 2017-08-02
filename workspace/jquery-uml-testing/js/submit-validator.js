/**
 * Created by Shli on 02/08/2017.
 */

const validateTestInfo = function () {
    return $("#klass").val().length &&
            $("#sid").val().length &&
            $("#name").val().length &&
            validateEmailString($("#email").val()) &&
            validatePidString($("#pid").val());
};

const validateEmailString = function (email) {
    return /^\w+@\w+\.\w+$/.test(email);
};

const validatePidString = function (pid) {
    return /^\d{17}[\dxX]$/.test(pid);
};
