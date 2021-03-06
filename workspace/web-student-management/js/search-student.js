/**
 * Created by Shli on 03/08/2017.
 */

const TABLE_HEADER = "<tr>" +
    "<th>sid</th><th>name</th><th>gender</th><th>class</th>" +
    "<th>personal id</th><th>native place</th><th>phone</th><th>e-mail</th>" +
    "<th>courses</th>" +
    "</tr>";

let students = null;

$(document).ready(function () {
    displayStudentList(students);
    obtainAndDisplayStudentsFromRemote("http://localhost:8080/students");

    $("form").submit(function (event) {
        event.preventDefault();

        const input = $("input[name='search']").val();
        if (input.length > 0) {
            displayStudentList(findStudentsByIdOrName(input));
        }
    });
});

const obtainAndDisplayStudentsFromRemote = function (url) {
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        statusCode: {
            200: function (data) {
                students = data;
                displayStudentList(students);
            }
        }
    });
};

const obtainAndDisplayStudentsFromStorage = function () {
    students = JSON.parse(getDataInStorage(KEY_STUDENT_LIST));
    displayStudentList(students);
};

const findStudentsByIdOrName = function (value) {
    return students.filter(student =>
    student.sid === value || student.name === value);
};

const displayStudentList = function (studentList) {
    $("table").html(TABLE_HEADER + generateStudentListView(studentList));
};

const generateStudentListView = function (studentList) {
    return (studentList ?
        studentList.map(stu => generateStudentItemView(stu)).join("") : "");
};

const generateStudentItemView = function (student) {
    return `<tr>` +
        `<td>${student.sid}</td><td>${student.name}</td>` +
        `<td>${student.gender}</td><td>${student.klass}</td>`+
        `<td>${student.personalId}</td><td>${student.nativePlace}</td>` +
        `<td>${student.phone}</td><td>${student.email}</td>` +
        `<td><a href="update-scores.html?sid=${student.sid}&name=${student.name}">details</a></td>` +
        `</tr>`;
};
