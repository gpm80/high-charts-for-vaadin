window.ru_efo_vaadin_addon_highchart_HighChart = function () {

    this.draw = function (containerId, data) {
        console.log(containerId);
        console.log(data);
        Highcharts.chart(containerId, data);
    };

    this.init();
};