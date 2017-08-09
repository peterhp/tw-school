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
    initReportView();

    $("form").submit(function () {
        event.preventDefault();

        const input = $("input[name='sid-list']").val();
        if (input.length > 0) {
            displayReportFromRemote(`http://localhost:8080/reports/${input}`);
        }
    });
});

const displayReportFromRemote = function (url) {
    $.ajax({
        url: url,
        method: "GET",
        dataType: "json",
        statusCode: {
            200: function (data) {
                displayReport(data);
            }
        }
    });
};

const displayReportFromStorage = function (sids) {
    if (sids === "S003，S004") {
        displayReport(JSON.parse(getDataInStorage(KEY_REPORT)));
    }
};

const initReportView = function () {
    displayReport(null);
};

const displayReport = function (report) {
    let tblView = TABLE_HEADER;
    let average = 0;
    let median = 0;

    if (report) {
        tblView += report.items.map(item => generateItemView(item)).join("");
        average = report.averageTotalScore;
        median = report.medianTotalScore;
    }

    $("table").html(tblView);
    $("#average-total").text(average.toString());
    $("#median-total").text(median.toString());
};

const generateItemView = function (item) {
    return `<tr>` +
        `<td>${item.name}</td>` +
        `<td>${item.mathScore}</td><td>${item.chineseScore}</td>` +
        `<td>${item.englishScore}</td><td>${item.programScore}</td>` +
        `<td>${item.totalScore}</td><td>${item.averageScore}</td>` +
        `</tr>`;
};
