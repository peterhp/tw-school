/**
 * Created by Shli on 04/08/2017.
 */

const TABLE_HEADER = "<tr>" +
    "<th>name</th>" +
    "<th>math</th><th>chinese</th>" +
    "<th>english</th><th>program</th>" +
    "<th>total</th><th>average</th>" +
    "</tr>";

$(document).ready(function () {
    fillStorageReportData(null);

    $("form").submit(function () {
        event.preventDefault();

        const input = $("input[name='sid-list']").val();
        if (input.length > 0) {
            getReportFromRemote(`http://localhost:8080/reports/${input}`);
        }
    });
});

const fillRemoteReportData = function (report) {
    let tblView = TABLE_HEADER;
    let average = 0;
    let median = 0;

    if (report != null) {
        tblView += report.items.map(item => generateRemoteItemView(item)).join("");
        average = report.averageTotalScore;
        median = report.medianTotalScore;
    }

    $("table").html(tblView);
    $("#average-total").text(average.toString());
    $("#median-total").text(median.toString());
};

const generateRemoteItemView = function (item) {
    return `<tr>` +
        `<td>${item.name}</td>` +
        `<td>${item.mathScore}</td><td>${item.chineseScore}</td>` +
        `<td>${item.englishScore}</td><td>${item.programScore}</td>` +
        `<td>${item.totalScore}</td><td>${item.averageScore}</td>` +
        `</tr>`;
};

const getReportFromRemote = function (url) {
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        statusCode: {
            200: function (data) {
                fillRemoteReportData(data);
            }
        }
    });
};

const fillStorageReportData = function (report) {
    let tblView = TABLE_HEADER;
    let average = 0;
    let median = 0;

    if (report != null) {
        tblView += report.items.map(item => generateStorageItemView(item)).join("");
        average = report.average;
        median = report.median;
    }

    $("table").html(tblView);
    $("#average-total").text(average.toString());
    $("#median-total").text(median.toString());
};

const getStorageReportForStudents = function (sids) {
    return (sids === "S003,S004" ? JSON.parse(
            getDataInStorage(KEY_REPORT)) : null);
};

const generateStorageItemView = function (item) {
    return `<tr>` +
        `<td>${item.name}</td>` +
        `<td>${item.math}</td><td>${item.chinese}</td>` +
        `<td>${item.english}</td><td>${item.program}</td>` +
        `<td>${item.total}</td><td>${item.average}</td>` +
        `</tr>`;
};
