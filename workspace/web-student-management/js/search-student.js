/**
 * Created by Shli on 03/08/2017.
 */

const TABLE_HEADER = "<tr>" +
    "<th>sid</th><th>name</th><th>gender</th><th>class</th>" +
    "<th>personal id</th><th>native place</th><th>phone</th><th>e-mail</th>" +
    "</tr>";

const students = JSON.parse(getDataInStorage(KEY_STUDENT_LIST));

$(document).ready(function () {
    fillTableWithStudentsView(generateStudentsView(students));

    $("form").submit(function (event) {
        event.preventDefault();

        const input = $("input[name='search']").val();
        if (input.length > 0) {
            fillTableWithStudentsView(generateStudentsView(
                    findStudentsByIdOrName(input)));
        }
    });
});

const fillTableWithStudentsView = function (htmlView) {
    $("table").html(TABLE_HEADER + htmlView);
};

const findStudentsByIdOrName = function (value) {
    return students.filter(student =>
            student.sid === value || student.name === value);
};

const generateStudentsView = function (students) {
    return students.map(stu => generateStudentTrView(stu)).join("");
};

const generateStudentTrView = function (student) {
    return `<tr>` +
        `<td>${student.sid}</td><td>${student.name}</td>` +
        `<td>${student.gender}</td><td>${student.class}</td>`+
        `<td>${student.pid}</td><td>${student.native}</td>` +
        `<td>${student.phone}</td><td>${student.email}</td>` +
        `</tr>`;
};
