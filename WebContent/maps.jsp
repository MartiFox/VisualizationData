<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Карта</title>
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

        
        
        
        <style>
            /* CSS goes here. */
            .subunit {
                fill: none;
                stroke: #FFF;
                stroke-width: 1px;
            }
            text.subunit-label {
                font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                font-size: 14px;
                font-weight: 300;
                text-anchor: middle;
                fill: #000;
            }
            .subunit-label {
                display: none;
            }
            .graticule {
                fill: none;
                stroke: #aaa;
                stroke-opacity: .5;
                stroke-width: .5px;
            }
        </style>
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
								<li class="active"><a href=login><img src=images/thankyou.jpg
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
    
    
        <script src="//d3js.org/d3.v3.min.js" charset="utf-8"></script>
        <script src="//d3js.org/topojson.v1.min.js"></script>
        <script>
            /* JavaScript goes here. */
            // globals used in graph
            var mapdata = {};
            var palette = ['#009933','#669900','#99cc00','#cccc00','#c7dc09','#edf933','#ffcc00', '#ff9933', '#ff6600','#ff5050'];
            var width = 960, height = 960;
            var minDocCount = 0, quantiles = {};
            // projection definitions
            var projection = d3.geo.mercator()
                .scale((width + 1) /2 / Math.PI)
                .translate([width/2, height/2])
                .precision(.1);
            var path = d3.geo.path().projection(projection);
            var graticule = d3.geo.graticule(); 
            // SVG related definitions
            var svg = d3.select('body').append('svg')
                        .attr({'width': width, 'height': height})
                        .append('g');
            var filter = svg.append('defs')
                .append('filter')
                .attr({'x':0, 'y':0, 'width':1, 'height':1, 'id':'gray-background'});
            filter.append('feFlood')
                .attr('flood-color', '#f2f2f2')
                .attr('result', 'COLOR');
            filter.append('feMorphology')
                .attr('operator', 'dilate')
                .attr('radius', '.9')
                .attr('in', 'SourceAlpha')
                .attr('result', 'MORPHED');
            filter.append('feComposite')
                .attr('in', 'SourceGraphic')
                .attr('in2', 'MORPHED')
                .attr('result', 'COMP1');
            filter.append('feComposite')
                .attr('in', 'COMP1')
                .attr('in2', 'COLOR');

            svg.append("path")
                .datum(graticule)
                .attr("class", "graticule")
                .attr("d", path);

            d3.json('mockelasticdata.json', function(error, mockdata) {
                if (error) return console.error(error);
                console.log('mockdata',mockdata);
                mapdata = mockdata;
                draw(mockdata)
            });

            function draw(data) {
                // var localstoreWorldData = localStorage.getItem('worldmapData');
                // if (localstoreWorldData && localstoreWorldData.length) {
                //     localstoreWorldData = JSON.parse(localstoreWorldData);
                //     console.log('localstoreWorldData',localstoreWorldData);
                //     if (localstoreWorldData) {
                //         processWorldD(localstoreWorldData, data);
                //         //no need proceed further
                //         return;
                //     }
                // }
                d3.json('world.json', function(error, world) {
                    if (error) return console.error(error);
                    console.log('world',world);
                    processWorldD(world, data);
                    //localStorage.setItem('worldmapData', JSON.stringify(world));
                });
            }
            function processWorldD(world, data) {
                    for(var idx=0; idx < data.aggregations.world_map.buckets.length; idx++) {
                        var cCode = data.aggregations.world_map.buckets[idx].key.toUpperCase();
                        var doc_count = data.aggregations.world_map.buckets[idx].doc_count;
                        for(var wdx=0; wdx < world.objects.subunits.geometries.length; wdx++) {
                            var cName = world.objects.subunits.geometries[wdx].id.toUpperCase();
                            if (cCode === cName) {
                                world.objects.subunits.geometries[wdx].properties.doc_count = doc_count;
                            }
                        }
                    }
                    var subunits = topojson.feature(world, world.objects.subunits);
                    subunits.features = subunits.features.filter(function(d){ return d.id !== "ATA"; });
                    console.log('subunits',subunits);
                    minDocCount = d3.min(subunits.features, function(d){ return d.properties.doc_count; });
                    console.log('minDocCount',minDocCount);
                    var doc_counts = subunits.features.map(function(d){ return d.properties.doc_count; });
                    doc_counts = doc_counts.filter(function(d){ return d; }).sort(d3.ascending);
                    //console.log('doc_counts',doc_counts);
                    quantiles['0.95'] = d3.quantile(doc_counts, '0.95');
                    var countries = svg.selectAll('path.subunit')
                        .data(subunits.features).enter();
                    countries.insert('path', '.graticule')
                        .attr('class', function(d) { return 'subunit ca'+d.id; })
                        .style('fill', heatColor)
                        .attr('d', path)
                        .on('mouseover',mouseoverLegend).on('mouseout',mouseoutLegend)
                        .on('click', coutryclicked);
                    
                    countries.append('svg:text')
                        .attr('class', function(d){ return 'subunit-label la'+d.id+d.properties.name.replace(/[ \.#']+/g,''); })
                        //.attr('transform', function(d) { return 'translate('+ path.centroid(d) +')'; })
                        .attr('transform', function(d) { return 'translate('+(width-(5*d.properties.name.length))+','+(15)+')'; })
                        .attr('dy', '.35em')
                        .attr('filter', 'url(#gray-background)')
                        .append('svg:tspan')
                        .attr('x', 0)
                        .attr('dy', 5)
                        .text(function(d) { return d.properties.name; })
                        .append('svg:tspan')
                        .attr('x', 0)
                        .attr('dy', 20)
                        .text(function(d) { return d.properties.doc_count ? d.properties.doc_count : ''; });
            }

            function mouseoverLegend(datum, index) {
                d3.selectAll('.subunit-label.la'+datum.id+datum.properties.name.replace(/[ \.#']+/g,''))
                    .style('display', 'inline-block');
                d3.selectAll('.subunit.ca'+datum.id)
                    .style('fill', '#cc6699');
            }

            function mouseoutLegend(datum, index) {
                d3.selectAll('.subunit-label.la'+datum.id+datum.properties.name.replace(/[ \.#']+/g,''))
                    .style('display', 'none');
                d3.selectAll('.subunit.ca'+datum.id)
                    .style('fill', heatColor(datum));
            }

            function coutryclicked(datum, index) {
                //filter event for this country should be applied here
                console.log('coutryclicked datum', datum);
            }
            function heatColor(d) {
                if (quantiles['0.95'] === 0 && minDocCount === 0) return '#F0F0F0';
                if (!d.properties.doc_count) return '#F0F0F0';
                if (d.properties.doc_count > quantiles['0.95']) return palette[(palette.length - 1)];
                if (quantiles['0.95'] == minDocCount) return palette[(palette.length-1)];
                var diffDocCount = quantiles['0.95'] - minDocCount;
                var paletteInterval = diffDocCount / palette.length;
                var diffDocCountDatum = quantiles['0.95'] - d.properties.doc_count;
                var diffDatumDiffDoc = diffDocCount - diffDocCountDatum;
                var approxIdx = diffDatumDiffDoc / paletteInterval;
                if (!approxIdx || Math.floor(approxIdx) === 0) approxIdx = 0;
                else approxIdx = Math.floor(approxIdx) - 1;
                return palette[approxIdx];
            }
        </script>
</body>
</html>