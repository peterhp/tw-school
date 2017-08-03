/**
 * Created by Shli on 04/08/2017.
 */

const TABLE_HEADER = "<tr>" +
    "<th>sid</th><th>name</th>" +
    "<th>math</th><th>chinese</th>" +
    "<th>english</th><th>program</th>" +
    "<th>total</th><th>average</th>" +
    "</tr>";

$(document).ready(function () {
    fillReportData(null);

    $("form").submit(function () {
        event.preventDefault();

        const input = $("input[name='sid-list']").val();
        if (input.length > 0) {
            fillReportData(getReportForStudents(input));
        }
    });
});

const fillReportData = function (report) {
    let tblView = TABLE_HEADER;
    let average = 0;
    let median = 0;

    if (report != null) {
        tblView += report.items.map(item => generateStudentScoreView(item)).join("");
        average = report.average;
        median = report.median;
    }

    $("table").html(tblView);
    $("#average-total").text(average.toString());
    $("#median-total").text(median.toString());
};

const getReportForStudents = function (sids) {
    return (sids === "S003,S004" ? JSON.parse(
            getDataInStorage(KEY_REPORT)) : null);
};

const generateStudentScoreView = function (item) {
    return `<tr>` +
        `<td>${item.sid}</td><td>${item.name}</td>` +
        `<td>${item.math}</td><td>${item.chinese}</td>` +
        `<td>${item.english}</td><td>${item.program}</td>` +
        `<td>${item.total}</td><td>${item.average}</td>` +
        `</tr>`;
};
