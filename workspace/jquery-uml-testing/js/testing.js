/**
 * Created by Shli on 02/08/2017.
 */

$(document).ready(function () {
    let student = getStudentInfo();
    console.log(student.id + student.name + student.klass);
});

let getStudentInfo = function () {
    return {
        id: $("#stu-id").val(),
        name: $("#stu-name").val(),
        klass: $("#stu-class").val()
    };
};
