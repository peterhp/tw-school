/**
 * Created by Shli on 02/08/2017.
 */

$(document).ready(function () {
    displayStudentAndAnswers(loadTestData());
});

const loadTestData = function () {
    return JSON.parse(sessionStorage.getItem("student"));
};

const displayStudentAndAnswers = function (student) {
    displayStudentInfo(student);

    displayTestItem1(student.answer.t1);
    displayTestItem2(student.answer.t2);
    displayTestItem3(student.answer.t3);
    displayTestItem4(student.answer.t4);
    displayTestItem5(student.answer.t5);
};

const displayStudentInfo = function (student) {
    $("#stu-info").html(`班级：${student.klass}<br>学号：${student.sid}<br>姓名：${student.name}<br>` +
            `E-Mail：${student.email}<br>身份证：${student.pid}`);
};

const displayTestItem1 = function (t1) {
    $("#t1").html(`1. ${t1.q1}<br>2. ${t1.q2.join("，")}`);
};

const displayTestItem2 = function (t2) {
    $("#t2").html(`1. ${t2.q1}<br>2. ${t2.q2}`);
};

const displayTestItem3 = function (t3) {
    $("#t3").html(`1. ${t3.q1.join(" ")}<br>2. ${t3.q2.join(" ")}`);
};

const displayTestItem4 = function (t4) {
    $("#t4").html(`1. ${t4.q1}<br>2. ${t4.q2}`);
};

const displayTestItem5 = function (t5) {
    $("#t5").html(`1. ${t5.q1}`);
};