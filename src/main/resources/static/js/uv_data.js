$(document).ready(function(){
    $("#table").hide();
    $("#show_tables").click(function() {
            $("#container").hide();
            $("#table").show();
            $("#show_tables").addClass("active");
            $("#show_charts").removeClass("active");
    });
    $("#show_charts").click(function() {
        $("#container").show();
        $("#table").hide();
        $("#show_charts").addClass("active");
        $("#show_tables").removeClass("active");
    });
    var series = [{
        name:"RE1_UVB",
        data: []
        },
        {
            name:"RE1_T_UVB",
            data: []
        },
        {
            name:"RE1_UVA",
            data: []
        }
    ];
    date_arr = [];
    var CSV_string = "";
    var deliminatior = ";";
    var linebreak = "\n";
    CSV_string = CSV_string + "date" + deliminatior;
    for (var key in series){
        CSV_string = CSV_string + series[key]['name'] + deliminatior
    }

    $.ajax({url: "http://localhost:8080/all_uv_data", success: function(result) {
            for (var val in result) {
                series[0].data.push(result[val]['re1_UVB']);
                series[2].data.push(result[val]['re1_UVA']);
                CSV_string = CSV_string + result[val]['date'] + deliminatior;
                CSV_string = CSV_string + result[val]['re1_UVB'] + deliminatior;
                CSV_string = CSV_string + result[val]['re1_UVA'] + deliminatior;
                CSV_string = CSV_string + linebreak;
                date_arr.push(result[val]['date']);
            }
            Highcharts.chart('container', {
                data: {
                    // enablePolling: true,
                },
                title: {
                    text: 'UV DATA'
                },
                subtitle: {
                    text: 'Source: open data'
                },
                credits: {
                    enabled: false
                },
                yAxis: {
                    title: {
                        text: 'UV variables'
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'middle'
                },
                plotOptions: {
                    series: {
                        label: {
                            connectorAllowed: false
                        }
                    }
                },
                xAxis:{
                    type: 'datetime',
                    labels: {
                        format: '{value:%Y-%b-%e}'
                    },
                    data:date_arr,
                },
                series: series,
                responsive: {
                    rules: [{
                        condition: {
                            maxWidth: 500
                        },
                        chartOptions: {
                            legend: {
                                layout: 'horizontal',
                                align: 'center',
                                verticalAlign: 'bottom'
                            }
                        }
                    }]
                }
            });
        }});
    CSV_string = CSV_string + linebreak;
    $("#export_csv").click(function() {
        console.log(CSV_string);
        var blob = new Blob([CSV_string], {
            type: 'text/csv;charset=utf-8'
        });
        var csvUrl = URL.createObjectURL(blob);
        if (false && window.navigator.msSaveBlob) {
        $(this)
            .attr({
                'download': "UV_Data",
                'href': csvUrl
            });
        } else {
        // Data URI
        var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(CSV_string);
        $(this)
            .attr({
                'download': "UV_Data",
                'href': csvUrl,
                'target': '_blank'
            });
    }
    });


});