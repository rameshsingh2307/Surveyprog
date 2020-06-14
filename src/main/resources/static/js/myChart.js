// For a pie chart
var chartDataStr = decodeHtml(chartData);
var chartJsonArray=JSON.parse(chartDataStr);
var arrayLength = chartJsonArray.length;
var numericData  = [];
var labelData  = [];
for(var i=0;i<arrayLength;i++)
	{
		numericData[i] = chartJsonArray[i].projectCount;
		labelData[i] = chartJsonArray[i].stage;
	}
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title:{
    		display:true,
    		text: 'Project status chart'
    	}
    }
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}