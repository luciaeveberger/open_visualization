$(document).ready(function(){
    var pollen_series = [];
    pollen_date_array = [];
    var CSV_string = "";
    var deliminatior = ";";
    var linebreak = "\n";
    CSV_string = CSV_string + "date" + deliminatior;
    for (var key in pollen_series){
        CSV_string = CSV_string + series[key]['name'] + deliminatior
    }
    $.ajax({url: "/all_pollen_data", success: function(result) {
            data_names = [];
            for (var val in result) {
                data = [];
                data.push(result[val]['day1']);
                data.push(result[val]['day2']);
                data.push(result[val]['day3']);
                data.push(result[val]['day4']);
                data.push(result[val]['day5']);
                data.push(result[val]['day6']);
                data.push(result[val]['day7']);
                pollen_series.push({
                    name: result[val]['part_NAME_L'],
                    data: data
                });
                data_names.push(result[val]['part_NAME_L'])
            }
            if (document.getElementById("container_pollen"))
                Highcharts.chart('container_pollen', {
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'Weekly pollen count by Species'
                    },
                    subtitle: {
                        text: ''
                    },
                    xAxis: {
                        categories: data_names,
                        title: {
                            text: null
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Pollen By Name',
                            align: 'high'
                        },
                        labels: {
                            overflow: 'justify'
                        }
                    },
                    tooltip: {
                        valueSuffix: ' count of'
                    },
                    plotOptions: {
                        bar: {
                            dataLabels: {
                                enabled: true
                            }
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: -40,
                        y: 80,
                        floating: true,
                        borderWidth: 1,
                        backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                        shadow: true
                    },
                    credits: {
                        enabled: false
                    },
                    series: pollen_series
                });

    }});
    $("#csv_make").click(function() {
        console.log("HERE?")
        var chart = $('#container_pollen').highcharts();
        chart.exportChart({
            filename: 'PollenData'
        });
    });
    var type_Data = "PollenData";
    $("#add_pollen_to_cart").click(function(){
        console.log(type_Data);
        $.ajax({type:"POST", url: "/add_to_cart", data:type_Data, success: function(result) {
            }});
        window.location.href = "/show_cart";
    });
});
