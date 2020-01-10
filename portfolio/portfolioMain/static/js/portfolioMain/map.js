var map;
function initMap() {
	// Once loaded removes api connector
	$( "#map-api" ).remove();

	// creates map
	map = new google.maps.Map(document.getElementById('map'), {
    zoom: 0,
    center: {lat: 0, lng: 0}
  });

	$.get('/getmapdata', setMapMarkers)
}
	
	




function setMapMarkers(response, textStatus, jqXHR) {
	for (x of response) {
		new google.maps.Marker({
    		position: {lat: parseFloat(x.latitude), lng: parseFloat(x.longitude)},
    		map: map,
  		});
	}

}