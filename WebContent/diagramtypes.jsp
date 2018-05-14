<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <% response.setContentType("text/html; charset=windows-1251"); %>
<%@ page import="java.util.*" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="https://d3js.org/d3.v5.min.js"></script>
<title>Result</title>

	<link rel="shortcut icon" href="images/icon.png" type="image/x-icon">
	<!-- Google Webfonts -->
	<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,100,500' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100,500' rel='stylesheet' type='text/css'> 
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css"> 
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" href="css/simple-line-icons.css">
	<!-- Theme Style -->
	<link rel="stylesheet" href="css/style.css">



</head>
<body>
	<header id="fh5co-header" role="banner">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container">
				<div class="row">
					<div class="col-md-10 col-md-offset-1">
						<div class="navbar-header"> 
						<!-- Mobile Toggle Menu Button -->
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle visible-xs-block" data-toggle="collapse" data-target="#fh5co-navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
						<a class="navbar-brand" href="index.html"><img
							src=images/social.png width="200" height="100" border=0> </a>
						</div>
						<div id="fh5co-navbar" class="navbar-collapse collapse">
							<ul class="nav navbar-nav navbar-right">
								<li class="active"><a href=help><img src=images/thankyou.jpg
						width="100" height="100" border=0><span>Авторизация <span class="border"></span></span></a></li>
								<li><a href=contacts><img src=images/contact.jpeg width="100" height="100" border=0><span>Контакты<span class="border"></span></span></a></li>
								<li><a href="support.html"><img src=images/help.png width="100" height="100" border=0><span>Помощь<span class="border"></span></span></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>
<p align=right><a href=index.html>Home</a>
  
  
  <p align=center>
  
    <c:choose>
        <c:when test="${param.choice == '1'}"><p align=center><img src=images/gist.png> </c:when>
        <c:when test="${param.choice == '2'}"><p align=center><img src=images/pie.png></c:when>
        <c:when test="${param.choice == '3'}"><button onClick="changeData()">Change Data</button>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script src="Donut3D.js"></script>
<script>

var salesData=[
	{label:"Basic", color:"#3366CC"},
	{label:"Plus", color:"#DC3912"},
	{label:"Lite", color:"#FF9900"},
	{label:"Elite", color:"#109618"},
	{label:"Delux", color:"#990099"}
];

var svg = d3.select("body").append("svg").attr("width",700).attr("height",300);

svg.append("g").attr("id","salesDonut");
svg.append("g").attr("id","quotesDonut");

Donut3D.draw("salesDonut", randomData(), 150, 150, 130, 100, 30, 0.4);
Donut3D.draw("quotesDonut", randomData(), 450, 150, 130, 100, 30, 0);
	
function changeData(){
	Donut3D.transition("salesDonut", randomData(), 130, 100, 30, 0.4);
	Donut3D.transition("quotesDonut", randomData(), 130, 100, 30, 0);
}

function randomData(){
	return salesData.map(function(d){ 
		return {label:d.label, value:1000*Math.random(), color:d.color};});
}
</script></c:when>
        <c:when test="${param.choice == '4'}"><p align=center><img src=images/bar.png>;</c:when>
        <c:when test="${param.choice == '5'}"><p align=center><img src=images/areas.png>;</c:when>
        <c:when test="${param.choice == '6'}"><p align=center><img src=images/dot.png>;</c:when>
        <c:when test="${param.choice == '7'}"><p align=center><img src=images/dot.png>;</c:when>
        <c:when test="${param.choice == '8'}"><script>
var margin = {top: 80, right: 80, bottom: 80, left: 80},
    width = 600 - margin.left - margin.right,
    height = 400 - margin.top - margin.bottom;
var x = d3.scale.ordinal()
    .rangeRoundBands([0, width], .1);
var y0 = d3.scale.linear().domain([300, 1100]).range([height, 0]),
y1 = d3.scale.linear().domain([20, 80]).range([height, 0]);
var xAxis = d3.svg.axis()
    .scale(x)
    .orient("bottom");
// create left yAxis
var yAxisLeft = d3.svg.axis().scale(y0).ticks(4).orient("left");
// create right yAxis
var yAxisRight = d3.svg.axis().scale(y1).ticks(6).orient("right");
var svg = d3.select("body").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("class", "graph")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
d3.tsv("data.tsv", type, function(error, data) {
  x.domain(data.map(function(d) { return d.year; }));
  y0.domain([0, d3.max(data, function(d) { return d.money; })]);
  
  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis);
  svg.append("g")
	  .attr("class", "y axis axisLeft")
	  .attr("transform", "translate(0,0)")
	  .call(yAxisLeft)
	.append("text")
	  .attr("y", 6)
	  .attr("dy", "-2em")
	  .style("text-anchor", "end")
	  .style("text-anchor", "end")
	  .text("Dollars");
	
  svg.append("g")
	  .attr("class", "y axis axisRight")
	  .attr("transform", "translate(" + (width) + ",0)")
	  .call(yAxisRight)
	.append("text")
	  .attr("y", 6)
	  .attr("dy", "-2em")
	  .attr("dx", "2em")
	  .style("text-anchor", "end")
	  .text("#");
  bars = svg.selectAll(".bar").data(data).enter();
  bars.append("rect")
      .attr("class", "bar1")
      .attr("x", function(d) { return x(d.year); })
      .attr("width", x.rangeBand()/2)
      .attr("y", function(d) { return y0(d.money); })
	  .attr("height", function(d,i,j) { return height - y0(d.money); }); 
  bars.append("rect")
      .attr("class", "bar2")
      .attr("x", function(d) { return x(d.year) + x.rangeBand()/2; })
      .attr("width", x.rangeBand() / 2)
      .attr("y", function(d) { return y1(d.number); })
	  .attr("height", function(d,i,j) { return height - y1(d.number); }); 
});
function type(d) {
  d.money = +d.money;
  return d;
}
</script></c:when>

        <c:otherwise>undefined</c:otherwise>
    </c:choose>


</body>
</html>