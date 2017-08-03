/**
 * Created by Shli on 03/08/2017.
 */

const students = JSON.parse(getDataInStorage(KEY_STUDENT_LIST));

$(document).ready(function () {
    fillTableWithStudentsView(generateStudentsView(students));
});

const fillTableWithStudentsView = function (htmlView) {
    $("table").html($("table").html() + htmlView);
};

const generateStudentsView = function (students) {
    return students.map(stu => generateStudentTrView(stu)).join("");
};

const generateStudentTrView = function (student) {
    return `<tr><td>${student.sid}</td><td>${student.name}</td>` +
            `<td>${student.gender}</td><td>${student.class}</td></tr>`;
};
