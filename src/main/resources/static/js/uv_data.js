$(document).ready(function(){
    $("#data_details").hide();
    $("#show_details").click(function() {
        $("#data_details").show();
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


    $.ajax({url: "/all_uv_data", success: function(result) {
            for (var val in result) {
                series[0].data.push([result[val]['date']/10000, result[val]['re1_UVB']]/10000);
                //series[1].data.push([result[val]['date'], result[val]['re1_T_UVB']]);
                series[2].data.push([result[val]['date'],result[val]['re1_UVA']]);
                CSV_string = CSV_string + result[val]['date'] + deliminatior;
                CSV_string = CSV_string + result[val]['re1_UVB'] + deliminatior;
                CSV_string = CSV_string + result[val]['re1_UVA'] + deliminatior;
                CSV_string = CSV_string + linebreak;
            }
            if (document.getElementById("uv_data_container")) {
                Highcharts.chart('uv_data_container', {
                    zoomType: 'xy',
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
                                connectorAllowed: false,
                            },
                           // data:date_arr

                        }
                    },
                    xAxis: {
                        type: 'datetime',
                        // data:date_arr,
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
            };
        }});
    CSV_string = CSV_string + linebreak;
    $("#export_csv").click(function() {
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

    var data = "UVData";
    $("#add_to_cart").click(function(){
        $.ajax({type:"POST", url: "/add_to_cart", data:data, success: function(result) {
            console.log(result);
            }});
        window.location.href = "/show_cart";
    });

    $("#add_custom_request").click(function(){
        $.ajax({type:"POST", url: "/add_to_cart", data:data, success: function(result) {
                console.log(result);
            }});
        window.location.href = "/show_cart";
    });
    $("form").submit(function() {
        var $inputs = $('#featureRequest :input');
        console.log($inputs);
        $.ajax({type:"POST", url: "/add_custom_request", data:$inputs, success: function(result) {
                console.log(result);
            }});

    });



});